Feature: Validate Bike Stop route for Walk option

@android  @lastTest
Scenario Outline:  Verify android app Bike Stop for walk option
  Given An anonymous user open the application and go to Bike stop
  When I Enter <Address> in Address field
  Then expect to see Route Button
  And click on Route Button 
  And I Enter <LocationAddress> in Location field
  Then I Verify all bike Stop options present or not
  And I click on a walk option
  And I verify a walk routes
  
   Examples: 
   |Address                                             |LocationAddress                                                         |
   |426 Graham St, Port Melbourne VIC                   |Beacon Cove Pharmacy 3/19 Centre Ave                                    |

@iOS  @lastTest
 Scenario Outline:  Verify iOS app Bike Stop for walk option
  Given An anonymous user open the application and go to Bike stop
  When I Enter <Address> in Address field
  Then expect to see Route Button
  And click on Route Button 
  And I Enter <LocationAddress> in Location field
  Then I Verify all bike Stop options present or not
  And I click on a walk option
  And I verify a walk routes
  
   Examples: 
   |Address                                             |LocationAddress                                                         |
  #|426 Graham St, Port Melbourne VIC 3207, Australia   |Beacon Cove Pharmacy 3/19 Centre Ave,Port Melbourne VIC 3207, Australia |
   |426 Graham St, Port Melbourne VIC                   |Beacon Cove Pharmacy 3/19 Centre Ave                                    |