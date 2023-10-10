package mobileAutomation.cucumber.ios.pages;


import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import mobileAutomation.cucumber.common.FavouriteButton;
import mobileAutomation.cucumber.common.iOSBasePage;

public class iOSFavouriteButtonPage extends iOSBasePage implements FavouriteButton {
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='PT stops']")
	private MobileElement PT_stops_button;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='Favourite']")
	private MobileElement Favorite_button;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='Sign In']")
	private MobileElement Sign_In;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='Cancel']")
	private MobileElement Cancel;   
	
	@iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeTextField[`value == 'Mobile Number'`]")
	private MobileElement MobileNumberField;
	
	@iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`label == 'CONTINUE'`]")
	private MobileElement ContinueButton;   
	
	@iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeStaticText[`label CONTAINS 'Verify '`]")
	private MobileElement GetText_MobileNumber;
	
	@iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeTextField[`value == 'SMS verification code'`]")
	private MobileElement SMSVerificationCode;
	
	@iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`label == 'VALIDATE CODE'`]")
	private MobileElement ValidateCode;
	
	@iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeTextField[`value == 'Where to?'`]")
	private MobileElement WhereTo;
	
	@iOSXCUITFindBy(xpath = "(//XCUIElementTypeStaticText[@name='Results']/../XCUIElementTypeButton)[2]")
	private MobileElement Click_firstDisplayResult;
	
	@iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`label == 'close'`][2]")
	private MobileElement Close;
	
	@iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeTextField[`value == 'Name'`]")
	private MobileElement Nickname;
	
	@iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`label == 'ADD TO FAVOURITES'`]")
	private MobileElement AddTofavouriteBtn;  
			
	@iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`label == 'favourited_yellow_ic'`]")
	private MobileElement YellowFavouritesStar;  //2
	
	@iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`label == 'close'`]")
	private MobileElement closeBtn_ExistingFavourite;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeScrollView[2]//XCUIElementTypeButton[1]")
	private MobileElement ExistingLocation;
			
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`label == 'DELETE'`]")
	private MobileElement DeleteLocation;
    		
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`label == 'unfavourite_btn_ic'`]")
	private MobileElement UnfavouriteBtn;
    
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='setting_ic']")
	private MobileElement Settings_title;  

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='LOG OUT']")
 	private MobileElement Logout;  
    
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='Yes, log me out']")
   	private MobileElement Yes_Log_me_out; 	
    
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`label == 'SIGN IN WITH MOBILE'`]")
   	private MobileElement Sign_In_With_Mobile; 
    
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`label == 'Allow While Using App'`]")
   	private MobileElement AllowWhileUsingApp; 
    
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`label == 'CONTINUE AS GUEST'`]")
	private MobileElement Continue_As_a_guest; 
    
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`label == 'SKIP'`]")
	private MobileElement skip; 
    
    
    public iOSFavouriteButtonPage(AppiumDriver<MobileElement> driver) {
		super(driver);

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
   	public void clickOnAllowLocationPopup() throws InterruptedException {

   		try {
   			AllowWhileUsingApp.click();
   			Thread.sleep(5000);
   		} catch (Exception e) {
   		      System.out.println("Pop-Up not display");
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
		
		//super.waitForVisibility(Sign_In);
		//Sign_In.click();
	}
	
	@Override
	public void enter_MobileNumber(String mobilenumber) throws InterruptedException
	{
		super.waitForVisibility(MobileNumberField);
		MobileNumberField.sendKeys(mobilenumber);
	}
	
	@Override
	public void clickOn_Continue_Button() 
	{
		super.waitForVisibility(ContinueButton);
		ContinueButton.click();
	}
	
	@Override
	public String GetText_FromMobileNumberField() 
	{
		super.waitForVisibility(GetText_MobileNumber);
		String DisplayedMobileNumber = GetText_MobileNumber.getText();
		String numberOnly= DisplayedMobileNumber.replaceAll("[^0-9]", "");
		numberOnly = numberOnly.substring(2, 11);
		return numberOnly;
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
		//super.waitForVisibility(WhereTo);
		WhereTo.sendKeys(Address);
		super.waitForVisibility(Click_firstDisplayResult);
		Click_firstDisplayResult.click();
	}
	
	@Override
	public void clickOn_Close_Button() 
	{
		super.waitForVisibility(Close);
		Close.click();
	}
	
	@Override
	public void Enter_Nickname(String nickname) 
	{
		super.waitForVisibility(Nickname);
		Nickname.sendKeys(nickname);
		
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
		super.waitForVisibility(YellowFavouritesStar);
		return YellowFavouritesStar.isDisplayed();
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
		super.waitForVisibility(closeBtn_ExistingFavourite);
		closeBtn_ExistingFavourite.click();
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
		super.waitForVisibility(UnfavouriteBtn);
		return UnfavouriteBtn.isDisplayed();
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
	public void clickOn_BackButton() throws InterruptedException
	{
		Thread.sleep(8000);
	//	driver.pressKeyCode(AndroidKeyCode.BACK);
	//	driver.navigate().back();
    }
	
	@Override
	public void HideKeyboard() throws InterruptedException
	{
		Thread.sleep(3000);
		driver.navigate().back();
    }

	@Override
	public void Click_ContinueAsAGuest() {
		try {
			super.waitForVisibility(Continue_As_a_guest);
			Continue_As_a_guest.click();
		} catch (Exception e) {
	    } 
	}
}
