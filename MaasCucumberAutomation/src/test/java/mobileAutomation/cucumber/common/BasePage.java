package mobileAutomation.cucumber.common;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.restassured.RestAssured;
import lombok.extern.slf4j.Slf4j;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

@Slf4j
public abstract class BasePage {

	protected AppiumDriver<MobileElement> driver;

	public BasePage(AppiumDriver<MobileElement> driver) {
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}

	abstract void pressDeviceBackButton();

	abstract void pressDeviceEnterButton();

	abstract void swipeBottom();

	abstract void swipeUp();

	abstract void scrollingToElement(String visibleText);

	abstract void hideKeyBoard();

	public void waitForVisibility(MobileElement e) {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOf(e));
	}

	public void click(MobileElement e) {
		waitForVisibility(e);
		e.click();
	}

	public void sendKeys(MobileElement e, String txt) {
		waitForVisibility(e);
		e.sendKeys(txt);
	}

	public void clear(MobileElement e) {
		waitForVisibility(e);
		e.clear();
	}

	abstract void checkDismissNetworkError();

	abstract void checkHappyHelpDialog();
	
	public void Sleep() {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public String journeyAPIAutomation() {
			RestAssured.baseURI = "https://e-arevo-api-sandbox-ia.au-s1.cloudhub.io/api/journeys";
			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
			String recordedTimeStamp = df.format(new Date()) + "T12:00:00+11:00";
			String currentDateTime = df.format(new Date()) + "T12:00:00%2b11:00";
			String Response = RestAssured.given().param("from", "-37.83648808928422,144.91998191574137")
					.param("to", "-37.83474671686244,144.93430437336806").param("departBy", currentDateTime)
					.param("optimise", "time").param("transportTypes", "bus").header("recordedTimeStamp", recordedTimeStamp)
					.header("deviceId", "integration_testing-----------").header("sessionId", "a1b2-c3d4-e5f6-g7h8-i9j0")
					.header("client_id", "da05f3e4dd714c95bb414fb8980fb4b4")
					.header("client_secret", "11827910410947Cbbd6e7d81E7eDD4f6").get().getBody().asString();

			return Response ;

		}
	}



