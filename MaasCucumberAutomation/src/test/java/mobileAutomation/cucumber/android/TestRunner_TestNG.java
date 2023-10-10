package mobileAutomation.cucumber.android;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import lombok.extern.slf4j.Slf4j;
import mobileAutomation.cucumber.common.Hooks;


@CucumberOptions(plugin = {
        "pretty",
        "html:target/cucumber-report/android/cucumber.html",
        "junit:target/cucumber-report/android/cucumber.xml",
        "json:target/cucumber-report/android/cucumber.json"
}, features = { "src/test/resources/features/TC03ValidateFavouriteButton.feature" }, tags = "@android", glue = { "mobileAutomation.cucumber.common",
        "mobileAutomation.cucumber.android", "mobileAutomation.cucumber.steps" }

)
@Slf4j
public class TestRunner_TestNG extends AbstractTestNGCucumberTests {

    @BeforeClass
    @Parameters("platformName")
    public void setUpClass(String platformName) throws Exception {
        super.setUpClass();
        log.info("Setting the platform name as: {}", platformName);
        Hooks.setPlatform(platformName);
    }
    
}

