 Feature: Validate PT Stop route for walk option

@android
 Scenario Outline:  Verify android app PT Stop route for walk option
  Given An anonymous user open the application 
  When I Enter <Address> in Address field
  Then expect to see Route Button
  And click on Route Button 
  And I Enter <LocationAddress> in Location field
  Then I Verify all PT Stop options present or not
  And I click on walk option
  And I verify walk routes
  
   Examples: 
    |Address                                              |LocationAddress                                                         |
    |426 Graham St,Port Melbourne                         |Beacon Cove Pharmacy 3/19                                               |                                                     
  
  
 @iOS  
 Scenario Outline:  Verify iOS app PT Stop route for walk option
  Given An anonymous user open the application 
  When I Enter <Address> in Address field
  Then expect to see Route Button
  And click on Route Button 
  And I Enter <LocationAddress> in Location field
  Then I Verify all PT Stop options present or not
  And I click on walk option
  And I verify walk routes
  
   Examples: 
    |Address                                              |LocationAddress                                                         |
    |426 Graham St,Port Melbourne                         |Beacon Cove Pharmacy 3/19                                               |                                                     
  # |426 Graham St, Port Melbourne VIC 3207, Australia    |Beacon Cove Pharmacy 3/19 Centre Ave,Port Melbourne VIC 3207, Australia |
  # |Beaconsfield Upper vic                               |Beaconsfield Parade                                                     |
