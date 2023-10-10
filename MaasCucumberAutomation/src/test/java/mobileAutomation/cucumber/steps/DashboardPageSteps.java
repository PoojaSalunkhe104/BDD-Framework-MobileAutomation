package mobileAutomation.cucumber.steps;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import lombok.extern.slf4j.Slf4j;
import org.testng.Assert;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.junit.CucumberOptions;
import mobileAutomation.cucumber.common.Hooks;
import mobileAutomation.cucumber.ios.pages.iOSDashboardPage;
import mobileAutomation.cucumber.android.pages.AndroidDashboardPage;
import mobileAutomation.cucumber.common.BaseSteps;
import mobileAutomation.cucumber.common.DashboardPage;

@CucumberOptions(plugin = { "pretty", "html:target/cucumber-report/android/cucumber.html",
		"junit:target/cucumber-report/android/cucumber.xml",
		"json:target/cucumber-report/android/cucumber.json" }, tags = "@android or @iOS")
@Slf4j
public class DashboardPageSteps extends BaseSteps {
	AppiumDriver<MobileElement> driver;
	DashboardPage dashboardPage;

	@Before
	public void beforeDashboard(Scenario scenario) {
		driver = Hooks.currentDeviceDriver();
		currentTag = Hooks.getCurrentTag();

		if (scenario.getSourceTagNames().contains("@android")) {
			dashboardPage = new AndroidDashboardPage(driver);
			if (applicationFlavour.contains("arevo")) {
				dashboardPage.skipButtonDisplayed();
			}
		} else {
			dashboardPage = new iOSDashboardPage(driver);

		}
	}

	@Given("^An anonymous user open the app$")
	public void an_anonymous_user() throws Throwable {
		System.out.println("I navigate to homePage");
		if (applicationFlavour.contains("rideplan")) {
			Thread.sleep(3000);
			dashboardPage.RidePlanHithereText();
			dashboardPage.clickOnAllowLocationPopUP();
			dashboardPage.RidePlanHeaderText();
			dashboardPage.RidePlanImage();
		}

		if (applicationFlavour.contains("arevo")) {
			Assert.assertTrue(dashboardPage.walkThroughPage1ImageDisplayed());
			Assert.assertEquals(dashboardPage.walkThoughPage1Text(), localization.getProperty("launchpage.text"));
		}
	}

	@When("^I navigate to Dashboard page$")
	public void i_navigate_to_trip_planner_page() throws Throwable {
		System.out.println("I navigate to Dashboard");
		if (applicationFlavour.contains("rideplan")) {
			Thread.sleep(5000);
			dashboardPage.RidePlancontinueButton();
			Assert.assertTrue(dashboardPage.ridePlanHeaderText1());
			dashboardPage.RidePlanImage();
			dashboardPage.RidePlancontinueButton();
			Assert.assertTrue(dashboardPage.ridePlanLugAndCarrieHeader());
			dashboardPage.RidePlancontinueButton();
			Assert.assertTrue(dashboardPage.ridePlanHeaderText2());
			dashboardPage.RidePlancontinueButton();
			dashboardPage.clickOnAllowLocationSystemPopUp();
			Thread.sleep(2000);
		//	dashboardPage.clickOnAllowLocationSystemPopUp();
		}
		if (applicationFlavour.contains("arevo")) {
			dashboardPage.clickOnSkipButton();
			Assert.assertTrue(dashboardPage.homePageTextDisplayed());
			Assert.assertTrue(dashboardPage.appLogoDisplayed());
			Assert.assertEquals(dashboardPage.validateOrLabel(), localization.getProperty("homepage.labelor.text"),
					"OR is not matched");
			Assert.assertTrue(dashboardPage.signInButtonDisplayed());

			Assert.assertEquals(dashboardPage.validateInfoLabel(),
					localization.getProperty("homepage.infolabel.agree.text"), "Info label is not matched");
			Assert.assertTrue(dashboardPage.termsOfUseLinkDisplayed());
			Assert.assertTrue(dashboardPage.privacyNoticeLinkDisplayed());
			Assert.assertTrue(dashboardPage.continueAsGuestButtonDisplayed());
			dashboardPage.ClickcontinueAsGuestButton();
		}

		dashboardPage.PT_stops_buttonDisplayed();

	}

	@Then("^I expect to see Dashboard$")
	public void I_expect_to_see_Dashboard() throws Throwable {

		Assert.assertTrue(dashboardPage.PT_stops_buttonDisplayed());
		System.out.println("I expect to see the PT stops Button");

		Assert.assertTrue(dashboardPage.Bike_routes_buttonDisplayed());
		System.out.println("I expect to see the Bike routes button");

		Assert.assertTrue(dashboardPage.Re_position_map_to_your_locationDisplayed());
		System.out.println("I expect to see the Re_position_map_to_your_locationDisplayed");

	}

}
