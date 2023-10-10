package mobileAutomation.cucumber.common;

public interface SettingsPage {
	boolean SettingsDisplayed();

	boolean ABOUTDisplayed();

	boolean TermsAndConditionDisplayed();

	boolean PrivacyPolicyDisplayed();

	boolean FAQsDisplayed();

	boolean VersionDisplayed();

	boolean LogoDisplayed();
	
	boolean RideplanLogoDisplayed();

	void clickOnAllowLocationPopup() throws InterruptedException;

	void Click_ContinueAsAGuest();

	void Click_OnSkip();

	void clickOnLogoutBtn() throws InterruptedException;
	
	
}
