package mobileAutomation.cucumber.steps;

import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.junit.CucumberOptions;
import mobileAutomation.cucumber.android.pages.AndroidVerifyingPTStopsInformationPage;
import mobileAutomation.cucumber.common.BaseSteps;
import mobileAutomation.cucumber.common.Hooks;
import mobileAutomation.cucumber.common.VerifyingPTStopsInformationPage;
import mobileAutomation.cucumber.ios.pages.iOSVerifyingPTStopsInformationPage;

@CucumberOptions(plugin = { "pretty", "html:target/cucumber-report/android/cucumber.html",
		"junit:target/cucumber-report/android/cucumber.xml",
		"json:target/cucumber-report/android/cucumber.json" }, tags = "@android or @iOS")

public class VerifyingPTStopsInformationSteps  extends BaseSteps 
{
	
	VerifyingPTStopsInformationSteps PTStopsInformationSteps;
	String currentTag;
	VerifyingPTStopsInformationPage PTStopsInformationPage;
	Scenario scenario; 

	
	@Before
	public void beforePTStop(Scenario scenario) {
		
		driver = Hooks.currentDeviceDriver();
		currentTag = Hooks.getCurrentTag();
        this.scenario = scenario;


		if (scenario.getSourceTagNames().contains("@android")) {
			PTStopsInformationPage = new AndroidVerifyingPTStopsInformationPage(driver);
		} else {
			PTStopsInformationPage = new iOSVerifyingPTStopsInformationPage(driver);
		}
	}
	
	    @Given("^An anonymous user open the application$")
	    public void an_anonymous_user_open_the_application() throws Throwable 
	    {
	    	PTStopsInformationPage.Click_OnSkip();
	    	PTStopsInformationPage.Click_ContinueAsAGuest();
	    	PTStopsInformationPage.clickOnAllowLocationPopup();
	    	PTStopsInformationPage.PT_stops_buttonDisplayed();
	    	PTStopsInformationPage.PT_stops_button();
        }

	    @When("^I Enter (.+) in Address field$")
	    public void i_enter_in_address_field(String address) throws Throwable {
	    	PTStopsInformationPage.searchLocationInTripPlanner(address);
	    }

	    @Then("^expect to see Route Button$")
	    public void expect_to_see_route_button() throws Throwable {
	    	PTStopsInformationPage.RouteDisplayed();
	    }
	    
	    @And("^click on Route Button$")
	    public void click_on_route_button() throws Throwable {
	    	PTStopsInformationPage.clickOnRouteButton();
	    }

	    @And("^I Enter (.+) in Location field$")
	    public void i_enter_in_location_field(String locationaddress) throws Throwable {
	    	PTStopsInformationPage.SelectYourLocation(locationaddress);
	    }

	    @Then("^I Verify all PT Stop options present or not$")
	    public void i_verify_all_pt_stop_options_present_or_not() throws Throwable 
	    {
	    	boolean CarIcon = PTStopsInformationPage.DisplayCarIcon();
			scenario.log("<----- I expect Car Icon should be display--> Actual Result: "+CarIcon+" --||-- Expected Result: true ----->");

			boolean CycleIcon = PTStopsInformationPage.DisplayCycleIcon();
			scenario.log("<----- I expect Cycle Icon should be display--> Actual Result: "+CycleIcon+" --||-- Expected Result: true ----->");

			boolean TrainIcon = PTStopsInformationPage.DisplayTrainIcon();
			scenario.log("<----- I expect Train Icon should be display--> Actual Result: "+TrainIcon+" --||-- Expected Result: true ----->");

			boolean WalkIcon = PTStopsInformationPage.DisplayWalkIcon();
			scenario.log("<----- I expect Walk Icon should be display--> Actual Result: "+WalkIcon+" --||-- Expected Result: true ----->");

			boolean AllIcon = PTStopsInformationPage.DisplayAllIcon();
			scenario.log("<----- I expect All Icon should be display--> Actual Result: "+AllIcon+" --||-- Expected Result: true ----->");
	    }

	    @And("^I Verify on Train_Icon$")
	    public void i_verify_on_trainicon() throws Throwable 
	    {
	    	PTStopsInformationPage.verifyTrainIcon(scenario);
	    }

	    @And("^I Verify on Cycle_Icon$")
	    public void i_verify_on_cycleicon() throws Throwable 
	    {
	    	PTStopsInformationPage.verifyCycleIcon(scenario);
	    }

	    @And("^I Verify on Bus_Icon$")
	    public void i_verify_on_busicon() throws Throwable {
	    	PTStopsInformationPage.verifyCarIcon(scenario);
	    }

	    @And("^I Verify on Walk_Icon$")
	    public void i_verify_on_walkicon() throws Throwable {
	    	PTStopsInformationPage.verifyWalkIcon(scenario);
	    }

	    @And("^I Verify on All_Icon$")
	    public void i_verify_on_allicon() throws Throwable {
	    	PTStopsInformationPage.verifyAllIcon(scenario);
	    }
	  
}
