package mobileAutomation.cucumber.steps;

import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.junit.CucumberOptions;
import mobileAutomation.cucumber.android.pages.AndroidPTStop_OptionsPage;
import mobileAutomation.cucumber.common.BaseSteps;
import mobileAutomation.cucumber.common.Hooks;
import mobileAutomation.cucumber.common.PTStop_Options;
import mobileAutomation.cucumber.ios.pages.iOSPTStop_OptionsPage;

@CucumberOptions(plugin = { "pretty", "html:target/cucumber-report/android/cucumber.html",
		"junit:target/cucumber-report/android/cucumber.xml",
		"json:target/cucumber-report/android/cucumber.json" }, tags = "@android or @iOS")

public class PTStop_OptionsSteps extends BaseSteps 
{
	PTStop_Options RoutesWithPTStop;
	String currentTag;
	Scenario scenario; 

	
	@Before
	public void beforePTStop(Scenario scenario) {
		
		driver = Hooks.currentDeviceDriver();
		currentTag = Hooks.getCurrentTag();
        this.scenario = scenario;


		if (scenario.getSourceTagNames().contains("@android")) {
			RoutesWithPTStop = new AndroidPTStop_OptionsPage(driver);
		} else {
			RoutesWithPTStop = new iOSPTStop_OptionsPage(driver);
		}
	}
	
	    @And("^I click on train option$")
	    public void i_click_on_train_option() throws Throwable 
	    {
	    	RoutesWithPTStop.ClickOnTrainIcon(scenario);
	    }

	    @And("^I verify train routes$")
	    public void i_verify_train_routes() throws Throwable 
	    {
	    	RoutesWithPTStop.verifyTrainIcon(scenario);

	    }
	    
	    @And("^I click on cycle option$")
	    public void i_click_on_cycle_options() throws Throwable 
	    {
	    	RoutesWithPTStop.ClickOnCycleIcon(scenario);
	    }

	    @And("^I verify cycle routes$")
	    public void i_verify_cycle_routess() throws Throwable 
	    {
	    	RoutesWithPTStop.verifyCycleIcon(scenario);

	    }
	    
	    @And("^I click on car option$")
	    public void i_click_on_car_option() throws Throwable 
	    {
	    	RoutesWithPTStop.ClickOnCarIcon(scenario);
	    }

	    @And("^I verify car routes$")
	    public void i_verify_car_routes() throws Throwable 
	    {
	    	RoutesWithPTStop.verifyCarIcon(scenario);

	    }
	    
	    @And("^I click on walk option$")
	    public void i_click_on_walk_option() throws Throwable 
	    {
	    	RoutesWithPTStop.ClickOnWalkIcon(scenario);
	    }

	    @And("^I verify walk routes$")
	    public void i_verify_walk_routes() throws Throwable 
	    {
	    	RoutesWithPTStop.verifyWalkIcon(scenario);

	    }
}
