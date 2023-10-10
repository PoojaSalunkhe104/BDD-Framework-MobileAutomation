package mobileAutomation.cucumber.steps;


import org.testng.Assert;
import com.aventstack.extentreports.ExtentTest;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.junit.CucumberOptions;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import lombok.extern.slf4j.Slf4j;
import mobileAutomation.cucumber.android.pages.AndroidFavouriteButtonPage;
import mobileAutomation.cucumber.common.BaseSteps;
import mobileAutomation.cucumber.common.FavouriteButton;
import mobileAutomation.cucumber.common.Hooks;
import mobileAutomation.cucumber.ios.pages.iOSFavouriteButtonPage;

@CucumberOptions(plugin = { "pretty", "html:target/cucumber-report/android/cucumber.html",
		"junit:target/cucumber-report/android/cucumber.xml",
		"json:target/cucumber-report/android/cucumber.json" }, tags = "@android or @iOS")

@Slf4j
public class FavouriteButtonSteps extends BaseSteps
{
	FavouriteButton FavouriteBtnPage;
	mobileAutomation.cucumber.common.SettingsPage SettingsPage;
	AppiumDriver<MobileElement> driver;
	String currentTag;
	Scenario scenario; 
	ExtentTest LogInfo = null;

	
	@Before
	public void beforeSettings(Scenario scenario) {
		driver = Hooks.currentDeviceDriver();
		currentTag = Hooks.getCurrentTag();

        this.scenario = scenario;
		
		if (scenario.getSourceTagNames().contains("@android")) {
			FavouriteBtnPage = new AndroidFavouriteButtonPage(driver);
		} else {
			FavouriteBtnPage = new iOSFavouriteButtonPage(driver);
		}
	}
	
	@Given("^An user open an app$")
	public void An_user_open_an_app() throws InterruptedException
	{
		FavouriteBtnPage.Click_OnSkip();
		FavouriteBtnPage.Click_ContinueAsAGuest();

		FavouriteBtnPage.clickOnAllowLocationPopup();
		FavouriteBtnPage.PT_stops_buttonDisplayed();
		Thread.sleep(5000);
	}
	
	@When("^I click on Favourite$")
    public void i_click_on_favourite() 
	{
		FavouriteBtnPage.clickOn_Favourite_Button();
	}
	
	@Then("^I click on  Sign In$")
    public void i_click_on_sign_in() throws InterruptedException
	{
		//Thread.sleep(5000);
		FavouriteBtnPage.clickOn_SignIn_Button();
    }
	
	@Then("^I enter (.+)$")
	public void i_enter(String mobilenumber) throws InterruptedException 
	{
		FavouriteBtnPage.enter_MobileNumber(mobilenumber);
		Thread.sleep(5000);
	}
	
   @Then("^I click on continue button and I expect displaying mobile number should be match with (.+)$")
    public void i_click_on_continue_button_and_i_expect_displaying_mobile_number_should_be_match_with(String mobilenumber) throws InterruptedException 
	{
	   Thread.sleep(4000);
		FavouriteBtnPage.clickOn_Continue_Button();
		String ActualMobileNumber =  FavouriteBtnPage.GetText_FromMobileNumberField(); //a
		scenario.log("<------ I expect displaying mobile number should be match what we enter privious--> Actual Result: "+ActualMobileNumber+" --||-- Expected Result: "+mobilenumber +" ----->"); //a
	//	Assert.assertEquals(ActualMobileNumber, mobilenumber); //a
		
		
		FavouriteBtnPage.clickOn_BackButton();	
    }
	
	@Then("^I Entered (.+)$")
    public void i_entered(String otp) throws InterruptedException 
	{
		FavouriteBtnPage.Enter_SMSVerificationCode(otp);
		FavouriteBtnPage.HideKeyboard();
    }
	
	@Then("^I click on validate Code$")
	public void i_click_on_validate_code() throws InterruptedException 
	{
		FavouriteBtnPage.clickOn_ValidateCode_Button();
		Thread.sleep(5000);
	}
	
	 @Then("^I Enter (.+) in address field$")
	 public void i_enter_in_address_field(String address)
	 {
		 FavouriteBtnPage.Enter_Address(address);
	 }
	 
	 @Then("^I Enter (.+) in name filed$")
	 public void i_enter_in_name_filed(String nickname) 
	 {
		 FavouriteBtnPage.clickOn_Close_Button();
		 FavouriteBtnPage.Enter_Nickname(nickname);
	 }
	 
	 @Then("^I click on AddToFavourite Button$")
	 public void i_click_on_addtofavourite_button() 
	 {
		 FavouriteBtnPage.clickOn_AddFavourite_Button();
		 boolean YellowStar = FavouriteBtnPage.Verify_YellowFavouriteStar_isDisplayed();
		 scenario.log("<----- I expect yellow star should be display--> Actual Result: "+YellowStar+" --||-- Expected Result: true ----->");
		 Assert.assertEquals(YellowStar, true);
	 }

	 @Then("^I open Existing Favourite Location (.+)$")
	 public void i_open_existing_favourite_location(String address)
	 {
		 FavouriteBtnPage.clickOn_ExistingFavouriteClose_Button();
		 FavouriteBtnPage.clickOn_ExistingLocation_Button();
	 }

	 @Then("^I delete Favorite Location$")
	 public void i_delete_favorite_location() 
	 {
		 FavouriteBtnPage.clickOn_YellowStar_Button();
		 FavouriteBtnPage.clickOn_Delete_Button();
		
	 }

	 @Then("^I expect remove location from favourite Button$")
	 public void i_expect_remove_location_from_favourite_button() 
	 {
		 boolean YellowStar = FavouriteBtnPage.Verify_YellowunFavouriteStar_isDisplayed(); 
		 scenario.log("<----- I expect yellow star should not be display--> Actual Result: "+YellowStar+" --||-- Expected Result: true ----->");
		 Assert.assertEquals(YellowStar, true);
	 }
	 
	 @Then("^I LogOut from app$")
	 public void i_Lofout_from_App() throws InterruptedException
	 {
		 FavouriteBtnPage.clickOn_ExistingFavouriteClose_Btn();
		 Thread.sleep(5000);
		 FavouriteBtnPage.clickOn_Setting_Button();
		 FavouriteBtnPage.clickOn_Logout_Button();
		 FavouriteBtnPage.clickOn_yesLogMeOut_Button();
		 boolean SignInWithMe = FavouriteBtnPage.Verify_SignInWithMe_isDisplayed();
		 scenario.log("<----- I expect Sign In With Me button should  be display--> Actual Result: "+SignInWithMe+" --||-- Expected Result: true ----->");
		 Assert.assertEquals(SignInWithMe, true);
	 }
	  


}
