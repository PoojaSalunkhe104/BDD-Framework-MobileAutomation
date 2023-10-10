package mobileAutomation.cucumber.steps;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.junit.CucumberOptions;
import lombok.extern.slf4j.Slf4j;
import mobileAutomation.cucumber.android.pages.AndroidBikeroutePage;
import mobileAutomation.cucumber.common.BaseSteps;
import mobileAutomation.cucumber.common.BikeroutePage;
import mobileAutomation.cucumber.common.Hooks;
import mobileAutomation.cucumber.ios.pages.iOSBikeroutePage;

@CucumberOptions(plugin = { "pretty", "html:target/cucumber-report/android/cucumber.html",
		"junit:target/cucumber-report/android/cucumber.xml",
		"json:target/cucumber-report/android/cucumber.json" }, tags = "@android or @iOS")
@Slf4j
public class BikeRoutesSteps extends BaseSteps {
	BikeroutePage bikeroutePage;
	mobileAutomation.cucumber.common.SettingsPage SettingsPage;
	AppiumDriver<MobileElement> driver;
	String currentTag;
	Scenario scenario;
	
	@Before
	public void beforeBikeroutes(Scenario scenario) {
		driver = Hooks.currentDeviceDriver();
		currentTag = Hooks.getCurrentTag();
		this.scenario = scenario;
		
		if (scenario.getSourceTagNames().contains("@android")) {
			bikeroutePage = new AndroidBikeroutePage(driver);
		} else {
			 bikeroutePage = new iOSBikeroutePage(driver);
		}
	}
	
  @Given("^An anonymous user navigate to Bike routes$")
  public void an_anonymous_user_navigate_to_bike_routes() throws Throwable {
	    bikeroutePage.Click_OnSkip();
	    bikeroutePage.Click_ContinueAsAGuest();
	    bikeroutePage.clickOnAllowLocationPopup();
	    Thread.sleep(10000);
		bikeroutePage.PT_stops_buttonDisplayed();
		bikeroutePage.ClickOn_Bike_routes_button();
	}
   @When("^I click on Where to$")
   public void i_click_on_where_to() throws Throwable {
	}
   
   
   @Then("^I expect to see Route button$")
   public void i_expect_to_see_route_button() throws Throwable {
		bikeroutePage.RouteDisplayed();
	}
   @Then("^I click on Route button$")
   public void i_click_on_route_button() throws Throwable {
		bikeroutePage.clickOnRouteButton();
	}
	@Then("^I expect to see Bike routes details$")
	public void i_expect_to_see_bike_routes_details() throws Throwable{
	//	bikeroutePage.containerFiltersIsDisplayed();
	}
	@Then("^I click on particular Bike route$")
	public void i_click_on_particular_Bikeroute() throws Throwable{
		bikeroutePage.SelectBikeRoute();
	}
	@Then("^I expect to see Go button and route$")
	public void i_expect_to_see_go_button_and_route() throws Throwable{
		//Assert.assertTrue(bikeroutePage.GoButtonIsDisplayed());
		scenario.log("<----- I expect to see the GO Button ----->");
		
		//Assert.assertTrue(bikeroutePage.StartonIsDisplayed()); //
		scenario.log("<----- I expect to see Start on ----->");
		
		//Assert.assertTrue(bikeroutePage.ArriveIsDisplayed()); //
		scenario.log("<----- I expect to see Arrive ----->");
		
	//	bikeroutePage.clickOnDeviceBackButton(); //
		
	}
}












