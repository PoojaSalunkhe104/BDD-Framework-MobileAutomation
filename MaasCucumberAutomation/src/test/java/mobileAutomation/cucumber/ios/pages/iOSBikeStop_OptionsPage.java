package mobileAutomation.cucumber.ios.pages;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import io.cucumber.java.Scenario;
import mobileAutomation.cucumber.common.BikeStop_Options;
import mobileAutomation.cucumber.common.iOSBasePage;

public class iOSBikeStop_OptionsPage extends iOSBasePage implements BikeStop_Options
{

	public iOSBikeStop_OptionsPage(AppiumDriver<MobileElement> driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
Scenario scenario;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='All']")
	private MobileElement AllBtn;
	
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`label CONTAINS 'Depart At '`]")
	private MobileElement list; 
    
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='Car_Icon']")
	private MobileElement CarBtn;
    
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`label CONTAINS 'Depart At '`][2]")
	private MobileElement FirstListItem;
    
	@iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeStaticText[`label == 'GO'`][1]")
	private MobileElement CarGoButton;

	@iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`label == 'Expand'`]")
	private MobileElement Expand;
	
	@iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`label == 'Collapse'`]")
	private MobileElement Collapse;
	
	@iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeStaticText[`label == 'End Route'`]")
	private MobileElement EndRoute;
	
	@iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeImage[`label == 'List'`]")
	private MobileElement List;
	
	@iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeStaticText[`label == 'Details'`]")
	private MobileElement Details;
	
	@iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeStaticText[`label == 'Start'`]")
	private MobileElement Start;
	
	@iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeStaticText[`label == 'Arrive'`]")
	private MobileElement Arrive;
	
	@iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeStaticText[`label == 'Done'`]")
	private MobileElement Done;
	
	@iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`label == 'Drive'`]")
	private MobileElement Drive;
	
	@iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`label == 'Walk'`]")
	private MobileElement Walk;
	
	@iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`label == 'Transit'`]")
	private MobileElement Transit;
	
	@iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`label == 'Cycle'`]")
	private MobileElement Cycle;
	
	@iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`label == 'Ride'`]")
	private MobileElement Ride;
	
	@iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`label == 'Close'`]")
	private MobileElement Close;
	
	@iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeStaticText[`label == 'GO'`][1]")
	private MobileElement Go;
	
	@iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`label CONTAINS 'Depart At '`][2]/XCUIElementTypeStaticText[3]")
	private MobileElement RequiredTimeForCycle;
	
	@iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`label CONTAINS 'Depart At '`][2]/XCUIElementTypeStaticText[4]")
	private MobileElement KMForCycle;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeImage[@name='GrabBar']/../XCUIElementTypeStaticText[1]")
	private MobileElement RequiredTime;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeImage[@name='GrabBar']/../XCUIElementTypeStaticText[2]")
	private MobileElement KMandArrivalTime;
	
	@iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeStaticText[`label == 'GO'`]")
	private MobileElement GoButton;
	
	@iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`label == 'Keep Only While Using'`]")
	private MobileElement KeepOnlyWhileUsing;
	
	@iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`label == 'Change to Always Allow'`]")
	private MobileElement ChangeToAlwaysAllow;
	
	@iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`label == 'END'`]")
	private MobileElement EndButton;
	
	@iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`label == 'back'`]")
	private MobileElement backButton;
	
	@iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`label == 'back'`]")
	private MobileElement cancel;

	@iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeStaticText[`label CONTAINS 'Arrive By '`][1]")
	private MobileElement ArrivalTime;  
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='Cycle_Icon']")
	private MobileElement CycleBtn;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='Train_Icon']")
	private MobileElement PtStopIcon;
	   
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='Walk_Icon']")
	private MobileElement WalkBtn;
    
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`label == 'Allow While Using App'`]")
   	private MobileElement AllowWhileUsingApp; 
    
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeStaticText[`label == 'Continue'`]")
   	private MobileElement Continue; 
    
	    @Override
		public void ClickOnCarIcon(Scenario scenario) throws InterruptedException 
		{
		 this.scenario = scenario;
	    	
		 AllBtn.click();
	     super.waitForVisibility(list);
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
	 		
	 		int text = (texts.size()-1);
	 		System.out.println("#car text: "+text);
			if(text == 0)
			{
				scenario.log("<----- 0 records found ----->");
			}
			
				FirstListItem.click();
				//super.waitForVisibility(CarGoButton);
				Thread.sleep(5000);
	            try{
	            Continue.click();
	            AllowWhileUsingApp.click();
	            Thread.sleep(10000);
	            }catch(Exception e) {
	            	
	            }		
	            super.waitForVisibility(CarGoButton);

	            boolean CarGoBtn = CarGoButton.isDisplayed();
				Assert.assertEquals(CarGoBtn, true);
				scenario.log("<----- Go button is displayed after click on car--> Actual Result: "+CarGoBtn+" --||-- Expected Result: true ----->");
			
		     	//CarGoButton.click();
		}
	    
	    @Override
		public void verifyCarIcon(Scenario scenario) throws InterruptedException 
		{
	    	this.scenario = scenario;
	    	//wait
	    	Thread.sleep(10000);
	    	super.waitForVisibility(Drive);
	    	//Verify all option are present
	    	boolean drive = Drive.isDisplayed();
	    	System.out.println("drive: "+drive);
	    	Assert.assertEquals(drive, true);
 			scenario.log("# Drive Icon is displayed #");
	    	
	    	boolean walk = Walk.isDisplayed();
	    	System.out.println("walk: "+walk);
	    	Assert.assertEquals(walk, true);
 			scenario.log("# Walk Icon is displayed #");

	    	boolean transit = Transit.isDisplayed();
	    	System.out.println("transit: "+transit);
	    	Assert.assertEquals(transit, true);
 			scenario.log("# Transit Icon is displayed #");

	    	boolean cycle = Cycle.isDisplayed();
	    	System.out.println("cycle: "+cycle);
	    	Assert.assertEquals(cycle, true);
 			scenario.log("# Cycle Icon is displayed #");

	    	boolean ride = Ride.isDisplayed();
	    	System.out.println("ride: "+ride);
 			Assert.assertEquals(ride, true);
 			scenario.log("# Ride Icon is displayed #");

	    	//click on car drive
	    	Drive.click();
 			scenario.log("Click on Drive option");

	    	//Go is displayed or not then click on go
	    	super.waitForVisibility(Go);
	    	Go.click();
 			scenario.log("Click on Go Button");
	    	
	    	//Click on expand then click on collapse then click on expand
	    	super.waitForVisibility(Expand);
	    	Expand.click();
	    	
	    	super.waitForVisibility(Collapse);
	    	Collapse.click();
	    	
	    	super.waitForVisibility(Expand);
	    	Expand.click();
	    	
	    	//click on list
	    	super.waitForVisibility(List);
	    	List.click();
 			scenario.log("Click on Done/List option");

	    	//display start or (scroll into arrive then search ) arrive
	    	super.waitForVisibility(Start);
	    	boolean start = Start.isDisplayed();
	    	System.out.println("start: "+start);
	    	Assert.assertEquals(start, true);
 			scenario.log("# Start Icon is displayed #");
	    
	    	super.waitForVisibility(Arrive);
	    	boolean arrive = Arrive.isDisplayed();
	    	System.out.println("Arrive: "+arrive);
	    	Assert.assertEquals(arrive, true);
 			scenario.log("# arrive Icon is displayed #");

	    	//click on done
	    	Done.click();
 			scenario.log("Click on Done");
	    	
	    	//click on expand
	    	super.waitForVisibility(Expand);
	    	Expand.click();
	    	
	    	//click on end route
	    	super.waitForVisibility(EndRoute);
	    	EndRoute.click();
 			scenario.log("Click on End Route button");
		}
	    
	    //*******************************************************************************************//
	    @Override
	  		public void ClickOnCycleIcon(Scenario scenario) throws InterruptedException 
	  		{
	  		 this.scenario = scenario;
	  		 
	  		 AllBtn.click();
	  	     super.waitForVisibility(list);
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
	  			int text = (texts.size()-1);
	  	 		System.out.println("#cycle text: "+text);

	  			if(text == 0)
	  			{
	  				scenario.log("<----- 0 records found ----->");
	  			}
	  			
	  				String ArrivaltimeBeforeClickonItem = ArrivalTime.getAttribute("name").trim();
	  				String[] parts = ArrivaltimeBeforeClickonItem.split(",");
	  				String ArriveBys = parts[1].trim();
	  				String ArriveBy = ArriveBys.substring(ArriveBys.indexOf("By ") + 3 , ArriveBys.length());
	  				System.out.println("# Arrival time before Click on Item: "+ArriveBy);  
	  		
	  				String requiredTimeForCycles = RequiredTimeForCycle.getAttribute("name").trim();
	  				String requiredTimeForCycle = requiredTimeForCycles.replaceAll("\\s", ""); //
	  				if(requiredTimeForCycle.contains("hrs"))
	  				{
	  					requiredTimeForCycle = requiredTimeForCycle.replaceAll("hrs", "hrs ");
	  				}
	  				System.out.println("# Required Time For Cycle before Click on Item: "+requiredTimeForCycle);
	  				
	  				String KMForCycles = KMForCycle.getAttribute("name").trim();
	  				System.out.println("# Required KMs For Cycle before Click on Item: "+KMForCycles);
	  		
	  				
	  				FirstListItem.click();
	  				System.out.println("=====================");
	  				
	  				String AfterClickRequiredTime = RequiredTime.getAttribute("name").trim();
	  				System.out.println("# Required Time For Cycle after Click on Item: "+AfterClickRequiredTime);
	  		
	  				String AfterClickKA = KMandArrivalTime.getAttribute("name");
	  				String[] part = AfterClickKA.split("•");
	  				String PartOne = part[0].trim();
	  				String PartTwo = part[1].trim();
	  				System.out.println("# Required KMs For Cycle after Click on Item: "+PartOne);
	  				System.out.println("# Required Time For Cycle after Click on Item: "+PartTwo);
	  				
	  				Assert.assertEquals(requiredTimeForCycle, AfterClickRequiredTime);
	  				scenario.log("<----- Required time for arrive by cycle is matched--> Actual Result: "+AfterClickRequiredTime+" --||-- Expected Result: "+requiredTimeForCycle+" ----->");
	  		
	  				Assert.assertEquals(KMForCycles, PartOne);
	  				scenario.log("<----- Kilometers is matched--> Actual Result: "+PartOne+" --||-- Expected Result: "+KMForCycles+" ----->");
	  		
	  				Assert.assertEquals(ArriveBy, PartTwo);
	  				scenario.log("<----- Arrive By timing is matched--> Actual Result: "+PartTwo+" --||-- Expected Result: "+ArriveBy+" ----->");
	  		
	  		        //Verify Go button is displayed
	  				boolean GoBtn = GoButton.isDisplayed();
	  				//Assert.assertEquals(GoBtn, true);
	  				scenario.log("<----- Go button is displayed--> Actual Result: "+GoBtn+" --||-- Expected Result: true ----->");
	  		
	  				//backButton.click();
	  				//KeepOnlyWhileUsing.click();
	  				//GoButton.click();
	  				Actions action = new Actions(driver);

	  				action.moveToElement(GoButton).click().perform();
	  				scenario.log("Click on Go button");
	  	    	
	  		}
	  	    
	  	    @Override
	  		public void verifyCycleIcon(Scenario scenario) throws InterruptedException 
	  		{
	  	    	this.scenario = scenario;
	  	    	
	  	    	try {
	  	    	super.waitForVisibility(KeepOnlyWhileUsing);
	  	    	KeepOnlyWhileUsing.click();
	  	    	scenario.log("Click on Keep only while using pop-up");
	  	    	
	  	    	super.waitForVisibility(cancel);
	  	    	cancel.click();
	  	    	scenario.log("Click on cancel pop-up");
	  	    	}
	  	    	catch (Exception e) {
	  			     
	  		    } 
	  	    	super.waitForVisibility(EndButton);
	  	    	EndButton.click();
	  	    	scenario.log("Click on End button");

	  		}
	  	    
		    //*******************************************************************************************//

	  	  @Override
			public void ClickOnTrainIcon(Scenario scenario) throws InterruptedException 
			{
			 this.scenario = scenario;
			 
			  AllBtn.click();
			  super.waitForVisibility(list);
			  PtStopIcon.click();
			  super.waitForVisibility(list);
			  Thread.sleep(2000);

		        List<MobileElement> texts = driver.findElements(MobileBy.iOSClassChain("**/XCUIElementTypeButton[`label CONTAINS 'Depart At '`]"));
		        scenario.log("<----- Number of records in Train Icon: " + (texts.size()-1)+" ------>");
				
				for(int i=1; i<texts.size(); i++)
				{
					String Data = driver.findElement(MobileBy.iOSClassChain("**/XCUIElementTypeButton[`label CONTAINS 'Depart At '`]["+(i+1)+"]")).getText();
					//System.out.println(i+" Getting Train Icon information: "+Data);
					//scenario.log("<----- "+i+" Getting Train Icon information: "+Data+" ----->");
					ArrayList TrainList= new ArrayList(Arrays.asList(Data.split(",")));
					
					if(TrainList.size() > 6)
					{
					   String TrainIcon =	(String) TrainList.get(6);
					   String Train = TrainIcon.substring(TrainIcon.lastIndexOf(" ")+1);
					 //  scenario.log(i+" Train: "+Train);
						Assert.assertEquals(Train, "Bus");
						scenario.log("# "+i+" Trian Icon displayed when we select Train option #");
					}
					else
					{
						String TrainIcon =	(String) TrainList.get(5);
						String[] result = TrainIcon.trim().split(" ", 2);
						String firstWalkIcon = result[0];
						//scenario.log(i+" Train: "+firstWalkIcon);
						Assert.assertEquals(firstWalkIcon, "Walk");
						scenario.log("# "+i+" Trian Icon displayed when we select Train option #");

					}
					
				}
				
	            int text = (texts.size());
		 		System.out.println("#train text: "+text);

		 		if(text == 0)
				{
					scenario.log("<----- 0 records found ----->");
				}
			
			}
		    
		    @Override
			public void verifyTrainIcon(Scenario scenario) throws InterruptedException 
			{
		    	this.scenario = scenario;
		    	String ArrivaltimeBeforeClickonItem = ArrivalTime.getAttribute("name").trim();
				//System.out.println(" Arrival time Before Click on Item: "+ArrivaltimeBeforeClickonItem);
				String[] parts = ArrivaltimeBeforeClickonItem.split(",");
				String ArriveBy = parts[1].trim();
				//System.out.println("Arrival time before Click on Item: "+ArriveBy);
				
				FirstListItem.click();
				
				String ArrivaltimeafterClickonItem = ArrivalTime.getAttribute("name").trim();
				//System.out.println("Arrival time after Click on Item: "+ArrivaltimeafterClickonItem);
				Assert.assertEquals(ArriveBy, ArrivaltimeafterClickonItem);
				scenario.log("<----- Arrive By timing is matched--> Actual Result: "+ArriveBy+" --||-- Expected Result: "+ArrivaltimeafterClickonItem+" ----->");
		
			}
		    //*******************************************************************************************//
		    @Override
			public void ClickOnWalkIcon(Scenario scenario) throws InterruptedException 
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
		 		
		 		int text = (texts.size()-1);
		 		System.out.println("#walk text: "+text);

		 		if(text == 0)
				{
					scenario.log("<----- 0 records found ----->");
					FirstListItem.click();
				}
				else
				{
					FirstListItem.click();
				}
			}
		    
		    
		    @Override
			public void verifyWalkIcon(Scenario scenario) throws InterruptedException 
			{
		    	this.scenario = scenario;
		    	//wait
		    	Thread.sleep(5000);
	            try{
	            Continue.click();
	            AllowWhileUsingApp.click();
	            Thread.sleep(10000);
	            }catch(Exception e) {
	            	
	            }
	            
	            super.waitForVisibility(Drive);
		    	//Verify all option are present
		    	boolean drive = Drive.isDisplayed();
		    	System.out.println("drive: "+drive);
		    	Assert.assertEquals(drive, true);
	 			scenario.log("# Drive Icon is displayed #");
		    	
		    	boolean walk = Walk.isDisplayed();
		    	System.out.println("walk: "+walk);
		    	Assert.assertEquals(walk, true);
	 			scenario.log("# Walk Icon is displayed #");

		    	boolean transit = Transit.isDisplayed();
		    	System.out.println("transit: "+transit);
		    	Assert.assertEquals(transit, true);
	 			scenario.log("# Transit Icon is displayed #");

		    	boolean cycle = Cycle.isDisplayed();
		    	System.out.println("cycle: "+cycle);
		    	Assert.assertEquals(cycle, true);
	 			scenario.log("# Cycle Icon is displayed #");

		    	boolean ride = Ride.isDisplayed();
		    	System.out.println("ride: "+ride);
	 			Assert.assertEquals(ride, true);
	 			scenario.log("# Ride Icon is displayed #");

		    	//click on car drive
		    	Drive.click();
	 			scenario.log("Click on Drive option");

		    	//Go is displayed or not then click on go
		    	super.waitForVisibility(Go);
		    	Thread.sleep(5000);
		    	Go.click();
	 			scenario.log("Click on Go Button");

		    	//Click on expand then click on collapse then click on expand
		    	super.waitForVisibility(Expand);
		    	Expand.click();
		    	
		    	super.waitForVisibility(Collapse);
		    	Collapse.click();
		    	
		    	super.waitForVisibility(Expand);
		    	Expand.click();
		    	
		    	//click on list
		    	super.waitForVisibility(List);
		    	List.click();
	 			scenario.log("Click on Done/List option");

		    	//display start or (scroll into arrive then search ) arrive
		    	super.waitForVisibility(Start);
		    	boolean start = Start.isDisplayed();
		    	System.out.println("start: "+start);
		    	Assert.assertEquals(start, true);
	 			scenario.log("# Start Icon is displayed #");
		    
		    	super.waitForVisibility(Arrive);
		    	boolean arrive = Arrive.isDisplayed();
		    	System.out.println("Arrive: "+arrive);
		    	Assert.assertEquals(arrive, true);
	 			scenario.log("# arrive Icon is displayed #");

		    	//click on done
		    	Done.click();
	 			scenario.log("Click on Done");
		    	
		    	//click on expand
		    	super.waitForVisibility(Expand);
		    	Expand.click();
		    	
		    	//click on end route
		    	super.waitForVisibility(EndRoute);
		    	EndRoute.click();
	 			scenario.log("Click on End Route button");
		    	
			}
	  	    
		    //*******************************************************************************************//


}
