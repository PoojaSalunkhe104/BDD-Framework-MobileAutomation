package mobileAutomation.cucumber.ios.pages;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import io.appium.java_client.AppiumDriver;
import mobileAutomation.cucumber.common.SettingsPage;
import mobileAutomation.cucumber.common.iOSBasePage;

public class iOSSettingPage extends iOSBasePage implements SettingsPage {

	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='setting_ic']")
	private MobileElement Settings_title;

	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=‘ABOUT']")
	private MobileElement ABOUT;

	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='Terms of Use']")
	private MobileElement TermsandCondition;

	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='Privacy Notice']")
	private MobileElement Privacy_Policy;

	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='FAQs']")
	private MobileElement FAQs;

	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='VERSION']")
	private MobileElement Version;

	@iOSXCUITFindBy(xpath = "//XCUIElementTypeImage[@name='Arevo_Logo']")
	private MobileElement Arevo_Logo;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeImage[@name='TFNSW_logo']")
	private MobileElement RidePlan_Logo;
	
	@iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`label == 'Allow While Using App'`]")
	private MobileElement AllowWhileUsingApp;  
	    
	@iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`label == 'CONTINUE AS GUEST'`]")
    private MobileElement Continue_As_a_guest; 
	
	@iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`label == 'SKIP'`]")
	private MobileElement skip;
	
	@AndroidFindBy(id = "com.intelematics.maas.rideplan.staging:id/btnSignOut")
	private MobileElement LogOut;
	
	@Override
	public void Click_OnSkip() {
		
		try {
			super.waitForVisibility(skip);
			skip.click();
		} catch (Exception e) {
	    } 
	}
	
	@Override
	public void clickOnLogoutBtn() throws InterruptedException
	    {

		   		try {
		   			
		   			if(LogOut.isDisplayed())
		   			{
		   				LogOut.click();
		   				Thread.sleep(2000);
		   			}
		   			
		   		} catch (Exception e) {
		   	    } 
		   		
		 }
	    
	@Override
	public void Click_ContinueAsAGuest() 
	{
			// TODO Auto-generated method stub
			try {
				super.waitForVisibility(Continue_As_a_guest);
				Continue_As_a_guest.click();
			} catch (Exception e) {
			     // System.out.println("Something went wrong.");
		    } 
	}
	    

	public iOSSettingPage(AppiumDriver<MobileElement> driver) {
		super(driver);

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
	
	public boolean SettingsDisplayed() {
		return Settings_title.isDisplayed();
	}

	public boolean TermsAndConditionDisplayed() {
		return TermsandCondition.isDisplayed();
	}

	public boolean PrivacyPolicyDisplayed() {
		return Privacy_Policy.isDisplayed();
	}

	public boolean FAQsDisplayed() {
		return FAQs.isDisplayed();
	}

	public boolean VersionDisplayed() {
		return Version.isDisplayed();
	}

	public boolean LogoDisplayed() {
		return Arevo_Logo.isDisplayed();
	}
	public boolean RideplanLogoDisplayed() {
		return RidePlan_Logo.isDisplayed();
	}

	@Override
	public boolean ABOUTDisplayed() {
		return false;
	}

}
