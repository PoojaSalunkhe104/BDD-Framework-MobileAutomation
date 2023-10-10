package mobileAutomation.cucumber.common;

public interface PublicTransportPage {

	void searchLocationInTripPlanner(String location);

	boolean RouteDisplayed();

	void clickOnRouteButton();

	void SelectPublicTransportRoute();

	void verifySearchedLocation(String location);

	boolean PT_stops_buttonDisplayed();

	void SelectYourLocation(String location);

	String getArrivalTime();

	String getFirstStopName();

	void clickOnAllowLocationPopup() throws InterruptedException;

	void Click_ContinueAsAGuest();

	void Click_OnSkip();

}
