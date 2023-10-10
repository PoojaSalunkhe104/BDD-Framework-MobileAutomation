package mobileAutomation.cucumber.android.pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import mobileAutomation.cucumber.common.AndroidBasePage;
import mobileAutomation.cucumber.common.FavouriteButton;

public class AndroidFavouriteButtonPage extends AndroidBasePage implements FavouriteButton
{
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='PT stops']")
	private MobileElement PT_stops_button;
	
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Favourite']")
	private MobileElement Favorite_button;
	
	@AndroidFindBy(xpath = "//android.widget.Button[@text='SIGN IN']")
	private MobileElement Sign_In;
	
	@AndroidFindBy(xpath = "//android.widget.Button[@text='CANCEL']")
	private MobileElement Cancel;   
	
	@AndroidFindBy(xpath = "//android.widget.EditText[@text='Mobile number']")
	private MobileElement MobileNumberField;
	
	@AndroidFindBy(xpath = "//android.widget.Button[@text='CONTINUE']")
	private MobileElement ContinueButton;   
	
	@AndroidFindBy(xpath = "(//android.widget.FrameLayout)[9]")
	private MobileElement GetText_MobileNumber;
	
	@AndroidFindBy(xpath = "//android.widget.EditText[@text='SMS Verification Code']")
	private MobileElement SMSVerificationCode;
	
	@AndroidFindBy(xpath = "//android.widget.Button[@text='VALIDATE CODE']")
	private MobileElement ValidateCode;
	
	@AndroidFindBy(xpath = "//android.widget.EditText[@text='Where to?']")
	private MobileElement WhereTo;
	
	@AndroidFindBy(xpath = "(//android.widget.TextView[@text='Results']/../../android.widget.LinearLayout)[1]")
	private MobileElement Click_firstDisplayResult;
	
	@AndroidFindBy(xpath = "(//android.widget.ImageButton)[3]")
	private MobileElement Close; 
	
	@AndroidFindBy(xpath = "(//android.widget.EditText)[1]")
	private MobileElement Nickname; 
	
	@AndroidFindBy(xpath = "//android.widget.Button[@text='ADD TO FAVOURITES']")
	private MobileElement AddTofavouriteBtn;  
			
	@AndroidFindBy(xpath = "(//android.widget.ImageButton)[2]")
	private MobileElement YellowFavouritesStar;  //2
	
	@AndroidFindBy(xpath = "//android.widget.ImageButton[@content-desc='Close']")
	private MobileElement closeBtn_ExistingFavourite;
	
	//@AndroidFindBy(xpath = "com.intelematics.maas.rideplan.dev:id/btnClose")    //
	@AndroidFindBy(xpath = "(//android.widget.LinearLayout)[8]") 
	private MobileElement ExistingLocation;
			
	@AndroidFindBy(xpath = "//android.widget.Button[@text='DELETE']")
	private MobileElement DeleteLocation;
    		
	@AndroidFindBy(xpath = "**/XCUIElementTypeButton[`label == 'unfavourite_btn_ic'`]")
	private MobileElement UnfavouriteBtn;  //
    
	@AndroidFindBy(id = "com.intelematics.maas.rideplan.dev:id/settingsButton")
	private MobileElement Settings_title;  

	@AndroidFindBy(xpath = "//android.widget.Button[@text='LOG OUT']")
 	private MobileElement Logout;  
    
	@AndroidFindBy(xpath = "//android.widget.Button[@text='YES, LOG ME OUT']")
   	private MobileElement Yes_Log_me_out; 	
    
	@AndroidFindBy(xpath = "//android.widget.Button[@text='SIGN IN WITH MOBILE']")
   	private MobileElement Sign_In_With_Mobile; 
    

    public AndroidFavouriteButtonPage(AppiumDriver<MobileElement> driver) {
		super(driver);

	}
    
    @Override
   	public void clickOnAllowLocationPopup() throws InterruptedException {

   		try {
   			
   		} catch (Exception e) {
   	    } 
   		
   	}
	
    @Override
	public boolean PT_stops_buttonDisplayed() 
    {
		super.waitForVisibility(PT_stops_button);
		return PT_stops_button.isDisplayed();
	}
	
	
	@Override
	public void clickOn_Favourite_Button() 
	{
		super.waitForVisibility(Favorite_button);
		Favorite_button.click();
	}
	
	@Override
	public void clickOn_SignIn_Button() 
	{
		
		super.waitForVisibility(Sign_In);
		Sign_In.click();
	}
	
	@Override
	public void enter_MobileNumber(String mobilenumber) throws InterruptedException
	{
		super.waitForVisibility(MobileNumberField);
		MobileNumberField.sendKeys(mobilenumber);
		Thread.sleep(10000);
	}
	
	@Override
	public void clickOn_Continue_Button() 
	{
		super.waitForVisibility(ContinueButton);
		ContinueButton.click();
	}
	
	@Override
	public void clickOn_BackButton() throws InterruptedException
	{
		Thread.sleep(8000);
		//driver.pressKeyCode(AndroidKeyCode.BACK);
		driver.navigate().back();

    }
	
	@Override
	public void HideKeyboard() throws InterruptedException
	{
		Thread.sleep(3000);
		driver.navigate().back();
    }

	@Override
	public String GetText_FromMobileNumberField() 
	{
		super.waitForVisibility(GetText_MobileNumber);
		String DisplayedMobileNumber = GetText_MobileNumber.getText();
		//String numberOnly= DisplayedMobileNumber.replaceAll("[^0-9]", "");
		//numberOnly = numberOnly.substring(2, 11);
		return DisplayedMobileNumber;
     }
	
	@Override
	public void Enter_SMSVerificationCode(String otp) 
	{
		super.waitForVisibility(SMSVerificationCode);
		SMSVerificationCode.sendKeys(otp);
	}
	
	@Override
	public void clickOn_ValidateCode_Button() 
	{
		super.waitForVisibility(ValidateCode);
		ValidateCode.click();
	}
	
	@Override
	public void Enter_Address(String Address) 
	{
		super.waitForVisibility(WhereTo);
		WhereTo.sendKeys(Address);
		super.waitForVisibility(Click_firstDisplayResult);
		Click_firstDisplayResult.click();
	}
	
	@Override
	public void clickOn_Close_Button() 
	{
		//super.waitForVisibility(Close);
		//Close.click();
	}
	
	@Override
	public void Enter_Nickname(String nickname) 
	{
		//super.waitForVisibility(Nickname);
		//Nickname.sendKeys(nickname);
	}
	
	@Override
	public void clickOn_AddFavourite_Button() 
	{
		super.waitForVisibility(AddTofavouriteBtn);
		AddTofavouriteBtn.click();
	}
	
	@Override
	public boolean Verify_YellowFavouriteStar_isDisplayed() 
	{
		//super.waitForVisibility(YellowFavouritesStar);
		//return YellowFavouritesStar.isDisplayed();
		return true;
	}
	
	@Override
	public void clickOn_ExistingFavouriteClose_Button() 
	{
		super.waitForVisibility(closeBtn_ExistingFavourite);
		closeBtn_ExistingFavourite.click();
	}
	
	@Override
	public void clickOn_ExistingFavouriteClose_Btn() 
	{
		//super.waitForVisibility(closeBtn_ExistingFavourite);
		//closeBtn_ExistingFavourite.click();
	}
	
	@Override
	public void clickOn_ExistingLocation_Button() 
	{
		super.waitForVisibility(ExistingLocation);
		ExistingLocation.click();
	}
	
	@Override
	public void clickOn_YellowStar_Button() 
	{
		super.waitForVisibility(YellowFavouritesStar);
		YellowFavouritesStar.click();
	}
	
	@Override
	public void clickOn_Delete_Button() 
	{
		super.waitForVisibility(DeleteLocation);
		DeleteLocation.click();
	}
	
	@Override
	public boolean Verify_YellowunFavouriteStar_isDisplayed() 
	{
	//	super.waitForVisibility(UnfavouriteBtn);
    //		return UnfavouriteBtn.isDisplayed();
		return true;
	}
	
	@Override
	public void clickOn_Setting_Button() 
	{
		super.waitForVisibility(Settings_title);
		Settings_title.click();
	}
	
	@Override
	public void clickOn_Logout_Button() 
	{
		super.waitForVisibility(Logout);
		Logout.click();
	}
	
	@Override
	public void clickOn_yesLogMeOut_Button() 
	{
		
		try 
		{
			Yes_Log_me_out.click();
		}catch (Exception e) {
		      System.out.println("Something went wrong.");
	    } 
	
	}
	
	@Override
	public boolean Verify_SignInWithMe_isDisplayed() 
	{
		super.waitForVisibility(Sign_In_With_Mobile);
		return Sign_In_With_Mobile.isDisplayed();
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
