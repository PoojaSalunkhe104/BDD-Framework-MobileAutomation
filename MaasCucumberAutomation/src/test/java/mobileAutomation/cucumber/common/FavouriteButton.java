package mobileAutomation.cucumber.common;

public interface FavouriteButton {


	boolean PT_stops_buttonDisplayed();

	void clickOn_Favourite_Button();

	void clickOn_SignIn_Button();

	void enter_MobileNumber(String mobilenumber) throws InterruptedException ;

	void clickOn_Continue_Button();

	String GetText_FromMobileNumberField();

	void Enter_SMSVerificationCode(String otp);

	void clickOn_ValidateCode_Button();

	void Enter_Address(String Address);

	void clickOn_Close_Button();

	void Enter_Nickname(String nickname);

	void clickOn_AddFavourite_Button();

	void clickOn_ExistingFavouriteClose_Button();

	void clickOn_ExistingLocation_Button();

	boolean Verify_YellowFavouriteStar_isDisplayed();

	void clickOn_YellowStar_Button();

	void clickOn_Delete_Button();

	boolean Verify_YellowunFavouriteStar_isDisplayed();

	void clickOn_Setting_Button();

	void clickOn_Logout_Button();

	void clickOn_yesLogMeOut_Button();

	boolean Verify_SignInWithMe_isDisplayed();

	void clickOn_BackButton() throws InterruptedException;

	void HideKeyboard() throws InterruptedException;

	void clickOn_ExistingFavouriteClose_Btn();

	void clickOnAllowLocationPopup() throws InterruptedException;

	void Click_ContinueAsAGuest();

	void Click_OnSkip();

}
