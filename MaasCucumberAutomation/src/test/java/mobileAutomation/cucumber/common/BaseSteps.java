package mobileAutomation.cucumber.common;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

@Slf4j
public class BaseSteps {

	public static Properties prop;
	protected static Properties localization;
	public static String applicationFlavour;
	public static AppiumDriver<MobileElement> driver;
	public static AppiumDriverLocalService service;
	String IOSArevoAppPath = "/src/test/resources/apps/iOSApp/Arevo.ios.zip";
	static String IOSRidePlanAppPath = "/src/test/resources/apps/iOSApp/TfNSW_Staging_New.zip";
	@Getter
	@Setter
	public static String currentTag;
	

	public BaseSteps() {
		log.info("I am in {} constructor", this.getClass().getSimpleName());
		InputStream input = null;
		try {
			log.info("Loading configuration...");
			// input =
			Thread.currentThread().getContextClassLoader().getResourceAsStream("config.properties");
			log.info("Loading Application properties...");
			selectLocalizationProperties();
			log.info("Application properties successfully loaded...");
		} catch (IOException e) {
			log.info("Error loading on Application or Configuration setting ...");
			e.printStackTrace();
		}

		prop = new Properties();
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
		}
		
		applicationFlavour = prop.getProperty("appFlavour");

	}

	private void selectLocalizationProperties() throws IOException {
		localization = new Properties();
		InputStream input = Thread.currentThread().getContextClassLoader()
				.getResourceAsStream("application-vic.properties");
		localization.load(input);
	}
	public static boolean isLocalTestEnvironment() {
		String testEnvironment = prop.getProperty("testEnvironment");
		log.info("environment Name: {} ", testEnvironment);
		return testEnvironment.contains("local");
	}
	
	public boolean takeScreenshot(final String name, AppiumDriver<MobileElement> driver) {
		String screenshotDirectory;
		if (this.isLocalTestEnvironment()) {
			screenshotDirectory = String.format("%s/%s", System.getProperty("user.dir"), "screenshots");
		} else {
			screenshotDirectory = System.getProperty("appium.screenshots.dir",
					System.getProperty("java.io.tmpdir", ""));
		}
		log.info("The screen shot directory: {}", screenshotDirectory);
		File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		return screenshot.renameTo(new File(screenshotDirectory, String.format("%s.png", name)));
	}
	
	
}
