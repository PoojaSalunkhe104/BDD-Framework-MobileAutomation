package mobileAutomation.cucumber.steps;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

import lombok.extern.slf4j.Slf4j;
import mobileAutomation.cucumber.android.pages.AndroidDashboardPage;
import mobileAutomation.cucumber.common.*;
import mobileAutomation.cucumber.ios.pages.iOSDashboardPage;
import org.testng.Assert;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.junit.CucumberOptions;
import mobileAutomation.cucumber.common.Hooks;

@CucumberOptions(plugin = { "pretty", "html:target/cucumber-report/android/cucumber.html",
		"junit:target/cucumber-report/android/cucumber.xml",
		"json:target/cucumber-report/android/cucumber.json" }, tags = "@android or @iOS")
@Slf4j

public class SettingSectionSteps extends BaseSteps {
	
	DashboardPage dashboardPage;
	mobileAutomation.cucumber.common.SettingsPage SettingsPage;
	AppiumDriver<MobileElement> driver;
	String currentTag;
	Scenario scenario;

	@Before
	public void beforeSettings(Scenario scenario) {
		driver = Hooks.currentDeviceDriver();
		currentTag = Hooks.getCurrentTag();
		this.scenario = scenario;
		
		if (scenario.getSourceTagNames().contains("@android")) {
			dashboardPage = new AndroidDashboardPage(driver);
		} else {
			dashboardPage = new iOSDashboardPage(driver);
		}
	}

	@Given("^An user open the app$")
	public void an_user_open_the_app() throws Throwable {
		System.out.println("app gets open");
		dashboardPage.Click_OnSkip();
		
		dashboardPage.Click_ContinueAsAGuest();

		dashboardPage.clickOnAllowLocationPopup();

		if (applicationFlavour.contains("rideplan")) {
			dashboardPage.PT_stops_buttonDisplayed();
		} else if (applicationFlavour.contains("arevo")) {
		}
	}

	 @When("^I navigate to (.+) section$")
	 public void i_navigate_to_section(String section) throws Throwable {
		 System.out.println("User Navigate to Setting section");
			SettingsPage = dashboardPage.clickOnSettingPage();
			SettingsPage.clickOnLogoutBtn();
	}

	@Then("^I expect to see all settings options$")
	public void I_expect_to_see_all_settings_options() throws Throwable {
		Assert.assertTrue(SettingsPage.TermsAndConditionDisplayed());
		scenario.log("<----- I expect to see terms and condition ----->");
		Assert.assertTrue(SettingsPage.PrivacyPolicyDisplayed());
		scenario.log("<----- I expect to see Privacy Policy ----->");
		Assert.assertTrue(SettingsPage.FAQsDisplayed());
		scenario.log("<----- I expect to see the FAQs ----->");
		Assert.assertTrue(SettingsPage.VersionDisplayed());
		scenario.log("<----- I expect to see the Version ----->");
		if (applicationFlavour.contains("rideplan")) {
			Assert.assertTrue(SettingsPage.RideplanLogoDisplayed());
			scenario.log("<----- I expect to see the rideplan Logo ----->");
		} else if (applicationFlavour.contains("arevo")) {
			Assert.assertTrue(SettingsPage.LogoDisplayed());
			scenario.log("<----- I expect to see the Arevo Logo ----->");
		}
	}
}
