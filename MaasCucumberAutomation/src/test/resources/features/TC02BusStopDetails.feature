Feature: Bus Stop Details

  @android 
  Scenario Outline: Verify the Android Bus Stop Details
    Given An anonymous user open app 
	  When navigate to Dashboard page 
	  When I Enter <Address> in Address field
	  Then expect to see Route button
	  And click on Route button
	  And I Enter <LocationAddress> in Location field
	  Then I Select particular public transport journey
	  And I expect to verify generated journey
	
	  Examples: 
	    |Address                                             |LocationAddress                                                        |
	    |426 Graham St, Port Melbourne VIC 3207             |Beacon Cove Pharmacy 3/19 Centre Ave                                    |
	  


  @iOS 
  Scenario Outline: Verify the iOS Bus Stop Details
	  Given An anonymous user open app 
	  When navigate to Dashboard page 
	  When I Enter <Address> in Address field
	  Then expect to see Route button
	  And click on Route button
	  And I Enter <LocationAddress> in Location field
	  Then I Select particular public transport journey
	  And I expect to verify generated journey
	
	  Examples: 
	    |Address                                             |LocationAddress                                                        |
	    |426 Graham St, Port Melbourne VIC 3207             |Beacon Cove Pharmacy 3/19 Centre Ave                                    |
	  
	  