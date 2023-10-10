package mobileAutomation.cucumber.android.pages;

import org.openqa.selenium.By;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import mobileAutomation.cucumber.common.AndroidBasePage;
import mobileAutomation.cucumber.common.PublicTransportPage;

public class AndroidPublicTransportPage extends AndroidBasePage implements PublicTransportPage {

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='PT stops']")
	private MobileElement PT_stops_button;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Where to?']")
	private MobileElement Whereto;

	@AndroidFindBy(xpath = "//android.widget.Button[@text='ROUTE']")
	private MobileElement RouteButton;

	@AndroidFindBy(xpath = "//android.widget.ImageButton[@content-desc='Close']")
	private MobileElement CloseButton;

	@AndroidFindBy(xpath = "//android.widget.EditText[@text='Where from?']")
	private MobileElement WhereFrom;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Your location']")
	private MobileElement SelectLocation;

	@AndroidFindBy(xpath = "//android.widget.EditText[@text='Where to?']")
	private MobileElement EditWhereto;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Your location']")
	private MobileElement YourLocation;

	@AndroidFindBy(xpath = "//android.widget.EditText[@text='Where from?']")
	private MobileElement EditWhereFrom;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='All']")
	private MobileElement AllBtn;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='All']/../../android.widget.LinearLayout[2]")
	private MobileElement PtStopIcon;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='All']/../../../..")
	private MobileElement AllPublicTransport;

	public AndroidPublicTransportPage(AppiumDriver<MobileElement> driver) {
		super(driver);
	}
	
	
	 @Override
	 public void clickOnAllowLocationPopup() throws InterruptedException {

	   		try {
	   			
	   		} catch (Exception e) {
	   	    } 
	   		
	   	}
		
	@Override
	public void searchLocationInTripPlanner(String location) {
		if (Whereto.isDisplayed()) {
			Whereto.click();
			EditWhereto.sendKeys(location);
			super.waitForVisibility(
					driver.findElement(By.xpath("//android.widget.TextView[@text='" + location + "']")));
			driver.findElement(By.xpath("//android.widget.TextView[@text='" + location + "']")).click();
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
	public void SelectPublicTransportRoute() {
		super.waitForVisibility(AllBtn);
		AllBtn.click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		PtStopIcon.click();
		super.waitForVisibility(AllPublicTransport);
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		int size = driver.findElements(By.xpath("//android.widget.TextView[@text='All']/../../../..")).size();
		System.out.println(size);
		driver.findElement(By.xpath(
				"//android.widget.TextView[@text='All']/../../../../android.widget.RelativeLayout[" + size + "]"))
				.click();
	}

	@Override
	public void verifySearchedLocation(String location) {
		super.waitForVisibility(driver.findElement(By.xpath("//android.widget.TextView[@text='" + location + "']")));

	}

	@Override
	public boolean PT_stops_buttonDisplayed() {
		return PT_stops_button.isDisplayed();
	}

	@Override
	public void SelectYourLocation(String location) {
		super.waitForVisibility(YourLocation);
		YourLocation.click();
		if (WhereFrom.isDisplayed()) {
			EditWhereFrom.sendKeys(location);
			super.waitForVisibility(driver.findElement(By
					.xpath("//android.widget.TextView[@text='3/19 Centre Ave, Port Melbourne VIC 3207, Australia']")));
			driver.findElement(
					By.xpath("//android.widget.TextView[@text='3/19 Centre Ave, Port Melbourne VIC 3207, Australia']"))
					.click();
		}
	}

	@Override
	public String getArrivalTime() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getFirstStopName() {
		// TODO Auto-generated method stub
		return null;
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
