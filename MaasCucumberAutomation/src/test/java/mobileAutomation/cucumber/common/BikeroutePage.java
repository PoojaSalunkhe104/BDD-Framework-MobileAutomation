package mobileAutomation.cucumber.common;
public interface BikeroutePage {
	
	boolean Setting_buttonDisplayed();
	
	boolean PT_stops_buttonDisplayed();
	void ClickOn_Bike_routes_button();
	boolean ParkingDisplayed();
	boolean Re_position_map_to_your_locationDisplayed();
	void clickOnSearchDisplayed();
	
	void SelectYourLocation();
	boolean RouteDisplayed();
	void clickOnRouteButton();
	boolean containerFiltersIsDisplayed();
	
	void SelectBikeRoute();
	
	boolean GoButtonIsDisplayed();
	boolean routeIsDisplayed();
	
	boolean StartonIsDisplayed();
	
	boolean ArriveIsDisplayed();
	
	void clickOnDeviceBackButton();

	void clickOnAllowLocationPopup() throws InterruptedException;

	void Click_ContinueAsAGuest();

	void Click_OnSkip();
}







