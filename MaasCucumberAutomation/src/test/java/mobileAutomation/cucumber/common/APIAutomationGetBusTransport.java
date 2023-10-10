package mobileAutomation.cucumber.common;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.TimeZone;
import com.google.gson.Gson;
import io.restassured.RestAssured;

public class APIAutomationGetBusTransport
{

	public static String automateBusJourneyAPI() {
		RestAssured.baseURI = "https://e-arevo-api-sandbox-ia.au-s1.cloudhub.io/api/journeys";
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		String recordedTimeStamp = df.format(new Date()) + "T12:00:00+11:00";
		String currentDateTime = df.format(new Date()) + "T12:00:00%2b11:00";
		String Response = RestAssured.given().param("from", "-37.83648808928422,144.91998191574137")
				.param("to", "-37.83474671686244,144.93430437336806").param("departBy", currentDateTime)
				.param("optimise", "time").param("transportTypes", "bus").header("recordedTimeStamp", recordedTimeStamp)
				.header("deviceId", "integration_testing-----------").header("sessionId", "a1b2-c3d4-e5f6-g7h8-i9j0")
				.header("client_id", "da05f3e4dd714c95bb414fb8980fb4b4")
				.header("client_secret", "11827910410947Cbbd6e7d81E7eDD4f6").get().asString();
		System.out.println(Response);
		return Response;

	}

	public static String getArrivalTime() throws ParseException {
		String Response = automateBusJourneyAPI();
		Root data = new Gson().fromJson(Response, Root.class);
		// System.out.println(data.journeys.get(0).arrivalTime);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
		sdf.setTimeZone(TimeZone.getTimeZone("AEST"));
		SimpleDateFormat sdfTime = new SimpleDateFormat("h:mm aa");
		sdfTime.setTimeZone(java.util.TimeZone.getTimeZone("IST"));
		String dateStr = (sdfTime.format(data.journeys.get(0).arrivalTime)).replace("AM", "am").replace("PM", "pm");
		System.out.println(dateStr);
		return dateStr;
	}
	public static String getSteps() {
		String Response = automateBusJourneyAPI();
		Root data = new Gson().fromJson(Response, Root.class);
		String name1=data.journeys.get(0).legs.get(1).steps.get(0).name;
		String name2=data.journeys.get(0).legs.get(1).steps.get(1).name;
		String name3=data.journeys.get(0).legs.get(1).steps.get(2).name;
		String name4=data.journeys.get(0).legs.get(1).steps.get(3).name;
		String name5=data.journeys.get(0).legs.get(1).steps.get(4).name;
		return name1;
		}
	
	 class Journey{
		   // public int orderIndex;
		    //public String routeId;
		  //  public String transportType;
		   // public Date departureTime;
		    public Date arrivalTime;
		    //public int durationSec;
		    //public int distanceMeters;
		    public ArrayList<Leg> legs;
		}
		 class Leg{
		   // public String type;
		   // public Date departureTime;
		    //public Date arrivalTime;
		    public ArrayList<Step> steps;
		    
		}
		 
		 class Root{
		    public ArrayList<Journey> journeys;
		}
		 class Step{
		    public String name;
		    //public double mylong;
		   // public double lat;
		}

}
