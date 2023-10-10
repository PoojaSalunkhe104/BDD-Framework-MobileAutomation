package mobileAutomation.cucumber.ios;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import lombok.extern.slf4j.Slf4j;
import mobileAutomation.cucumber.common.Hooks;

@CucumberOptions
(plugin = {
        "pretty",
        "html:target/cucumber-report/ios/cucumber.html",
        "junit:target/cucumber-report/ios/cucumber.xml",
        "json:target/cucumber-report/ios/cucumber.json"
}, features = { "src/test/resources/features" },  glue = { "mobileAutomation.cucumber.common",
        "mobileAutomation.cucumber.ios", "mobileAutomation.cucumber.steps" }, 
		tags = ( "@iOS" )  //tags = ( "@iOS and @test" )

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