package mobileAutomation.cucumber.common;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import lombok.extern.slf4j.Slf4j;
import java.time.Duration;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


@Slf4j
public class iOSBasePage extends BasePage {

	public iOSBasePage(AppiumDriver<MobileElement> driver) {
		super(driver);
	}
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='Return']")
	protected MobileElement hideKeyboard;

	@Override
	public void pressDeviceBackButton() {
	}

	@Override
	public void pressDeviceEnterButton() {
	}

	@Override
	public void swipeBottom() {
	}

	@Override
	public void swipeUp() {
		Dimension size = driver.manage().window().getSize();
		int startX = (int) (size.width * 0.5);
		int startY = (int) (size.height * 0.9);
		int endX = (int) (size.width * 0.5);
		int endY = (int) (size.height * 0.1);
		TouchAction touch = new TouchAction(driver);
		touch.press(PointOption.point(startX, startY)).waitAction(WaitOptions.waitOptions(Duration.ofMillis(1000)))
				.moveTo(PointOption.point(endX, endY)).release();
	
	}

	@Override
	public void scrollingToElement(String visibleText) {
	}

	@Override
	public void hideKeyBoard() {
		if(hideKeyboard.isDisplayed()) {
			hideKeyboard.click();
		} else {
			driver.hideKeyboard();
		}
	}

	@Override
	public void checkDismissNetworkError() {
	}

	@Override
	public void checkHappyHelpDialog() {
	}

	@Override
	public void waitForVisibility(MobileElement e) {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOf(e));
	}

	

	
	

}
