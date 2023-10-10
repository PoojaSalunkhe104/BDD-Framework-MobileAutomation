package mobileAutomation.cucumber.ios.pages;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.testng.Assert;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import io.cucumber.java.Scenario;
import mobileAutomation.cucumber.common.VerifyingBikeStopsInformationPage;
import mobileAutomation.cucumber.common.iOSBasePage;

public class iOSVerifyingBikeStopsInformationPage extends iOSBasePage implements VerifyingBikeStopsInformationPage
{

	public iOSVerifyingBikeStopsInformationPage(AppiumDriver<MobileElement> driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	Scenario scenario; 
	
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`label == 'Allow While Using App'`]")
	private MobileElement AllowWhileUsingApp; 
    
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='PT stops']")
	private MobileElement PT_stops_button;
    
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='Train_Icon']")
	private MobileElement PtStopIcon;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='All']")
	private MobileElement AllBtn;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='Cycle_Icon']")
	private MobileElement CycleBtn;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='Walk_Icon']")
	private MobileElement WalkBtn;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='Car_Icon']")
	private MobileElement CarBtn;
	
	@iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`label CONTAINS 'Depart At '`][2]")
	private MobileElement AllPublicTransport;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='back']/../XCUIElementTypeStaticText[3]")
	private MobileElement getArrivalTime;
	
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='Ride for 5 stops']")
	private MobileElement StopsArrow;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeImage[@name='GrabBar']/../XCUIElementTypeStaticText[2]") 
    private MobileElement firstStopName; 

    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeStaticText[`label CONTAINS ' hr '`]")
	private MobileElement Required_Time;  
    
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeStaticText[`label CONTAINS 'Depart At '`]")
	private MobileElement StartTime_EndTime;  
    
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`label CONTAINS 'Depart At '`]")
	private MobileElement list; 
    
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`label == 'CONTINUE AS GUEST'`]")
	private MobileElement Continue_As_a_guest; 
    
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`label == 'SKIP'`]")
 	private MobileElement skip;
    
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
			
			AllBtn.click();
	    	super.waitForVisibility(AllBtn);

			PtStopIcon.click();
	    	super.waitForVisibility(list);
			Thread.sleep(2000);

	        List<MobileElement> texts = driver.findElements(MobileBy.iOSClassChain("**/XCUIElementTypeButton[`label CONTAINS 'Depart At '`]"));
	        scenario.log("<----- Number of records in Train Icon: " + (texts.size()-1)+" ------>");
			
			for(int i=1; i<texts.size(); i++)
			{
				String Data = driver.findElement(MobileBy.iOSClassChain("**/XCUIElementTypeButton[`label CONTAINS 'Depart At '`]["+(i+1)+"]")).getText();
				ArrayList TrainList= new ArrayList(Arrays.asList(Data.split(",")));
				
				if(TrainList.size() > 6)
				{
				   String TrainIcon =	(String) TrainList.get(6);
				   String Train = TrainIcon.substring(TrainIcon.lastIndexOf(" ")+1);
					Assert.assertEquals(Train, "Bus");
					scenario.log("# "+i+" Trian Icon displayed when we select Train option #");
				}
				else
				{
					String TrainIcon =	(String) TrainList.get(5);
					String[] result = TrainIcon.trim().split(" ", 2);
					String firstWalkIcon = result[0];
					Assert.assertEquals(firstWalkIcon, "Walk");
					scenario.log("# "+i+" Trian Icon displayed when we select Train option #");

				}
				
			}
			
			//PtStopIcon.click();
		}
			
		@Override
		public void verifyCycleIcon(Scenario scenario) throws InterruptedException 
		{
			 AllBtn.click();
			 
			 this.scenario = scenario;
			 CycleBtn.click();	
		     super.waitForVisibility(list);
			 Thread.sleep(2000);

			 List<MobileElement> texts = driver.findElements(MobileBy.iOSClassChain("**/XCUIElementTypeButton[`label CONTAINS 'Depart At '`]"));
			 scenario.log("<----- Number of records in cycle Icon: " + (texts.size()-1)+" ----->");
				
				for(int i=1; i<texts.size(); i++)
				{
					String Data = driver.findElement(MobileBy.iOSClassChain("**/XCUIElementTypeButton[`label CONTAINS 'Depart At '`]["+(i+1)+"]")).getText();
					//scenario.log("<----- "+i+" Getting Cycle Icon information: "+Data+" ----->");
					ArrayList CycleList= new ArrayList(Arrays.asList(Data.split(",")));

					String CycleIcon =	(String) CycleList.get(4);
					String[] result2 = CycleIcon.trim().split(" ", 2);
					String firstCycleIcon = result2[0];
					//scenario.log(i+" Cycle: " + firstCycleIcon);
					Assert.assertEquals(firstCycleIcon, "Cycle");
					scenario.log("# "+i+" Cycle Icon displayed when we select Cycle option #");
				}
				// CycleBtn.click();	

		}
				
	    @Override
	    public void verifyCarIcon(Scenario scenario) throws InterruptedException 
	    {
	    	AllBtn.click();	
	    	
	    	this.scenario = scenario;
	    	CarBtn.click();	
	    	super.waitForVisibility(list);
			Thread.sleep(2000);

	    	List<MobileElement> texts = driver.findElements(MobileBy.iOSClassChain("**/XCUIElementTypeButton[`label CONTAINS 'Depart At '`]"));
	    	scenario.log("<----- Number of records in Car Icon: " + (texts.size()-1)+" ------>");
	 		
	 		for(int i=1; i<texts.size(); i++)
	 		{
	 			String Data = driver.findElement(MobileBy.iOSClassChain("**/XCUIElementTypeButton[`label CONTAINS 'Depart At '`]["+(i+1)+"]")).getText();
	 			//scenario.log("<----- "+i+" Getting Car Icon information: "+Data+" ----->");
	 			ArrayList CarList= new ArrayList(Arrays.asList(Data.split(",")));
	 			String CarIcon =	(String) CarList.get(4);
	 			String[] result3 = CarIcon.trim().split(" ", 2);
	 			String firstCarIcon = result3[0];
	 			//System.out.println("Car: " + firstCarIcon);
	 			Assert.assertEquals(firstCarIcon, "Drive");
				scenario.log("# "+i+" Car Icon displayed when we select Car option #");
	 		}
	    	// CarBtn.click();	
		}
	   
				
	    @Override
		public void verifyWalkIcon(Scenario scenario) throws InterruptedException 
		{
	    	
	    	AllBtn.click();	
	    	
	    	this.scenario = scenario;
	    	WalkBtn.click();
	    	super.waitForVisibility(list);
			Thread.sleep(2000);

	    	List<MobileElement> texts = driver.findElements(MobileBy.iOSClassChain("**/XCUIElementTypeButton[`label CONTAINS 'Depart At '`]"));
	    	scenario.log("<----- Number of records in Walk Icon: " + (texts.size()-1)+" ------>");
	 		
	 		for(int i=1; i<texts.size(); i++)
	 		{
	 			String Data = driver.findElement(MobileBy.iOSClassChain("**/XCUIElementTypeButton[`label CONTAINS 'Depart At '`]["+(i+1)+"]")).getText();
	 			//scenario.log("<----- "+i+" Getting walk Icon information: "+Data+" ----->");
	 			ArrayList WalkList= new ArrayList(Arrays.asList(Data.split(",")));
	 			String WalkIcon =	(String) WalkList.get(5);
	 			String[] result = WalkIcon.trim().split(" ", 2);
	 			String firstWalkIcon = result[0];
	 			//System.out.println("Walk: " + firstWalkIcon);
	 			Assert.assertEquals(firstWalkIcon, "Walk");
				scenario.log("#"+i+" Walk Icon displayed when we select Walk option #");
	 		}
	 		//WalkBtn.click();
		}
				
		@Override
		public void verifyAllIcon(Scenario scenario) throws InterruptedException 
		{
			//AllBtn.click();
			this.scenario = scenario;
			AllBtn.click();	
			super.waitForVisibility(list);
			Thread.sleep(2000);
			
			List<MobileElement> texts = driver.findElements(MobileBy.iOSClassChain("**/XCUIElementTypeButton[`label CONTAINS 'Depart At '`]"));
			scenario.log("<------ Number of records in All Icon: " + (texts.size()-1)+" ------>");
				
				for(int i=1; i<texts.size(); i++)
				{
					String Data = driver.findElement(MobileBy.iOSClassChain("**/XCUIElementTypeButton[`label CONTAINS 'Depart At '`]["+(i+1)+"]")).getText();
					//scenario.log("<----- "+i+" Getting All icon information: "+Data+" ----->");
				}
		}
	    
}
