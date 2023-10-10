package mobileAutomation.cucumber.common;

import io.cucumber.java.Scenario;

public interface BikeStop_Options 
{

	void ClickOnCarIcon(Scenario scenario) throws InterruptedException;

	void verifyCarIcon(Scenario scenario) throws InterruptedException;

	void ClickOnCycleIcon(Scenario scenario) throws InterruptedException;

	void verifyCycleIcon(Scenario scenario) throws InterruptedException;

	void ClickOnTrainIcon(Scenario scenario) throws InterruptedException;

	void verifyTrainIcon(Scenario scenario) throws InterruptedException;

	void verifyWalkIcon(Scenario scenario) throws InterruptedException;

	void ClickOnWalkIcon(Scenario scenario) throws InterruptedException;

}
