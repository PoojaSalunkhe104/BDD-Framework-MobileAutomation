package mobileAutomation.cucumber.android;

import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import lombok.extern.slf4j.Slf4j;
import mobileAutomation.cucumber.common.Hooks;


@RunWith(Cucumber.class)
@CucumberOptions
(
		features = "src/test/resources/features",
				plugin = {"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"},
				glue = { "mobileAutomation.cucumber.common",
				        "mobileAutomation.cucumber.android", "mobileAutomation.cucumber.steps" },
        tags = "@android",
    	monochrome = true

)
@Slf4j
public class TestRunner_JUnit {
	 
   
	@BeforeClass
    public static void setUpClass( )  {
        String platformName = "android";
        log.info("Setting the platform name as: {}", platformName);
        Hooks.setPlatform(platformName);
    }  

	
}