package mobileAutomation.cucumber.common;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.AutomationName;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.net.UrlChecker;
import org.openqa.selenium.remote.DesiredCapabilities;

import com.google.common.io.Files;


import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Date;
import java.util.HashMap;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

@Slf4j
public class Hooks {

	public static AppiumDriver<MobileElement> driver;
	private static Properties prop;
	private AppiumDriverLocalService service;
	public static ThreadLocal<String> platform = new ThreadLocal<String>();
	public static Boolean lastCaseFlag = false;

	@Getter
	@Setter
	public static String currentTag;
	DesiredCapabilities cap = new DesiredCapabilities();

	public Hooks() {
		log.info("I am in hooks constructor");
		prop = new Properties();
		InputStream input = null;
		try {
			log.info("Loading configuration...");
			input = Thread.currentThread().getContextClassLoader().getResourceAsStream("config.properties");
			// load a properties file
			prop.load(input);
			log.info("Configuration successfully loaded...");
			log.info("Loading Application properties...");
			log.info("Application properties successfully loaded...");
		} catch (IOException e) {
			log.info("Error loading on Application or Configuration setting ...");
			e.printStackTrace();
		} finally {
			if (input != null) {
				try {
					input.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

	public String getAppPath() {
		String AppPath = null;
		if (prop.getProperty("appFlavour").contains("arevo") & "iOS".equals(platform.get())) {
			AppPath = "/src/test/resources/apps/iOSApp/Arevo_no_map.zip";
		} else if (prop.getProperty("appFlavour").contains("rideplan") & "iOS".equals(platform.get())) {
			AppPath = "/src/test/resources/apps/iOSApp/TfNSW.ios.zip";
		} else if (prop.getProperty("appFlavour").contains("arevo") & "android".equals(platform.get())) {
			AppPath = "/src/test/resources/apps/androidApp/app-arevo-staging.apk";
		} else if (prop.getProperty("appFlavour").contains("rideplan") & "android".equals(platform.get())) {
			//AppPath = "/src/test/resources/apps/androidApp/app-tfnsw-staging-bitrise-signed.apk";
			AppPath = "/src/test/resources/apps/androidApp/ridePlan-v2.5.0.apk";
		}

		return AppPath;
	}

	public String getAppPackage() {
		String AppPackage = null;
		if ("android".equals(platform.get()) & prop.getProperty("appFlavour").contains("rideplan")) {
			AppPackage = prop.getProperty("rideplanandroidAppPackage");
		} else if (prop.getProperty("appFlavour").contains("rideplan") & "iOS".equals(platform.get())) {
			AppPackage = prop.getProperty("iOSRidePlanBundleId");
		} else if (prop.getProperty("appFlavour").contains("arevo") & "iOS".equals(platform.get())) {
			AppPackage = prop.getProperty("iOSArevoBundleId");
		} else if (prop.getProperty("appFlavour").contains("arevo") & "android".equals(platform.get())) {
			AppPackage = prop.getProperty("arevoandroidAppPackage");
		}

		return AppPackage;
	}

	public static AppiumDriver<MobileElement> currentDeviceDriver() {
		return driver;
	}

	public static boolean isLocalTestEnvironment() {
		String testEnvironment = prop.getProperty("testEnvironment");
		log.info("environment Name: {} ", testEnvironment);
		return testEnvironment.contains("local");
	}

	@Before(order = 1)
	public void beforeSuite(Scenario scenario) throws Exception {
		if (driver == null) {

			if (!checkIfAppiumServerIsRunning()) {
				log.info("Create new Appium Service instance....");
				service = getAppiumServer();
				service.start();
				service.clearOutPutStreams();
			}  
			log.info("Appium Server instance up and running....");
			setup(scenario);
		}  

	}

	public void setup(Scenario scenario) throws MalformedURLException {
		String platformName = platform.get(); // This value available when running from XML file
		if ("android".equals(platformName) || scenario.getSourceTagNames().contains("@android")) {
			setupAndroidDriver();
			log.info("Android Device Driver Created....");
			setCurrentTag("@android");
		} else if ("iOS".equals(platformName) || scenario.getSourceTagNames().contains("@iOS")) {
			setupIosDriver();
			setCurrentTag("@iOS");
			log.info("IOS Device Driver Created....");
		}
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@After(order = 1)
	public void afterTest(Scenario scenario) {
		
		if(scenario.isFailed()) {
			final byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
		      scenario.attach(screenshot, "image/png", "image"); 
					}

		
		if (driver != null & lastCaseFlag != true) {
			if ("android".equals(platform.get())) {
				driver.closeApp();
				driver.launchApp();
			} else {
				driver.resetApp();
			}

		}
	}

	@After("@lastTest")
	public void afterSuite(Scenario scenario) {
		if(scenario.isFailed()) {
			final byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
		      scenario.attach(screenshot, "image/png", "image"); 
					}
		driver.removeApp(this.getAppPackage());
		driver.quit();
		lastCaseFlag = true;

	}

	private boolean checkIfAppiumServerIsRunning() throws Exception {
		final URL status = new URL(prop.getProperty("appiumURL") + "/sessions");
		try {
			new UrlChecker().waitUntilAvailable(300, TimeUnit.MILLISECONDS, status);
			return true;
		} catch (UrlChecker.TimeoutException e) {
			return false;
		}
	}

	public AppiumDriverLocalService getAppiumServer() {
		HashMap<String, String> environment = new HashMap<String, String>();
		environment.put("ANDROID_HOME", System.getenv("ANDROID_HOME"));
		environment.put("JAVA_HOME", System.getenv("JAVA_HOME"));
		AppiumServiceBuilder builder = new AppiumServiceBuilder()
				.withAppiumJS(new File(System.getenv("APPIUM_HOME") + "/main.js"))
				.usingDriverExecutable(new File(System.getenv("NODE_HOME"))).usingPort(4723)
				.withArgument(GeneralServerFlag.SESSION_OVERRIDE).withArgument(GeneralServerFlag.LOG_LEVEL, "debug")
				.withEnvironment(environment).withLogFile(new File("ServerLogs/server.log"));
		return AppiumDriverLocalService.buildService(builder);
	}

	public static void setPlatform(String platform2) {
		platform.set(platform2);
	}

	public void setupAndroidDriver() throws MalformedURLException {
		log.info("Create Android Device Driver ....");
		cap.setCapability(MobileCapabilityType.DEVICE_NAME, "Pixel 5 API 28");
		cap.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
		cap.setCapability(MobileCapabilityType.AUTOMATION_NAME, "uiautomator2");
		cap.setCapability("appPackage", prop.getProperty(this.getAppPackage()));
		cap.setCapability("appActivity", prop.getProperty("rideplanandroidAppActivity"));
		cap.setCapability(MobileCapabilityType.APP, System.getProperty("user.dir") + this.getAppPath());
		cap.setCapability("noReset", "false");
		cap.setCapability("noReset", "true");
		URL url = new URL(prop.getProperty("appiumURL"));
		driver = new AndroidDriver<MobileElement>(url, cap);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	public void setupIosDriver() throws MalformedURLException {
		log.info("Create IOS Device Driver ....");
		cap.setCapability(MobileCapabilityType.PLATFORM_NAME, "iOS");
		cap.setCapability(MobileCapabilityType.PLATFORM_VERSION, prop.getProperty("iOSVersion"));
		cap.setCapability(MobileCapabilityType.DEVICE_NAME, prop.getProperty("iOSDeviceName"));
		cap.setCapability(MobileCapabilityType.AUTOMATION_NAME, AutomationName.IOS_XCUI_TEST);
		cap.setCapability("xcodeOrgId", "C426Z7FGCE");
		cap.setCapability("xcodeSigningId", "iPhone Developer");
		cap.setCapability("autoAcceptAlerts", "true");
		cap.setCapability("autoGrantPermissions", "true");
		cap.setCapability("noReset", "true");
		cap.setCapability("full-reset", "false");
		cap.setCapability(MobileCapabilityType.APP, System.getProperty("user.dir") + this.getAppPath());
		URL url = new URL(prop.getProperty("appiumURL"));
		driver = new IOSDriver<MobileElement>(url, cap);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}
	
	
	
}
