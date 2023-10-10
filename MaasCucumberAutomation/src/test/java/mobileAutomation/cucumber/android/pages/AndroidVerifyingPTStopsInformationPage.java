package mobileAutomation.cucumber.android.pages;



import java.util.List;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.cucumber.java.Scenario;
import mobileAutomation.cucumber.common.AndroidBasePage;
import mobileAutomation.cucumber.common.VerifyingPTStopsInformationPage;

public class AndroidVerifyingPTStopsInformationPage extends AndroidBasePage implements VerifyingPTStopsInformationPage
{
	
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='PT stops']")
	private MobileElement PT_stops_button;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Where to?']")
	private MobileElement Whereto;
	
	@AndroidFindBy(xpath = "//android.widget.EditText[@text='Where to?']")
	private MobileElement Whereto1;

	@AndroidFindBy(xpath = "//android.widget.Button[@text='ROUTE']")
	private MobileElement RouteButton;

	@AndroidFindBy(xpath = "//android.widget.ImageButton[@content-desc='Close']")
	private MobileElement CloseButton;
	
	@AndroidFindBy(xpath = "(//android.widget.LinearLayout[1])[4]")
	private MobileElement SelectSearchedLocation; 
	
	@AndroidFindBy(xpath = "(//android.widget.LinearLayout)[5]")
	private MobileElement SelectSearchedLocation1;  

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Your location']") //android.widget.TextView[@text='Your location']
	private MobileElement SelectLocation;

	@AndroidFindBy(xpath = "//android.widget.EditText[@text='Where from?']") 
    private MobileElement WhereFrom;

	@AndroidFindBy(id = "com.intelematics.maas.rideplan.dev:id/btnPublicTransport")
	private MobileElement PtStopIcon;
	
	@AndroidFindBy(id = "com.intelematics.maas.rideplan.dev:id/btnAll")
	private MobileElement AllBtn;
	
	@AndroidFindBy(id = "com.intelematics.maas.rideplan.dev:id/btnCycle")
	private MobileElement CycleBtn;
	
	@AndroidFindBy(id = "com.intelematics.maas.rideplan.dev:id/btnWalk")
	private MobileElement WalkBtn;
	
	@AndroidFindBy(id = "com.intelematics.maas.rideplan.dev:id/btnDrive")
	private MobileElement CarBtn;
	
	@AndroidFindBy(id = "com.android.permissioncontroller:id/permission_allow_foreground_only_button")
	private MobileElement AllowWhileUsingApp; 
    
	@AndroidFindBy(xpath = "//android.widget.RelativeLayout")
	private MobileElement list; 
    
    Scenario scenario; 

    public AndroidVerifyingPTStopsInformationPage(AppiumDriver<MobileElement> driver) {
		super(driver);
	}
    
    @Override
	public boolean PT_stops_buttonDisplayed() {
		return PT_stops_button.isDisplayed();
	}
    
    @Override
	public void clickOnAllowLocationPopup() throws InterruptedException {

		try {
			AllowWhileUsingApp.click();
			Thread.sleep(5000);
		} catch (Exception e) {
		      System.out.println("Pop-Up not display");
	    } 
		
		Thread.sleep(5000);
	}
    
    @Override
  	public void PT_stops_button() {
  		PT_stops_button.click();
  	}
    
	@Override
	public void searchLocationInTripPlanner(String address) throws InterruptedException {
		if (Whereto.isDisplayed()) {
			Whereto.click();
			Whereto1.sendKeys(address);
			Thread.sleep(2000);
			super.waitForVisibility(SelectSearchedLocation);
			SelectSearchedLocation.click();
		}
		
		}
	
	@Override
	public boolean PT_stops_buttonDisplayed1() {
		return PT_stops_button.isDisplayed();
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
	public void SelectYourLocation(String locationaddress) throws InterruptedException {
		super.waitForVisibility(SelectLocation);
		SelectLocation.click();
		if (WhereFrom.isDisplayed()) {
			WhereFrom.sendKeys(locationaddress);
			Thread.sleep(2000);
			super.waitForVisibility(SelectSearchedLocation1);
			SelectSearchedLocation1.click();
		}
	}
	
	@Override
	public boolean DisplayTrainIcon()
	{
			return PtStopIcon.isDisplayed();
	}

	@Override
	public boolean DisplayCycleIcon()
	{
			return CycleBtn.isDisplayed();
	}

	@Override
	public boolean DisplayCarIcon()
	{
			return CarBtn.isDisplayed();
	}

	@Override
	public boolean DisplayWalkIcon()
	{
			return WalkBtn.isDisplayed();
	}

	@Override
	public boolean DisplayAllIcon()
	{
			return AllBtn.isDisplayed();
	}
	
	@Override
	public void verifyTrainIcon(Scenario scenario) throws InterruptedException
	{

		this.scenario = scenario;
    	super.waitForVisibility(list);
		Thread.sleep(2000);

        List<MobileElement> texts = driver.findElements(MobileBy.xpath("//android.widget.RelativeLayout"));
        scenario.log("<----- Number of records in Train Icon: " + (texts.size())+" ------>");

		
		PtStopIcon.click();
	}
		
	 @Override
	public void verifyCycleIcon(Scenario scenario) throws InterruptedException 
	{
		 this.scenario = scenario;
		 CycleBtn.click();	
	     super.waitForVisibility(list);
		 Thread.sleep(2000);

		 List<MobileElement> texts = driver.findElements(MobileBy.xpath("//android.widget.RelativeLayout"));
		 scenario.log("<----- Number of records in cycle Icon: " + (texts.size())+" ----->");
		
			 CycleBtn.click();	

	}
			
    @Override
    public void verifyCarIcon(Scenario scenario) throws InterruptedException 
    {
    	this.scenario = scenario;
    	CarBtn.click();	
    	super.waitForVisibility(list);
		Thread.sleep(2000);

    	List<MobileElement> texts = driver.findElements(MobileBy.xpath("//android.widget.RelativeLayout"));
    	scenario.log("<----- Number of records in Car Icon: " + (texts.size())+" ------>");
 	
    	CarBtn.click();	
	}
			
    @Override
	public void verifyWalkIcon(Scenario scenario) throws InterruptedException 
	{
    	this.scenario = scenario;
    	WalkBtn.click();
    	super.waitForVisibility(list);
		Thread.sleep(2000);

    	List<MobileElement> texts = driver.findElements(MobileBy.xpath("//android.widget.RelativeLayout"));
    	scenario.log("<----- Number of records in Walk Icon: " + (texts.size())+" ------>");
 		
 	 		WalkBtn.click();
	}
			
	@Override
	public void verifyAllIcon(Scenario scenario) throws InterruptedException 
	{
		this.scenario = scenario;
		AllBtn.click();	
		super.waitForVisibility(list);
		Thread.sleep(2000);
		
		List<MobileElement> texts = driver.findElements(MobileBy.xpath("//android.widget.RelativeLayout"));
		scenario.log("<------ Number of records in All Icon: " + (texts.size())+" ------>");
	
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
