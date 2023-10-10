package mobileAutomation.cucumber.steps;

import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.junit.CucumberOptions;
import mobileAutomation.cucumber.android.pages.AndroidBikeStop_OptionsPage;
import mobileAutomation.cucumber.common.BaseSteps;
import mobileAutomation.cucumber.common.BikeStop_Options;
import mobileAutomation.cucumber.common.Hooks;
import mobileAutomation.cucumber.ios.pages.iOSBikeStop_OptionsPage;

@CucumberOptions(plugin = { "pretty", "html:target/cucumber-report/android/cucumber.html",
		"junit:target/cucumber-report/android/cucumber.xml",
		"json:target/cucumber-report/android/cucumber.json" }, tags = "@android or @iOS")

public class BikeStop_OptionsSteps extends BaseSteps 
{
	BikeStop_Options RoutesWithBikeStop;
	String currentTag;
	Scenario scenario; 

	
	@Before
	public void beforeBikeStop(Scenario scenario) {
		
		driver = Hooks.currentDeviceDriver();
		currentTag = Hooks.getCurrentTag();
        this.scenario = scenario;


		if (scenario.getSourceTagNames().contains("@android")) {
			RoutesWithBikeStop = new AndroidBikeStop_OptionsPage(driver);
		} else {
			RoutesWithBikeStop = new iOSBikeStop_OptionsPage(driver);
		}
	}
	
	
	
	    @And("^I click on a train option$")
	    public void i_click_on_train_option() throws Throwable 
	    {
		 RoutesWithBikeStop.ClickOnTrainIcon(scenario);
	    }

	    @And("^I verify a train routes$")
	    public void i_verify_train_routes() throws Throwable 
	    {
	    	RoutesWithBikeStop.verifyTrainIcon(scenario);

	    }
	    
	    @And("^I click on a cycle option$")
	    public void i_click_on_cycle_options() throws Throwable 
	    {
		 RoutesWithBikeStop.ClickOnCycleIcon(scenario);
	    }

	    @And("^I verify a cycle routes$")
	    public void i_verify_cycle_routess() throws Throwable 
	    {
	    	RoutesWithBikeStop.verifyCycleIcon(scenario);

	    }
	    
	    @And("^I click on a car option$")
	    public void i_click_on_car_option() throws Throwable 
	    {
		 RoutesWithBikeStop.ClickOnCarIcon(scenario);
	    }

	    @And("^I verify a car routes$")
	    public void i_verify_car_routes() throws Throwable 
	    {
	    	RoutesWithBikeStop.verifyCarIcon(scenario);

	    }
	    
	    @And("^I click on a walk option$")
	    public void i_click_on_walk_option() throws Throwable 
	    {
		 RoutesWithBikeStop.ClickOnWalkIcon(scenario);
	    }

	    @And("^I verify a walk routes$")
	    public void i_verify_walk_routes() throws Throwable 
	    {
	    	RoutesWithBikeStop.verifyWalkIcon(scenario);

	    }
}
