package mobileAutomation.cucumber.android.pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import mobileAutomation.cucumber.common.AndroidBasePage;
import mobileAutomation.cucumber.common.SettingsPage;

public class AndroidSettingPage extends AndroidBasePage implements SettingsPage {
	
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Settings']")
	private MobileElement Settings_title;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='ABOUT']")
	private MobileElement ABOUT;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Terms of Use']")
	private MobileElement TermsandCondition;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Privacy Notice']")
	private MobileElement Privacy_Policy;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='FAQs']")
	private MobileElement FAQs;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='VERSION']")
	private MobileElement Version;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='VERSION']/../android.widget.ImageView")
	private MobileElement Arevo_Logo;
	
	@AndroidFindBy(id = "com.intelematics.maas.rideplan.staging:id/btnSignOut")
	private MobileElement LogOut;
	

	public AndroidSettingPage(AppiumDriver<MobileElement> driver) {
		super(driver);
	}
	
	 @Override
	public void clickOnAllowLocationPopup() throws InterruptedException
    {

	   		try {
	   			
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
		super.scrollingToElement("VERSION");
		return Version.isDisplayed();
	}

	public boolean LogoDisplayed() {
		return Arevo_Logo.isDisplayed();
	}

	@Override
	public boolean ABOUTDisplayed() {
		return false;
	}

	@Override
	public boolean RideplanLogoDisplayed() {
		return Arevo_Logo.isDisplayed();
			}

	@Override
	public void Click_ContinueAsAGuest() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void Click_OnSkip() {
		// TODO Auto-generated method stub
		
	}

}
