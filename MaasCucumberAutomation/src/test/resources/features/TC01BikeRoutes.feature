Feature: Bike routes Polyline Test

 @android
 Scenario Outline:  Verify the Android Bike route polyline
	  Given An anonymous user navigate to Bike routes
	  When I click on Where to
	  When I Enter <Address> in Address field
	  Then I expect to see Route button
	  Then I click on Route button
	  And I Enter <LocationAddress> in Location field
	  Then I expect to see Bike routes details
	  Then I click on particular Bike route
	  Then I expect to see Go button and route
	  
	  Examples: 
	    |Address                                             |LocationAddress                                                        |
	    |426 Graham St, Port Melbourne VIC 3207             |Beacon Cove Pharmacy 3/19 Centre Ave                                    |
	  
  @iOS 
  Scenario Outline: Verify the iOS Bike route polyline
	  Given An anonymous user navigate to Bike routes
	  When I click on Where to
	  When I Enter <Address> in Address field
	  Then I expect to see Route button
	  Then I click on Route button
	  And I Enter <LocationAddress> in Location field
	  Then I expect to see Bike routes details
	  Then I click on particular Bike route
	  Then I expect to see Go button and route
	  
	  Examples: 
	    |Address                                             |LocationAddress                                                        |
	    |426 Graham St, Port Melbourne VIC 3207             |Beacon Cove Pharmacy 3/19 Centre Ave                                    |
	  
  