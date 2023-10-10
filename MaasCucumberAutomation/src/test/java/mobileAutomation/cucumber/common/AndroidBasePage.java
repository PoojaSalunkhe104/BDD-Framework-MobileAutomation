package mobileAutomation.cucumber.common;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.FindsByAndroidUIAutomator;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.touch.offset.ElementOption;
import io.appium.java_client.touch.offset.PointOption;
import lombok.extern.slf4j.Slf4j;
import mobileAutomation.cucumber.android.pages.AndroidSettingPage;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import static io.appium.java_client.touch.LongPressOptions.longPressOptions;
import static java.time.Duration.ofSeconds;

@Slf4j
public class AndroidBasePage extends BasePage {

	@AndroidFindBy(id = "android:id/button1")
	protected MobileElement retryButton;

	@AndroidFindBy(id = "racv.mobility.tripgo.staging:id/ib_core_tv_title")
	protected MobileElement happyHelp;

	public AndroidBasePage(AppiumDriver<MobileElement> driver) {
		super(driver);
	}

	@Override
	public void pressDeviceBackButton() {
		((AndroidDriver<MobileElement>) driver).pressKey(new KeyEvent(AndroidKey.BACK));
	}

	@Override
	public void pressDeviceEnterButton() {
		((AndroidDriver<MobileElement>) driver).pressKey(new KeyEvent(AndroidKey.ENTER));
	}

	@Override
	public void swipeBottom() {
		Dimension dim = driver.manage().window().getSize();
		int height = dim.getHeight();
		int width = dim.getWidth();
		int x = width / 2;
		int bottom_y = (int) (height * 0.80);
		int top_y = (int) (height * 0.10);

		TouchAction ts = new TouchAction(driver);
		ts.longPress(PointOption.point(x, top_y)).moveTo(PointOption.point(x, bottom_y)).release().perform();
	}

	@Override
	public void swipeUp() {
		Dimension dim = driver.manage().window().getSize();
		int height = dim.getHeight();
		int width = dim.getWidth();
		int x = width / 2;
		int top_y = (int) (height * 0.10);

		TouchAction ts = new TouchAction(driver);
		ts.longPress(longPressOptions()
				.withElement(
						ElementOption.element(driver.findElement(By.id("racv.mobility.tripgo.staging:id/cardHandle"))))
				.withDuration(ofSeconds(1))).moveTo(PointOption.point(x, top_y)).release().perform();
	}

	@Override
	public void scrollingToElement(String visibleText) {
		((FindsByAndroidUIAutomator<MobileElement>) driver).findElementByAndroidUIAutomator(
				"new UiScrollable(new UiSelector())" + ".scrollIntoView(text(\"" + visibleText + "\"))");
	}

	@Override
	public void hideKeyBoard() {
		driver.hideKeyboard();
	}

	@Override
	public void checkDismissNetworkError() {
		try {
			waitForVisibility(retryButton);
			log.info("Network error occurred..");
			retryButton.click();
		} catch (Exception ex) {
			log.info("No network error found...");
		}
	}

	@Override
	public void checkHappyHelpDialog() {
		try {
			waitForVisibility(happyHelp);
			log.info("Happy to help dialog is displayed..");
			retryButton.click();
		} catch (Exception ex) {
			log.info("Happy to help dialog not displayed...");
		}
	}

	public AndroidSettingPage clickOnArevoSettingPage() {
		// TODO Auto-generated method stub
		return null;
	}
}
