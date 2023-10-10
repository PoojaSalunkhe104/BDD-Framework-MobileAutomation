package mobileAutomation.cucumber.common;

import io.cucumber.java.Scenario;

public interface VerifyingPTStopsInformationPage {

	boolean PT_stops_buttonDisplayed();

	void searchLocationInTripPlanner(String address) throws InterruptedException;

	void clickOnAllowLocationPopup() throws InterruptedException;

	boolean PT_stops_buttonDisplayed1();

	void clickOnRouteButton();

	void SelectYourLocation(String locationaddress) throws InterruptedException;

	boolean RouteDisplayed();

	boolean DisplayTrainIcon();

	boolean DisplayCycleIcon();


	boolean DisplayWalkIcon();

	boolean DisplayAllIcon();


	boolean DisplayCarIcon();

	void PT_stops_button();


	void verifyTrainIcon(Scenario scenario) throws InterruptedException;

	void verifyCarIcon(Scenario scenario) throws InterruptedException;

	void verifyWalkIcon(Scenario scenario) throws InterruptedException;

	void verifyAllIcon(Scenario scenario) throws InterruptedException;

	void verifyCycleIcon(Scenario scenario) throws InterruptedException;

	void Click_ContinueAsAGuest();

	void Click_OnSkip();

	


}
