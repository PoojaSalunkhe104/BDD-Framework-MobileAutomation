package mobileAutomation.cucumber.ios.pages;


import org.openqa.selenium.By;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import io.appium.java_client.touch.offset.PointOption;
import mobileAutomation.cucumber.common.DashboardPage;
import mobileAutomation.cucumber.common.SettingsPage;
import mobileAutomation.cucumber.common.iOSBasePage;

public class iOSDashboardPage extends iOSBasePage implements DashboardPage {
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='PT stops']")
	private MobileElement PT_stops_button;

	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='Bike routes']")
	private MobileElement Bike_routes_button;

	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='Parking']")
	private MobileElement Parking;

	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='Map legend']")
	private MobileElement Re_position_map_to_your_location;

	@iOSXCUITFindBy(xpath = "//XCUIElementTypeImage[@name='GrabBar']")
	private MobileElement GrabBar;

	@iOSXCUITFindBy(xpath = "//XCUIElementTypeImage[@name='Search']")
	private MobileElement Search;

	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='Allow While Using App']")
	private MobileElement AllowLocationPopUp;

	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='setting_ic']")
	private MobileElement Settings_title;

	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Continue']")
	private MobileElement RidePlancontinueButton;

	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Stay on track with real time departure times by tapping pins on the map.']")
	private MobileElement ridePlanHeaderText1;

	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Favourite places and transport stops']")
	private MobileElement ridePlanLugAndCarrieHeader;

	@iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name='intercom image']")
	private MobileElement RidePlanImage;

	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Enjoy your bike ride while ']")
	private MobileElement RidePlanHeaderText;

	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Hi there!']")
	private MobileElement RidePlanHithereText;

	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='SKIP']")
	private MobileElement skipButton;

	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='This is so we can provide accurate routing and turn by turn navigation.']")
	private MobileElement ridePlanHeaderText2;

	@iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeImage[`label == \"Walkthrough_Page_1\"`]")
	private MobileElement launchPageImage;

	@iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeStaticText[`label == \"Check live departure times on your way out the door.\"`]")
	private MobileElement launchPageText;

	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='OR']")
	private MobileElement orLabel;

	@iOSXCUITFindBy(accessibility = "Privacy Policy")
	private MobileElement privacyPolicy;

	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='user-onboarding']")
	private MobileElement homePageText;

	@iOSXCUITFindBy(xpath = "//XCUIElementTypeImage[@name='Arevo_Logo']")
	private MobileElement appLogo;

	@iOSXCUITFindBy(accessibility = "sign-in-with-mobile-button")
	private MobileElement signInWithMobile;

	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='By continuing, you agree to the']")
	private MobileElement byContinuingAgreeText;

	@iOSXCUITFindBy(accessibility = "Terms of Use")
	private MobileElement termsOfUse;

	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='continue-as-guest-button']")
	private MobileElement continueButton;

	@iOSXCUITFindBy(xpath = "//XCUIElementTypePageIndicator[@value='page 1 of 4']")
	private MobileElement intercomPages;    
	
	@iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`label == 'Allow While Using App'`]")
	private MobileElement AllowWhileUsingApp;  
	
	@iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`label == 'CONTINUE AS GUEST'`]")
	private MobileElement Continue_As_a_guest; 
    
	@iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`label == 'SKIP'`]")
	private MobileElement skip; 
	 
	public iOSDashboardPage(AppiumDriver<MobileElement> driver) {
		super(driver);

	}

	 @Override
		public void Click_OnSkip() {
			
			try {
				super.waitForVisibility(skip);
				skip.click();
			} catch (Exception e) {
		    } 
		}
	    
	 
	public boolean PT_stops_buttonDisplayed() {
        return PT_stops_button.isDisplayed();
	}

	public boolean Bike_routes_buttonDisplayed() {
		return Bike_routes_button.isDisplayed();
	}

	public boolean ParkingDisplayed() {
		return Parking.isDisplayed();
	}

	public boolean Re_position_map_to_your_locationDisplayed() {
		return Re_position_map_to_your_location.isDisplayed();
	}

	public boolean GrabBarDisplayed() {
		return GrabBar.isDisplayed();
	}

	public boolean SearchDisplayed() {
		return Search.isDisplayed();
	}

	public void clickOnAllowLocationPopUP() {

		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		TouchAction touchAction = new TouchAction(driver);
		touchAction.tap(PointOption.point(207, 556)).perform();
		//AllowWhileUsingApp.click();
	}

	@Override
	public SettingsPage clickOnSettingPage() {
		super.waitForVisibility(driver.findElement(By.xpath("//XCUIElementTypeButton[@name='setting_ic']")));
		Settings_title.click();
		return new iOSSettingPage(this.driver);
	}

	@Override
	public void clickOnAllowLocationSystemPopUp() {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		TouchAction touchAction = new TouchAction(driver);
		touchAction.tap(PointOption.point(207, 556)).perform();
	}

	@Override
	public boolean RidePlancontinueButtonIsDisplayed() {
		super.waitForVisibility(RidePlancontinueButton);
		return RidePlancontinueButton.isDisplayed();
	}

	@Override
	public void RidePlancontinueButton() {
		RidePlancontinueButton.isDisplayed();
		RidePlancontinueButton.click();
	}

	@Override
	public boolean ridePlanLugAndCarrieHeader() {
		super.waitForVisibility(ridePlanLugAndCarrieHeader);
		return ridePlanLugAndCarrieHeader.isDisplayed();
	}

	@Override
	public boolean ridePlanHeaderText1() {
		return ridePlanHeaderText1.isDisplayed();
	}

	@Override
	public void RidePlanImage() {
		RidePlanImage.isDisplayed();
	}

	@Override
	public void RidePlanHeaderText() {
		RidePlanHeaderText.isDisplayed();
	}

	@Override
	public void RidePlanHithereText() {
		RidePlanHithereText.isDisplayed();
	}

	@Override
	public boolean skipButtonDisplayed() {
		boolean result;
		if (skipButton.isDisplayed()) {
			result = true;
		} else {
			result = false;
		}
		return result;
	}

	@Override
	public void clickOnAllowAndroidLocationPopUP() {
	}

	@Override
	public boolean ridePlanHeaderText2() {
		super.Sleep();
		super.waitForVisibility(driver.findElement(By.xpath(
				"//XCUIElementTypeStaticText[@name='This is so we can provide accurate routing and turn by turn navigation.']")));
		return ridePlanHeaderText2.isDisplayed();
	}

	@Override
	public void ClickcontinueAsGuestButton() {
		continueButton.click();
	}

	@Override
	public boolean walkThroughPage1ImageDisplayed() {
		return launchPageImage.isEnabled();
	}

	@Override
	public String walkThoughPage1Text() {
		return launchPageText.getText();
	}

	@Override
	public void clickOnSkipButton() {
		skipButton.click();
	}

	@Override
	public String validateOrLabel() {
		return orLabel.getText();
	}

	@Override
	public boolean privacyNoticeLinkDisplayed() {
		return privacyPolicy.isDisplayed();
	}

	@Override
	public boolean appLogoDisplayed() {
		super.waitForVisibility(
				driver.findElement(By.xpath("//XCUIElementTypeButton[@name='continue-as-guest-button']")));
		return appLogo.isDisplayed();
	}

	@Override
	public boolean signInButtonDisplayed() {
		return signInWithMobile.isDisplayed();
	}

	@Override
	public String validateInfoLabel() {
		return byContinuingAgreeText.getText();
	}

	@Override
	public boolean termsOfUseLinkDisplayed() {
		return termsOfUse.isDisplayed();
	}

	@Override
	public boolean continueAsGuestButtonDisplayed() {
		return continueButton.isDisplayed();
	}

	@Override
	public boolean homePageTextDisplayed() {
		return homePageText.isDisplayed();
	}

	@Override
	public void clickOnAllowLocationMediaPopUp() {
	}

	@Override
	public boolean PTStopDisplayedWith3OnboardingPage() {
		int t = driver.findElements(By.xpath("//XCUIElementTypeButton[@name='PT stops']")).size();
		if (t > 0) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public void Click_ContinueAsAGuest() {
		try {
			super.waitForVisibility(Continue_As_a_guest);
			Continue_As_a_guest.click();
		} catch (Exception e) {
		     // System.out.println("Something went wrong.");
	    } 		
	}

	@Override
	public void clickOnAllowLocationPopup() throws InterruptedException {
		try {
   			AllowWhileUsingApp.click();
   			Thread.sleep(5000);
   		} catch (Exception e) {
   		      System.out.println("Pop-Up not display");
   	    } 
   		
   		Thread.sleep(5000);		
	}

}
