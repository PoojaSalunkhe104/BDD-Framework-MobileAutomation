package mobileAutomation.cucumber.ios.pages;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.exec.util.StringUtils;

public class Sample {

	public static void main(String[] args) {
		String requiredTimeForCycles = "11:13AM - 11:20AM";
	/*	String requiredTimeForCycle = requiredTimeForCycles.replaceAll("\\s", ""); //
		if(requiredTimeForCycle.contains("hrs"))
		{
			requiredTimeForCycle = requiredTimeForCycle.replaceAll("hrs", "hrs ");
		}
		System.out.println("# Required Time For Cycle before Click on Item: "+requiredTimeForCycle);  */
		
		String[] parts = requiredTimeForCycles.split("-");
		String ArriveBy = parts[1].trim();
		System.out.println("Arrival time before Click on Item: "+ArriveBy);
				
	}

}
