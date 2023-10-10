package mobileAutomation;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.AutomationName;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.net.UrlChecker;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

@Slf4j
public abstract class BaseTest {

	protected AppiumDriver<MobileElement> driver;
	protected Properties prop;
	protected Properties localization;
	private AppiumDriverLocalService service;
	private ThreadLocal<String> platform = new ThreadLocal<String>();

	DesiredCapabilities cap = new DesiredCapabilities();

	public BaseTest() {
		prop = new Properties();
		InputStream input = null;
		try {
			log.info("Loading configuration...");
			input = Thread.currentThread().getContextClassLoader().getResourceAsStream("config.properties");
			// load a properties file
			prop.load(input);
			log.info("Configuration successfully loaded...");

			log.info("Loading Application properties...");
			selectLocalizationProperties();
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

	private void selectLocalizationProperties() throws IOException {
		localization = new Properties();
		InputStream input = Thread.currentThread().getContextClassLoader()
				.getResourceAsStream("application-vic.properties");
		localization.load(input);
	}

	@BeforeSuite(alwaysRun = true)
	public void beforeSuite() throws Exception {
		if (!checkIfAppiumServerIsRunning()) {
			log.info("Create new Appium Service instance....");
			service = getAppiumServer();
			service.start();
			service.clearOutPutStreams();
		}
		log.info("Appium Server instance up and running....");
	}

	@BeforeMethod
	@Parameters("platformName")
	public void setup(String platformName) throws MalformedURLException {
		setPlatform(platformName);
		if (platformName.equals("android")) {
			setupAndroidDriver();
			log.info("Android Device Driver Created....");
		} else if (platformName.equals("iOS")) {
			setupIosDriver();
			log.info("IOS Device Driver Created....");
		}
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		testInit();
	}

	@AfterMethod
	public void tearDown() {
		if (driver != null) {
			driver.quit();
		}
	}

	@AfterSuite
	public void afterSuite() {
		if (service != null) {
			service.stop();
		}
	}

	public void testInit() {

	}

	public void setupAndroidDriver() throws MalformedURLException {
		log.info("Create Android Device Driver ....");
		cap.setCapability(MobileCapabilityType.DEVICE_NAME, prop.getProperty("androidDeviceName"));
		cap.setCapability(MobileCapabilityType.AUTOMATION_NAME, "uiautomator2");
		cap.setCapability("appPackage", prop.getProperty("androidAppPackage"));
		cap.setCapability("appActivity", prop.getProperty("androidAppActivity"));
		cap.setCapability("app", System.getenv("ANDROID_APP_LOCATION"));
		URL url = new URL(prop.getProperty("appiumURL"));
		driver = new AndroidDriver<MobileElement>(url, cap);
	}

	public void setupIosDriver() throws MalformedURLException {
		log.info("Create IOS Device Driver ....");
		cap.setCapability(MobileCapabilityType.PLATFORM_NAME, "iOS");
		cap.setCapability(MobileCapabilityType.PLATFORM_VERSION, prop.getProperty("iOSVersion"));
		cap.setCapability(MobileCapabilityType.DEVICE_NAME, prop.getProperty("iOSDeviceName"));
		cap.setCapability(MobileCapabilityType.AUTOMATION_NAME, AutomationName.IOS_XCUI_TEST);
		cap.setCapability("bundleId", prop.getProperty("iOSBundleId"));
		cap.setCapability("xcodeOrgId", "C426Z7FGCE");
		cap.setCapability("xcodeSigningId", "iPhone Developer");
		cap.setCapability(MobileCapabilityType.APP, System.getenv("IOS_APP_LOCATION"));
		URL url = new URL(prop.getProperty("appiumURL"));
		driver = new IOSDriver<MobileElement>(url, cap);
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

	private boolean checkIfAppiumServerIsRunning() throws Exception {
		final URL status = new URL(prop.getProperty("appiumURL") + "/sessions");
		try {
			new UrlChecker().waitUntilAvailable(30, TimeUnit.MILLISECONDS, status);
			return true;
		} catch (UrlChecker.TimeoutException e) {
			return false;
		}
	}

	public boolean takeScreenshot(final String name) {
		String screenshotDirectory;
		if (isLocalTestEnvironment()) {
			screenshotDirectory = String.format("%s/%s", System.getProperty("user.dir"), "screenshots");
		} else {
			screenshotDirectory = System.getProperty("appium.screenshots.dir",
					System.getProperty("java.io.tmpdir", ""));
		}
		log.info("The screen shot directory: {}", screenshotDirectory);
		File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		return screenshot.renameTo(new File(screenshotDirectory, String.format("%s.png", name)));
	}

	public String getPlatform() {
		return platform.get();
	}

	public void setPlatform(String platform2) {
		platform.set(platform2);
	}

	public boolean isLocalTestEnvironment() {
		String testEnvironment = prop.getProperty("testEnvironment");
		log.info("environment Name: {} ", testEnvironment);
		return "local".equals(testEnvironment);
	}

	public boolean isEmulatorRunning() {
		String deviceName = driver.getCapabilities().getCapability("deviceName").toString();
		log.info("Device name: {}", deviceName);
		return "emulator".equals(deviceName);
	}

}
