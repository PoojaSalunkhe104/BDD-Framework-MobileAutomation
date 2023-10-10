package mobileAutomation.cucumber.android.pages;

import org.openqa.selenium.By;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import mobileAutomation.cucumber.common.AndroidBasePage;
import mobileAutomation.cucumber.common.DashboardPage;


public class AndroidDashboardPage extends AndroidBasePage implements DashboardPage {

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='PT stops']")
	private MobileElement PT_stops_button;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Bike routes']")
	private MobileElement Bike_routes_button;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Parking']")
	private MobileElement Parking;

	@AndroidFindBy(xpath = "//android.widget.ImageButton[@content-desc='Center current location']")
	private MobileElement Re_position_map_to_your_location;

	@AndroidFindBy(xpath = "//android.widget.ImageView[@resource-id='racv.mobility.tripgo.staging:id/cardHandle']")
	private MobileElement GrabBar;

	@AndroidFindBy(xpath = "//XCUIElementTypeImage[@id='racv.mobility.tripgo.staging:id/whereToTitle']")
	private MobileElement Search;

	@AndroidFindBy(id = "com.android.packageinstaller:id/permission_allow_button")
	private MobileElement AllowLocationPopUp;
	
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='PT stops']/../../../../android.widget.FrameLayout[2]")
	private MobileElement SettingsButton;
	
	@AndroidFindBy(id = "com.android.packageinstaller:id/permission_allow_button")
	private MobileElement AllowAccess;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Hi there!']")
	private MobileElement RidePlanHithereText;

	@AndroidFindBy(xpath = "//android.widget.FrameLayout[@content-desc='carousel, content']/android.widget.LinearLayout/android.widget.TextView[2]")
	private MobileElement RidePlanEnjoyYourBikeRideText;

	@AndroidFindBy(xpath = "//android.widget.FrameLayout[@content-desc='carousel, content']//android.widget.FrameLayout")
	private MobileElement RidePlanImage;

	@AndroidFindBy(xpath = "//android.widget.TextView[@content-desc='Continue, button']")
	private MobileElement RidePlancontinueButton;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='This is so we can provide accurate routing and turn by turn navigation.']")
	private MobileElement ridePlanHeaderText2;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Stay on track with real time departure times by tapping pins on the map.']")
	private MobileElement ridePlanHeaderText1;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Favourite places and transport stops']")
	private MobileElement ridePlanLugAndCarrieHeader;

	@AndroidFindBy(xpath = "//android.widget.Button[@text='CONTINUE AS GUEST']")
	private MobileElement guestButton;

	@AndroidFindBy(id = "racv.mobility.tripgo.staging:id/image")
	private MobileElement launchPageImage;

	@AndroidFindBy(id = "racv.mobility.tripgo.staging:id/btnSkip")
	private MobileElement skipButton;

	@AndroidFindBy(id = "racv.mobility.tripgo.staging:id/title")
	private MobileElement launchPageText;
	

	@AndroidFindBy(id = "racv.mobility.tripgo.staging:id/infoLabel")
	private MobileElement infoLabel;

	@AndroidFindBy(id = "racv.mobility.tripgo.staging:id/txtTermsOfUse")
	private MobileElement termsOfUseLink;

	@AndroidFindBy(id = "racv.mobility.tripgo.staging:id/txtPrivacyCharter")
	private MobileElement privacyNoticeLink;
	
	@AndroidFindBy(id = "racv.mobility.tripgo.staging:id/label_or")
	private MobileElement labelOr;

	@AndroidFindBy(id = "racv.mobility.tripgo.staging:id/btnSignInWithMobile")
	private MobileElement signInWithMobileButton;
	
	@AndroidFindBy(className = "android.widget.ImageView")
	private MobileElement homePageImage;

	@AndroidFindBy(xpath = "//android.widget.Button[@text='While using the app']") //Only this time   //Don’t allow
    private MobileElement AllowwhileUsingTheApp;
	
	@AndroidFindBy(id = "racv.mobility.tripgo.staging:id/title_intro")
	private MobileElement homePageTitle;
	
	@AndroidFindBy(xpath = "//android.widget.Button[@text='Allow']")
	private MobileElement AllowMediaPopUp;
	
	
	public AndroidDashboardPage(AppiumDriver<MobileElement> driver) {
		super(driver);
	}

	@Override
	public boolean PT_stops_buttonDisplayed() {
		return PT_stops_button.isDisplayed();
	}

	@Override
	public boolean Bike_routes_buttonDisplayed() {
		return Bike_routes_button.isDisplayed();
	}

	@Override
	public boolean ParkingDisplayed() {
		return Parking.isDisplayed();
	}

	@Override
	public boolean Re_position_map_to_your_locationDisplayed() {
		return Re_position_map_to_your_location.isDisplayed();
	}

	@Override
	public boolean GrabBarDisplayed() {
		return GrabBar.isDisplayed();
	}

	@Override
	public boolean SearchDisplayed() {
		return Search.isDisplayed();
	}

	@Override
	public void clickOnAllowAndroidLocationPopUP() {
		super.waitForVisibility(driver.findElement(By.id("com.android.packageinstaller:id/permission_allow_button")));
		AllowLocationPopUp.click();
	}

	@Override
	public AndroidSettingPage clickOnSettingPage() {
		super.waitForVisibility(driver.findElement(By.xpath("//android.widget.TextView[@text='PT stops']/../../../../android.widget.FrameLayout[2]")));
		SettingsButton.click();
		return new AndroidSettingPage(this.driver);

	}
	@Override
	public void clickOnAllowLocationSystemPopUp() {
		    super.waitForVisibility(AllowwhileUsingTheApp);
		    AllowwhileUsingTheApp.click();
			super.waitForVisibility(AllowMediaPopUp);
			AllowMediaPopUp.click();
			
			}
	

	@Override
	public void clickOnAllowLocationMediaPopUp() {
		super.waitForVisibility(AllowwhileUsingTheApp);
		AllowwhileUsingTheApp.click();
	}
	
	@Override
	public boolean skipButtonDisplayed() {
		AllowLocationPopUp.isDisplayed();
		AllowLocationPopUp.click();
		return true;
	}

	@Override
	public void RidePlanHithereText() {
		RidePlanHithereText.isDisplayed();
	}

	@Override
	public void RidePlanHeaderText() {
		RidePlanEnjoyYourBikeRideText.isDisplayed();
	}

	@Override
	public void RidePlanImage() {
		RidePlanImage.isDisplayed();
	}

	@Override
	public void RidePlancontinueButton() {
		RidePlancontinueButton.isDisplayed();
		RidePlancontinueButton.click();
	}

	@Override
	public boolean ridePlanHeaderText1() {
		return ridePlanHeaderText1.isDisplayed();
	}

	@Override
	public boolean ridePlanLugAndCarrieHeader() {
		super.Sleep();
		super.waitForVisibility(driver
				.findElement(By.xpath("//android.widget.TextView[@text='Favourite places and transport stops']")));
		return ridePlanLugAndCarrieHeader.isDisplayed();
	}

	@Override
	public boolean ridePlanHeaderText2() {
		super.Sleep();
		super.waitForVisibility(driver.findElement(By.xpath(
				"//android.widget.TextView[@text='This is so we can provide accurate routing and turn by turn navigation.']")));
		return ridePlanHeaderText2.isDisplayed();
	}

	@Override
	public void ClickcontinueAsGuestButton() {
		super.waitForVisibility(driver.findElement(By.xpath("//android.widget.Button[@text='CONTINUE AS GUEST']")));
		guestButton.click();
	}

	@Override
	public boolean RidePlancontinueButtonIsDisplayed() {
		return RidePlancontinueButton.isDisplayed();
	}

	@Override
	public boolean walkThroughPage1ImageDisplayed() {
		return launchPageImage.isDisplayed();
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
	public boolean privacyNoticeLinkDisplayed() {
		return privacyNoticeLink.isDisplayed();
	}

	@Override
	public boolean signInButtonDisplayed() {
		return signInWithMobileButton.isDisplayed();
	}

	@Override
	public String validateOrLabel() {
		return labelOr.getText();
	}

	@Override
	public boolean continueAsGuestButtonDisplayed() {
		return guestButton.isDisplayed();
	}

	@Override
	public String validateInfoLabel() {
		return infoLabel.getText();
	}

	@Override
	public boolean termsOfUseLinkDisplayed() {
		return termsOfUseLink.isDisplayed();
	}

	@Override
	public boolean appLogoDisplayed() {
		return homePageImage.isDisplayed();
	}

	@Override
	public boolean homePageTextDisplayed() {
		return homePageTitle.isDisplayed();
	}
	
	public void clickOnAllowLocationPopUP() {
	
	}

	@Override
	public boolean PTStopDisplayedWith3OnboardingPage() {
		return false;
		
	}

	@Override
	public void Click_ContinueAsAGuest() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void clickOnAllowLocationPopup() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void Click_OnSkip() {
		// TODO Auto-generated method stub
		
	}
	
	

}
