package mobileAutomation.cucumber.common;

import io.cucumber.java.Scenario;

public interface VerifyingBikeStopsInformationPage {

	boolean PT_stops_buttonDisplayed();

	void clickOnAllowLocationPopup() throws InterruptedException;

	boolean DisplayTrainIcon();

	boolean DisplayCycleIcon();

	boolean DisplayCarIcon();

	boolean DisplayWalkIcon();

	boolean DisplayAllIcon();

	void verifyTrainIcon(Scenario scenario) throws InterruptedException;

	void verifyCycleIcon(Scenario scenario) throws InterruptedException;

	void verifyCarIcon(Scenario scenario) throws InterruptedException;

	void verifyWalkIcon(Scenario scenario) throws InterruptedException;

	void verifyAllIcon(Scenario scenario) throws InterruptedException;

	void Click_ContinueAsAGuest();

	void Click_OnSkip();

}
