package mobileAutomation.cucumber.android.pages;

import java.util.List;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.cucumber.java.Scenario;
import mobileAutomation.cucumber.common.AndroidBasePage;
import mobileAutomation.cucumber.common.BikeStop_Options;

public class AndroidBikeStop_OptionsPage extends AndroidBasePage implements BikeStop_Options
{

	public AndroidBikeStop_OptionsPage(AppiumDriver<MobileElement> driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	Scenario scenario;
	
	@AndroidFindBy(id = "com.intelematics.maas.rideplan.dev:id/btnAll")
	private MobileElement AllBtn;
	
	@AndroidFindBy(xpath = "//android.widget.RelativeLayout")
	private MobileElement list; 
    
	@AndroidFindBy(id = "com.intelematics.maas.rideplan.dev:id/btnDrive")
	private MobileElement CarBtn;
    
	@AndroidFindBy(xpath = "//android.widget.RelativeLayout[1]")
	private MobileElement FirstListItem;
	
	@AndroidFindBy(id = "com.intelematics.maas.rideplan.dev:id/btnPublicTransport")
	private MobileElement PtStopIcon;
	   
	   
	@AndroidFindBy(id = "com.intelematics.maas.rideplan.dev:id/btnWalk")
	private MobileElement WalkBtn;
    
	@AndroidFindBy(id = "com.android.permissioncontroller:id/permission_allow_foreground_only_button")
   	private MobileElement AllowWhileUsingApp; 

	@AndroidFindBy(xpath = "//android.widget.RelativeLayout[1]/android.widget.TextView[1]")  
	private MobileElement ArrivalTime;
	
	@AndroidFindBy(id = "com.intelematics.maas.rideplan.dev:id/txtArriveByTime")  
	private MobileElement ArrivalTimeAfterClickOnTrain;
	
	@AndroidFindBy(id = "com.intelematics.maas.rideplan.dev:id/btnClose") 
	private MobileElement BtnClose;
	
	@AndroidFindBy(id = "com.intelematics.maas.rideplan.dev:id/btnCycle")
	private MobileElement CycleBtn;
	
	//cycle
	@AndroidFindBy(id = "com.intelematics.maas.rideplan.dev:id/txtLegDistance")
	private MobileElement RequiredTimeForCycle;
	
	@AndroidFindBy(id = "com.intelematics.maas.rideplan.dev:id/txtDistance")
	private MobileElement KMForCycle;
	
	@AndroidFindBy(id = "com.intelematics.maas.rideplan.dev:id/duration")
	private MobileElement DurationAfterClickOnCycle;
	
	@AndroidFindBy(id = "com.intelematics.maas.rideplan.dev:id/distance_n_arrival_time")
	private MobileElement Distance_ArrivalTimeAfterClickOnCycle;
	
	@AndroidFindBy(id = "com.intelematics.maas.rideplan.dev:id/btnStartNav")
	private MobileElement GoButton;

	@AndroidFindBy(id = "com.intelematics.maas.rideplan.dev:id/btnEndNav")
	private MobileElement EndButton; 
	
	@AndroidFindBy(id = "com.intelematics.maas.rideplan.dev:id/instruction")
	private MobileElement GetText_GoPage_Cycle;
	
	//car and walk
	@AndroidFindBy(id = "com.intelematics.maas.rideplan.dev:id/instruction")
	private MobileElement skip; 
	
	@AndroidFindBy(xpath = "//android.widget.EditText[1]/android.widget.LinearLayout/android.widget.TextView")
	private MobileElement source; 
	
	@AndroidFindBy(xpath = "//android.widget.EditText[2]/android.widget.LinearLayout/android.widget.TextView")
	private MobileElement destination; 
	
	@AndroidFindBy(xpath = "//android.widget.ImageView[@content-desc='Swap start and destination']")
	private MobileElement interchange; 
	
	@AndroidFindBy(id = "com.google.android.apps.maps:id/start_button")
	private MobileElement preview; 
	
	@AndroidFindBy(id = "com.google.android.apps.maps:id/persistent_footer_secondary_button")
	private MobileElement steps; 
	
	@AndroidFindBy(xpath = "//android.widget.ImageView[@content-desc='Show next']")
	private MobileElement showNext; 
	
	@AndroidFindBy(xpath = "//android.widget.ImageView[@content-desc='Show previous']")
	private MobileElement showPrevious;
	
	@AndroidFindBy(xpath = "(//android.widget.FrameLayout/android.widget.LinearLayout/android.widget.TextView)[3]")
	private MobileElement addressOnRoutePriview;
	
	@Override
	public void ClickOnCarIcon(Scenario scenario) throws InterruptedException {
		 this.scenario = scenario;
	    	
		 AllBtn.click();
		 Thread.sleep(3000);	
	     super.waitForVisibility(list);
	     CarBtn.click();
	     super.waitForVisibility(list);
		 Thread.sleep(5000);	
		 
		 List<MobileElement> texts = driver.findElements(MobileBy.xpath("//android.widget.RelativeLayout"));
	     scenario.log("<----- Number of records found when we select Car option: " + (texts.size())+" ------>");
  	     
	    int text = (texts.size());
	 	System.out.println("#Car text: "+text);

	 		if(text == 0)
			{
				scenario.log("<----- No records found ----->");
			}
	 	
	}

	@Override
	public void verifyCarIcon(Scenario scenario) throws InterruptedException {
		this.scenario = scenario;
		
		FirstListItem.click();
	    scenario.log("# Click on first displayed car #");

	    try {
	    	
	    	if(skip.isDisplayed())
	    	{
	            driver.navigate().back();
	    	}
	    }catch(Exception e) {
	    	
	    }
	    
	//	String Source = source.getText().trim();
	//	String Destination = destination.getText().trim();
		
		interchange.click();
	    scenario.log("# Click on Interchange button #");

	//	String SourceAfterInterchange = source.getText().trim();
	//	String DestinationAfterInterchange = destination.getText().trim();
		
	//	Assert.assertEquals(Source, DestinationAfterInterchange);
	//	scenario.log("<----- Verifying Source & Destination address after click on Interchange button--> Actual Result: "+Source+" --||-- Expected Result: "+DestinationAfterInterchange+" ----->");

	//	Assert.assertEquals(Destination, SourceAfterInterchange);
	//	scenario.log("<----- Verifying Source & Destination address after click on Interchange button--> Actual Result: "+Destination+" --||-- Expected Result: "+SourceAfterInterchange+" ----->");

		preview.click();
	    scenario.log("# Click on preview button #");

	 	//click on show next 
	 	showNext.click();
	 	showNext.click();
        showNext.click();
        showNext.click();
	    scenario.log("# Click on show next button #");

        //Click on show previous
        showPrevious.click();
        showPrevious.click();
        showPrevious.click();
        showPrevious.click();
	    scenario.log("# Click on show previous button #");

	    //click on back 
	    driver.navigate().back();
	    
        //click on steps
        steps.click();
        scenario.log("# Click on steps button #");

        //Verifying again back to map page
        steps.click();
	    scenario.log("# Click on show map button#");

	    boolean previewBtn = preview.isDisplayed();
		scenario.log("<----- Verifying we again back on Map page--> Actual Result: "+previewBtn+" --||-- Expected Result: True ----->");

	}
    //*******************************************************************************************//

	@Override
	public void ClickOnCycleIcon(Scenario scenario) throws InterruptedException {
		 this.scenario = scenario;
  		 
  		 AllBtn.click();
  		 Thread.sleep(2000);
  	     super.waitForVisibility(list);

  	     CycleBtn.click();
  		 Thread.sleep(5000);
  	     super.waitForVisibility(list);
  		 
  		 List<MobileElement> texts = driver.findElements(MobileBy.xpath("//android.widget.RelativeLayout"));
	     scenario.log("<----- Number of records found when we select Cycle option: " + (texts.size())+" ------>");
  	     
	    int text = (texts.size());
	 	System.out.println("#cycle text: "+text);

	 		if(text == 0)
			{
				scenario.log("<----- No records found ----->");
			}
	}

	@Override
	public void verifyCycleIcon(Scenario scenario) throws InterruptedException {
		
		this.scenario = scenario;
    	String ArrivaltimeBeforeClickonItem = ArrivalTime.getText().trim();
		System.out.println(" Arrival time Before Click on Item: "+ArrivaltimeBeforeClickonItem);
		String[] parts = ArrivaltimeBeforeClickonItem.split("-");
		String ArriveBy = parts[1].trim();
		System.out.println("Arrival time before Click on Item: "+ArriveBy);
		
		String requiredTimeForCycles = RequiredTimeForCycle.getText().trim();
		System.out.println("# Required Time For Cycle before Click on Item: "+requiredTimeForCycles);

		String KMForCycles = KMForCycle.getText().trim();
		System.out.println("# Required KMs For Cycle before Click on Item: "+KMForCycles);
	
		FirstListItem.click();
		System.out.println("=====================");

		String AfterClickRequiredTime = DurationAfterClickOnCycle.getText().trim();
			System.out.println("# Required Time For Cycle after Click on Item: "+AfterClickRequiredTime);
	
			String AfterClickKA = Distance_ArrivalTimeAfterClickOnCycle.getText().trim();
			String[] part = AfterClickKA.split("•");
			String PartOne = part[0].trim();
			String PartTwo = part[1].trim();
			System.out.println("# Required KMs For Cycle after Click on Item: "+PartOne);
			System.out.println("# Required Time For Cycle after Click on Item: "+PartTwo);
			
			Assert.assertEquals(requiredTimeForCycles, AfterClickRequiredTime);
			scenario.log("<----- Required time for arrive by cycle is matched--> Actual Result: "+AfterClickRequiredTime+" --||-- Expected Result: "+requiredTimeForCycles+" ----->");
	
			Assert.assertEquals(KMForCycles, PartOne);
			scenario.log("<----- Kilometers is matched--> Actual Result: "+PartOne+" --||-- Expected Result: "+KMForCycles+" ----->");
	
		//	Assert.assertEquals(ArriveBy, PartTwo);
			scenario.log("<----- Arrive By timing is matched--> Actual Result: "+PartTwo+" --||-- Expected Result: "+ArriveBy+" ----->");
	
			Thread.sleep(3000);
			
			
			List<MobileElement> elements = driver.findElements(MobileBy.id("com.intelematics.maas.rideplan.dev:id/instruction"));

			 // Loop to print one by one
		    for (int j = 0; j < elements.size(); j++) {
		        System.out.println("Get Data on Go page: "+elements.get(j).getText());

		    }
		    
	        //Verify Go button is displayed
			boolean GoBtn = GoButton.isDisplayed();
			Assert.assertEquals(GoBtn, true);
			scenario.log("<----- Go button is displayed--> Actual Result: "+GoBtn+" --||-- Expected Result: true ----->");
			Actions action = new Actions(driver);
			action.moveToElement(GoButton).click().perform();
			scenario.log("Click on Go button");
			
	        //Verify End button is displayed

			super.waitForVisibility(EndButton);
			boolean EndBtn = EndButton.isDisplayed();
			Assert.assertEquals(EndBtn, true);
			scenario.log("<----- End button is displayed--> Actual Result: "+EndBtn+" --||-- Expected Result: true ----->");
			action.moveToElement(EndButton).click().perform();
			scenario.log("Click on End button");
		
	}
    //*******************************************************************************************//


	@Override
	public void ClickOnTrainIcon(Scenario scenario) throws InterruptedException {

		 this.scenario = scenario;
		 
		  AllBtn.click();
		  Thread.sleep(3000);
		  super.waitForVisibility(list);
		  PtStopIcon.click();
		  super.waitForVisibility(list);
		  
		  Thread.sleep(5000);
		  List<MobileElement> texts = driver.findElements(MobileBy.xpath("//android.widget.RelativeLayout"));
	      scenario.log("<-----  Number of records found when we select Train option: " + (texts.size())+" ------>");
		
	      int text = (texts.size());
	 		System.out.println("#train text: "+text);

	 		if(text == 0)
			{
				scenario.log("<----- No records found ----->");
			}
	}

	@Override
	public void verifyTrainIcon(Scenario scenario) throws InterruptedException {
		this.scenario = scenario;
    	String ArrivaltimeBeforeClickonItem = ArrivalTime.getText().trim();
		System.out.println(" Arrival time Before Click on Item: "+ArrivaltimeBeforeClickonItem);
		String[] parts = ArrivaltimeBeforeClickonItem.split("-");
		String ArriveBy = parts[1].trim();
		System.out.println("Arrival time before Click on Item: "+ArriveBy);
		
		FirstListItem.click();
		
		String ArrivaltimeafterClickonItem = ArrivalTimeAfterClickOnTrain.getText().trim();
		System.out.println("Arrival time after Click on Item: "+ArrivaltimeafterClickonItem);
		Assert.assertEquals(ArriveBy, ArrivaltimeafterClickonItem);
		scenario.log("<----- Arrive By timing is matched--> Actual Result: "+ArriveBy+" --||-- Expected Result: "+ArrivaltimeafterClickonItem+" ----->");
		
	}
    //*******************************************************************************************//

	
	@Override
	public void ClickOnWalkIcon(Scenario scenario) throws InterruptedException {
		
       this.scenario = scenario;		
		
		AllBtn.click();
    	Thread.sleep(3000);

		super.waitForVisibility(list);
    	WalkBtn.click();
    	super.waitForVisibility(list);
    	Thread.sleep(5000);
		List<MobileElement> texts = driver.findElements(MobileBy.xpath("//android.widget.RelativeLayout"));
	    scenario.log("<-----  Number of records found when we select walk option: " + (texts.size())+" ------>");
		
	      int text = (texts.size());
	 		System.out.println("#Walk text: "+text);

	 		if(text == 0)
			{
				scenario.log("<----- No records found ----->");
			}	
        
	}
	
	@Override
	public void verifyWalkIcon(Scenario scenario) throws InterruptedException
	{
		  this.scenario = scenario;
			
			FirstListItem.click();
		    scenario.log("# Click on first displayed walk #");
			
		    try {
		    	
		    	if(skip.isDisplayed())
		    	{
		            driver.navigate().back();
		    	}
		    }catch(Exception e) {
		    	
		    }
		    
		//	String Source = source.getText().trim();
		//	String Destination = destination.getText().trim();
			
			interchange.click();
		    scenario.log("# Click on Interchange button #");

		//	String SourceAfterInterchange = source.getText().trim();
		//	String DestinationAfterInterchange = destination.getText().trim();
			
		//	Assert.assertEquals(Source, DestinationAfterInterchange);
		//	scenario.log("<----- Verifying Source & Destination address after click on Interchange button--> Actual Result: "+Source+" --||-- Expected Result: "+DestinationAfterInterchange+" ----->");

		//	Assert.assertEquals(Destination, SourceAfterInterchange);
		//	scenario.log("<----- Verifying Source & Destination address after click on Interchange button--> Actual Result: "+Destination+" --||-- Expected Result: "+SourceAfterInterchange+" ----->");

			preview.click();
		    scenario.log("# Click on preview button #");

		 	//click on show next 
		 	showNext.click();
		 	showNext.click();
	        showNext.click();
	        showNext.click();
		    scenario.log("# Click on show next button #");


	        //Click on show previous
	        showPrevious.click();
	        showPrevious.click();
	        showPrevious.click();
	        showPrevious.click();
		    scenario.log("# Click on show previous button #");

		    //click on back 
		    driver.navigate().back();
		    
	        //click on steps
	        steps.click();
	        scenario.log("# Click on steps button #");

	        //Verifying again back to map page
	        steps.click();
		    scenario.log("# Click on show map button#");

		    boolean previewBtn = preview.isDisplayed();
			scenario.log("<----- Verifying we again back on Map page--> Actual Result: "+previewBtn+" --||-- Expected Result: True ----->");
	}
}
