package mobileAutomation.cucumber.ios.pages;


import org.openqa.selenium.By;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import mobileAutomation.cucumber.common.PublicTransportPage;
import mobileAutomation.cucumber.common.iOSBasePage;

public class iOSPublicTransportPage extends iOSBasePage implements PublicTransportPage {

	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='PT stops']")
	private MobileElement PT_stops_button;

	@iOSXCUITFindBy(xpath = "//XCUIElementTypeTextField[@value='Where to?']")
	private MobileElement Whereto;

	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='ROUTE']")
	private MobileElement RouteButton;

	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='close']")
	private MobileElement CloseButton;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='View on Map']/../XCUIElementTypeButton[2]")
	private MobileElement SelectSearchedLocation;

	@iOSXCUITFindBy(xpath = "(//XCUIElementTypeButton)[5]")
	private MobileElement SelectLocation;

	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Your Location']") 
    private MobileElement WhereFrom;

	@iOSXCUITFindBy(xpath = "//XCUIElementTypeScrollView[2]")
	private MobileElement containerFilters;

	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='Train_Icon']")
	private MobileElement PtStopIcon;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='All']")
	private MobileElement AllBtn;
	
	@iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`label CONTAINS 'Depart At '`][2]")
	private MobileElement AllPublicTransport;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='back']/../XCUIElementTypeStaticText[3]")
	private MobileElement getArrivalTime;
	
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='Ride for 5 stops']")
	private MobileElement StopsArrow;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeImage[@name=\"GrabBar\"]/../XCUIElementTypeStaticText[2]") 
    private MobileElement firstStopName; 
    
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`label == 'Allow While Using App'`]")
   	private MobileElement AllowWhileUsingApp;  
    
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`label == 'CONTINUE AS GUEST'`]")
	private MobileElement Continue_As_a_guest; 
    
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`label == 'SKIP'`]")
	private MobileElement skip; 
    
    @Override
	public void Click_OnSkip() {
		
		try {
			super.waitForVisibility(skip);
			skip.click();
		} catch (Exception e) {
	    } 
	}
    
    @Override
	public void Click_ContinueAsAGuest() {
		// TODO Auto-generated method stub
		try {
			super.waitForVisibility(Continue_As_a_guest);
			Continue_As_a_guest.click();
		} catch (Exception e) {
		     // System.out.println("Something went wrong.");
	    } 
	}
    
    @Override
   	public void clickOnAllowLocationPopup() throws InterruptedException {

   		try {
   			AllowWhileUsingApp.click();
   			Thread.sleep(5000);
   		} catch (Exception e) {
   		      System.out.println("Pop-Up not display");
   	    } 
   		//Thread.sleep(5000);
   	}
    
    @Override
	public String getArrivalTime()
    {
		String arrivalTime = getArrivalTime.getText();
		arrivalTime = arrivalTime.substring(arrivalTime.lastIndexOf("y") + 1).trim().replace(" ", "");
		return arrivalTime;
	}
	
	@Override
	public String getFirstStopName() {
		super.swipeUp();
		StopsArrow.click();
		return firstStopName.getText();
		}

	public iOSPublicTransportPage(AppiumDriver<MobileElement> driver) {
		super(driver);
	}
	
	
	@Override
	public boolean PT_stops_buttonDisplayed() {
		return PT_stops_button.isDisplayed();
	}
	
	@Override
	public void searchLocationInTripPlanner(String location) {
		if (Whereto.isDisplayed()) {
			Whereto.click();
			Whereto.sendKeys(location);
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
	public void SelectYourLocation(String location) {
		super.waitForVisibility(SelectLocation);
		SelectLocation.click();
		if (WhereFrom.isDisplayed()) {
			WhereFrom.sendKeys(location);
			super.waitForVisibility(SelectSearchedLocation);
			SelectSearchedLocation.click();
		}
	}

	
	@Override
	public void SelectPublicTransportRoute()
	{
		AllBtn.click();
		PtStopIcon.click();
		super.waitForVisibility(AllPublicTransport);
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		AllPublicTransport.click();
	}
	
	
	@Override
	public void verifySearchedLocation(String location)
	{

		super.waitForVisibility(driver.findElement(By.xpath("//XCUIElementTypeStaticText[@name='"+location+"']")));
	}
	
	
	
}
