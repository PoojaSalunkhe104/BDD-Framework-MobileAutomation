package mobileAutomation.cucumber.ios.pages;


import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import mobileAutomation.cucumber.common.BikeroutePage;
import mobileAutomation.cucumber.common.iOSBasePage;

public class iOSBikeroutePage extends iOSBasePage implements BikeroutePage {

	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='PT stops']")
	private MobileElement PT_stops_button;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='Bike routes']")
	private MobileElement Bike_routes_button;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='Map legend']")
	private MobileElement Re_position_map_to_your_location;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeImage[@name='GrabBar']")
	private MobileElement GrabBar;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeImage[@name='Search']")
	private MobileElement Search;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='setting_ic']")
	private MobileElement Settings_title;

	@iOSXCUITFindBy(xpath = "//XCUIElementTypeTextField[@value='Where to?']")
	private MobileElement Whereto;

	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='View on Map']/../XCUIElementTypeButton[2]") 
	private MobileElement SelectSearchedLocation;

	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='ROUTE']")
	private MobileElement RouteButton;

	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='close']")
	private MobileElement CloseButton;

	@iOSXCUITFindBy(xpath = "(//XCUIElementTypeButton)[5]")
	private MobileElement SelectLocation;
  
	@iOSXCUITFindBy(xpath = "**/XCUIElementTypeStaticText[`label == 'Select Location'`]")
    private MobileElement WhereFrom;

	@iOSXCUITFindBy(xpath = "//XCUIElementTypeScrollView[2]")
	private MobileElement containerFilters;

	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='Cycle_Icon']")  
	private MobileElement CycleBtn;

	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='All']")
	private MobileElement AllBtn;

	@iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`label CONTAINS 'Depart At '`][2]")
    private MobileElement Faster;

	@iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`label == 'GO'`]")   
	private MobileElement GoButton;

	@iOSXCUITFindBy(xpath = "//XCUIElementTypeImage[@name='Journey_From_Icon']")
	private MobileElement StartOn;

	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Arrive']")
	private MobileElement Arrive;

	@iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`label == 'Allow While Using App'`]")
	private MobileElement AllowWhileUsingApp;  
	
	@iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`label == 'CONTINUE AS GUEST'`]")
	private MobileElement Continue_As_a_guest; 
	
	@iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`label == 'SKIP'`]")
	private MobileElement skip; 
    

	public  iOSBikeroutePage(AppiumDriver<MobileElement> driver) {
		super(driver);
		

	}
	@Override
	public void Click_ContinueAsAGuest() {
		
		try {
			super.waitForVisibility(Continue_As_a_guest);
			Continue_As_a_guest.click();
		} catch (Exception e) {
	    } 
	}

	@Override
	public void Click_OnSkip() {
		
		try {
			super.waitForVisibility(skip);
			skip.click();
		} catch (Exception e) {
	    } 
	}

	@Override
	public boolean Setting_buttonDisplayed() {
		return Settings_title.isDisplayed();
	}

	@Override
	public boolean PT_stops_buttonDisplayed() {
		return PT_stops_button.isDisplayed();
	}

	@Override
	public void ClickOn_Bike_routes_button() {
		if (Bike_routes_button.isDisplayed()) {
			Bike_routes_button.click();
		}
	}

	@Override
	public boolean Re_position_map_to_your_locationDisplayed() {
		return Re_position_map_to_your_location.isDisplayed();
	}

	@Override
	public void clickOnSearchDisplayed() {
		if (Whereto.isDisplayed()) {
			Whereto.click();
			Whereto.sendKeys("Fitzroy St, St Kilda VIC 3182, Australia");
			super.waitForVisibility(SelectSearchedLocation);
			SelectSearchedLocation.click();
		}
	}

	@Override
	public boolean RouteDisplayed() {
		return RouteButton.isDisplayed();
	}

	@Override
	public void clickOnRouteButton() {
		CloseButton.isDisplayed();
		RouteButton.click();
	}

	@Override
	public void SelectYourLocation() {
		super.waitForVisibility(SelectLocation);
		SelectLocation.click();
		if (WhereFrom.isDisplayed()) {
			WhereFrom.sendKeys("Level 2/271 Collins St, Melbourne VIC 3000, Australia");
			super.waitForVisibility(SelectSearchedLocation);
			SelectSearchedLocation.click();
		}
	}

	@Override
	public boolean containerFiltersIsDisplayed() {
		return containerFilters.isDisplayed();
	}

	@Override
	public void SelectBikeRoute() {
		AllBtn.click();
		CycleBtn.click();
		if (Faster.isDisplayed()) {
			Faster.click();
		}
	}

	@Override
	public boolean GoButtonIsDisplayed() {
		super.waitForVisibility(GoButton);
		
		return GoButton.isDisplayed();
	}

	@Override
	public boolean routeIsDisplayed() {

		return true;
	}

	@Override
	public boolean StartonIsDisplayed() {
		return StartOn.isDisplayed();
	}

	@Override
	public boolean ArriveIsDisplayed() {
		return Arrive.isDisplayed();
	}

	@Override
	public void clickOnDeviceBackButton() {

	}

	@Override
	public boolean ParkingDisplayed() {
		return false;
	}
	
	@Override
	public void clickOnAllowLocationPopup() throws InterruptedException {

		try {
			Thread.sleep(2000);
			AllowWhileUsingApp.click();
			Thread.sleep(5000);
		} catch (Exception e) {
		     // System.out.println("Something went wrong.");
	    } 
		//TouchAction touchAction = new TouchAction(driver);
		//touchAction.tap(PointOption.point(207, 556)).perform();
		Thread.sleep(5000);

	}

}
