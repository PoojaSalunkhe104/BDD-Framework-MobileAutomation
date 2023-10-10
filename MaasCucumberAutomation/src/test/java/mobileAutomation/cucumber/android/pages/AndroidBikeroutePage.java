package mobileAutomation.cucumber.android.pages;

import org.testng.Assert;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import mobileAutomation.cucumber.common.AndroidBasePage;
import mobileAutomation.cucumber.common.BikeroutePage;

public class AndroidBikeroutePage extends AndroidBasePage implements BikeroutePage {
	
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='PT stops']")
	private MobileElement PT_stops_button;
	
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Bike routes']")
	private MobileElement Bike_routes_button;
	
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Parking']")
	private MobileElement Parking;
	
	@AndroidFindBy(xpath = "//android.widget.ImageButton[@content-desc='Center current location']")
	private MobileElement Re_position_map_to_your_location;
	
	@AndroidFindBy(id = "com.intelematics.maas.rideplan.staging:id/settingsButton")
	private MobileElement SettingsButton;
	
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Where to?']")
	private MobileElement Whereto;
	
	@AndroidFindBy(xpath = "//android.widget.EditText[@text='Where to?']")
	private MobileElement EditWhereto;
	
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Melbourne']")
	private MobileElement SelectMelbourne;
	
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Melbourne Central']")
	private MobileElement SelectMelbourneCentral;
	
	@AndroidFindBy(xpath = "//android.widget.Button[@text='ROUTE']")
	private MobileElement RouteButton;
	
	@AndroidFindBy(xpath = "//android.widget.ImageButton[@content-desc=\"Close\"]")
	private MobileElement CloseButton;
	
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Your location']")
	private MobileElement YourLocation;
	
	@AndroidFindBy(xpath = "//android.widget.EditText[@text='Where from?']")
	private MobileElement EditWhereFrom;
	
	@AndroidFindBy(id = "com.intelematics.maas.rideplan.staging:id/containerFilters")
	private MobileElement containerFilters;
	
	@AndroidFindBy(id = "com.intelematics.maas.rideplan.dev:id/btnCycle")
	private MobileElement CycleBtn;
	
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Faster']")
	private MobileElement Faster;
	
	@AndroidFindBy(xpath = "//android.widget.Button[@text='GO']")
	private MobileElement GoButton;
	
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Start on']")
	private MobileElement StartOn;
	
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Arrive']")
	private MobileElement Arrive;  	
	
	@AndroidFindBy(id = "com.android.permissioncontroller:id/permission_allow_foreground_only_button")
	private MobileElement AllowWhileUsingApp;
	
	public AndroidBikeroutePage(AppiumDriver<MobileElement> driver) {
		super(driver);
	}
	
	@Override
	public boolean Setting_buttonDisplayed() {
		// TODO Auto-generated method stub
		return SettingsButton.isDisplayed();
	}
	
	@Override
	public boolean PT_stops_buttonDisplayed() {
		return PT_stops_button.isDisplayed();
	}
	
	@Override
	public boolean ParkingDisplayed() {
		return Parking.isDisplayed();
	}
	
	@Override
	public boolean Re_position_map_to_your_locationDisplayed() {
		return Re_position_map_to_your_location.isDisplayed();
	}
	
	@Override
	public void ClickOn_Bike_routes_button() {
		if(Bike_routes_button.isDisplayed()) {
			Bike_routes_button.click();
		}
	}
	
	@Override
	public void clickOnSearchDisplayed() {
		if(Whereto.isDisplayed()) {
			Whereto.click();
			EditWhereto.sendKeys("Melbourne");
			super.waitForVisibility(SelectMelbourne);
			SelectMelbourne.click();
			Assert.assertEquals(SelectMelbourne.getText(), "Melbourne");
		}
	}
	
	@Override
	public boolean RouteDisplayed() {
		return RouteButton.isDisplayed();
	}
	
	@Override
	public void clickOnRouteButton() {
		super.waitForVisibility(RouteButton);
		RouteButton.click();
	}
	
	
	@Override
	public void SelectYourLocation() {
		super.waitForVisibility(YourLocation);
		YourLocation.click();
		if(EditWhereFrom.isDisplayed()) {
			EditWhereFrom.sendKeys("Melbourne Central");
			super.waitForVisibility(SelectMelbourneCentral);
			SelectMelbourneCentral.click();
			Assert.assertEquals(SelectMelbourneCentral.getText(), "Melbourne Central");
		}
	}
	
	@Override
	public boolean containerFiltersIsDisplayed() {
		return containerFilters.isDisplayed();
	}
	@Override
	public void SelectBikeRoute() {
		CycleBtn.click();
		if(Faster.isDisplayed()) {
			Faster.click();
		}
	}
	
	@Override
	public boolean GoButtonIsDisplayed() {
		return GoButton.isDisplayed();
	}
	
	@Override
	public boolean routeIsDisplayed() {
		return true;
	}
	
	@Override
	public boolean StartonIsDisplayed() {
		super.swipeUp();
		return StartOn.isDisplayed();
	}
	
	@Override
	public boolean ArriveIsDisplayed() {
		super.scrollingToElement("Arrive");
		return Arrive.isDisplayed();
	}
	
	@Override
	public void clickOnDeviceBackButton() {
		super.pressDeviceBackButton();
		
	}
	
	@Override
	public void clickOnAllowLocationPopup() throws InterruptedException {
		try {
			AllowWhileUsingApp.click();
			Thread.sleep(5000);
		} catch (Exception e) {
	    } 
		//TouchAction touchAction = new TouchAction(driver);
		//touchAction.tap(PointOption.point(207, 556)).perform();
		
		Thread.sleep(5000);		
	}
	
	@Override
	public void Click_ContinueAsAGuest() {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void Click_OnSkip() {
		// TODO Auto-generated method stub
		
	}
	
}









