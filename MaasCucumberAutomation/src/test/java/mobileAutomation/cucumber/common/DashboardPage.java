package mobileAutomation.cucumber.common;


public interface DashboardPage {
	boolean PT_stops_buttonDisplayed();

	boolean Bike_routes_buttonDisplayed();

	boolean ParkingDisplayed();

	boolean Re_position_map_to_your_locationDisplayed();

	boolean GrabBarDisplayed();

	boolean SearchDisplayed();

	void clickOnAllowLocationSystemPopUp();
	
	SettingsPage clickOnSettingPage();

	void RidePlancontinueButton();

	boolean ridePlanLugAndCarrieHeader();

	boolean ridePlanHeaderText1();

	void RidePlanImage();

	void RidePlanHeaderText();

	void RidePlanHithereText();

	boolean skipButtonDisplayed();

	void clickOnAllowAndroidLocationPopUP();

	boolean ridePlanHeaderText2();

	void ClickcontinueAsGuestButton();

	boolean RidePlancontinueButtonIsDisplayed();

	boolean walkThroughPage1ImageDisplayed();

	String walkThoughPage1Text();

	void clickOnSkipButton();

	String validateOrLabel();

	boolean privacyNoticeLinkDisplayed();

	boolean homePageTextDisplayed();

	boolean continueAsGuestButtonDisplayed();

	boolean termsOfUseLinkDisplayed();

	String validateInfoLabel();

	boolean signInButtonDisplayed();

	boolean appLogoDisplayed();

	void clickOnAllowLocationMediaPopUp();

	void clickOnAllowLocationPopUP();

	boolean PTStopDisplayedWith3OnboardingPage();

	void Click_ContinueAsAGuest();
	void clickOnAllowLocationPopup() throws InterruptedException;

	void Click_OnSkip();

	}
