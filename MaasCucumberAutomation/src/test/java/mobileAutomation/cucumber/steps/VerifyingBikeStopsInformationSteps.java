package mobileAutomation.cucumber.steps;

import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.junit.CucumberOptions;
import mobileAutomation.cucumber.android.pages.AndroidVerifyingBikeStopsInformationPage;
import mobileAutomation.cucumber.common.BaseSteps;
import mobileAutomation.cucumber.common.Hooks;
import mobileAutomation.cucumber.common.VerifyingBikeStopsInformationPage;
import mobileAutomation.cucumber.ios.pages.iOSVerifyingBikeStopsInformationPage;

@CucumberOptions(plugin = { "pretty", "html:target/cucumber-report/android/cucumber.html",
		"junit:target/cucumber-report/android/cucumber.xml",
		"json:target/cucumber-report/android/cucumber.json" }, tags = "@android or @iOS")

public class VerifyingBikeStopsInformationSteps extends BaseSteps 
{
	VerifyingBikeStopsInformationSteps BikeStopsInformationSteps;
	String currentTag;
	VerifyingBikeStopsInformationPage BikeStopsInformationPage;
	Scenario scenario; 

	
	@Before
	public void beforePTStop(Scenario scenario) {
		
		driver = Hooks.currentDeviceDriver();
		currentTag = Hooks.getCurrentTag();
        this.scenario = scenario;


		if (scenario.getSourceTagNames().contains("@android")) {
			BikeStopsInformationPage = new AndroidVerifyingBikeStopsInformationPage(driver);
		} else {
			BikeStopsInformationPage = new iOSVerifyingBikeStopsInformationPage(driver);
		}
	}
	
	    @Given("^An anonymous user open the application and go to Bike stop$")
	    public void an_anonymous_user_open_the_application() throws Throwable 
	    {
	    	BikeStopsInformationPage.Click_OnSkip();
	    	BikeStopsInformationPage.Click_ContinueAsAGuest();
	    	BikeStopsInformationPage.clickOnAllowLocationPopup();
	    	BikeStopsInformationPage.PT_stops_buttonDisplayed();
        }
	    
	    @Then("^I Verify all bike Stop options present or not$")
	    public void i_verify_all_pt_stop_options_present_or_not() throws Throwable 
	    {
	    	boolean CarIcon = BikeStopsInformationPage.DisplayCarIcon();
			scenario.log("<----- I expect Car Icon should be display--> Actual Result: "+CarIcon+" --||-- Expected Result: true ----->");

			boolean CycleIcon = BikeStopsInformationPage.DisplayCycleIcon();
			scenario.log("<----- I expect Cycle Icon should be display--> Actual Result: "+CycleIcon+" --||-- Expected Result: true ----->");

			boolean TrainIcon = BikeStopsInformationPage.DisplayTrainIcon();
			scenario.log("<----- I expect Train Icon should be display--> Actual Result: "+TrainIcon+" --||-- Expected Result: true ----->");

			boolean WalkIcon = BikeStopsInformationPage.DisplayWalkIcon();
			scenario.log("<----- I expect Walk Icon should be display--> Actual Result: "+WalkIcon+" --||-- Expected Result: true ----->");

			boolean AllIcon = BikeStopsInformationPage.DisplayAllIcon();
			scenario.log("<----- I expect All Icon should be display--> Actual Result: "+AllIcon+" --||-- Expected Result: true ----->");

	    }
	    
	    @And("^I Verify on Train_Icon of Bike stop$")
	    public void i_verify_on_trainicon() throws Throwable 
	    {
	    	BikeStopsInformationPage.verifyTrainIcon(scenario);
	    }

	    @And("^I Verify on Cycle_Icon of Bike stop$")
	    public void i_verify_on_cycleicon() throws Throwable 
	    {
	    	BikeStopsInformationPage.verifyCycleIcon(scenario);
	    }

	    @And("^I Verify on Bus_Icon of Bike stop$")
	    public void i_verify_on_busicon() throws Throwable {
	    	BikeStopsInformationPage.verifyCarIcon(scenario);
	    }

	    @And("^I Verify on Walk_Icon of Bike stop$")
	    public void i_verify_on_walkicon() throws Throwable {
	    	BikeStopsInformationPage.verifyWalkIcon(scenario);
	    }

	    @And("^I Verify on All_Icon of Bike stop$")
	    public void i_verify_on_allicon() throws Throwable {
	    	BikeStopsInformationPage.verifyAllIcon(scenario);
	    }
	  
}
