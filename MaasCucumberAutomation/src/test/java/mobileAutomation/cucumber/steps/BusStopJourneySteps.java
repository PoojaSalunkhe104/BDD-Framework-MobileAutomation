package mobileAutomation.cucumber.steps;


import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.junit.CucumberOptions;
import lombok.extern.slf4j.Slf4j;
import mobileAutomation.cucumber.android.pages.AndroidPublicTransportPage;
import mobileAutomation.cucumber.common.APIAutomationGetBusTransport;
import mobileAutomation.cucumber.common.BaseSteps;
import mobileAutomation.cucumber.common.Hooks;
import mobileAutomation.cucumber.common.PublicTransportPage;
import mobileAutomation.cucumber.ios.pages.iOSPublicTransportPage;

@CucumberOptions(plugin = { "pretty", "html:target/cucumber-report/android/cucumber.html",
		"junit:target/cucumber-report/android/cucumber.xml",
		"json:target/cucumber-report/android/cucumber.json" }, tags = "@android or @iOS")
@Slf4j
public class BusStopJourneySteps  extends BaseSteps {
	BusStopJourneySteps busStopSteps;
	String currentTag;
	PublicTransportPage publicTransportPage;
	APIAutomationGetBusTransport apiBusTransport;
	Scenario scenario;
	
	@Before
	public void beforeBikeroutes(Scenario scenario) {
		
		driver = Hooks.currentDeviceDriver();
		currentTag = Hooks.getCurrentTag();
		apiBusTransport = new APIAutomationGetBusTransport();
        this.scenario = scenario;


		if (scenario.getSourceTagNames().contains("@android")) {
			publicTransportPage = new AndroidPublicTransportPage(driver);
		} else {
			publicTransportPage = new iOSPublicTransportPage(driver);
		}
	}
	
	@Given("^An anonymous user open app$")
	public void an_anonymous_user_open_app() throws InterruptedException {
		publicTransportPage.Click_OnSkip();
		publicTransportPage.Click_ContinueAsAGuest();

		publicTransportPage.clickOnAllowLocationPopup();
		publicTransportPage.PT_stops_buttonDisplayed();
	}
	
	@When("^navigate to Dashboard page$")
	public void navigate_to_trip_planner_page() throws Throwable {
	}

	 @Then("^expect to see Route button$")
	   public void expect_to_see_route_button() throws Throwable {
		 publicTransportPage.RouteDisplayed();
		}
	 
	 @And("^click on Route button$")
	   public void click_on_route_button() throws Throwable {
		 publicTransportPage.clickOnRouteButton();
		}
	 
	@Then("^I Select particular public transport journey$")
	public void i_select_particular_public_transport_journey()throws Throwable  {
		publicTransportPage.SelectPublicTransportRoute();
	}

	
	@And("^I expect to verify generated journey$")
	public void i_expect_to_verify_generated_journey() throws Throwable {
		//publicTransportPage.verifySearchedLocation("426 Graham St, Port Melbourne VIC 3207, Australia");
	//	String arrivalTimeAPI = apiBusTransport.getArrivalTime().trim().replace(" ", "");
	//	String arrivalTimeUI = publicTransportPage.getArrivalTime();
      //  scenario.log("<----- arrivalTimeAPI: "+arrivalTimeAPI +" "+"arrivalTimeUI: "+arrivalTimeUI+" ----->");
		//Assert.assertEquals(arrivalTimeAPI, arrivalTimeUI); 
	    String FirststepsAPI = apiBusTransport.getSteps();
		String FirststepsUI = publicTransportPage.getFirstStopName();
		scenario.log("<----- FirststepsAPI: "+FirststepsAPI +" "+"FirststepsUI: "+FirststepsUI+" ----->");
		//Assert.assertEquals(FirststepsAPI, FirststepsUI); 
	}

	
}
