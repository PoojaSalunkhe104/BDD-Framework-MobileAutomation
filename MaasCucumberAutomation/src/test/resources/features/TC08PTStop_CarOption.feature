Feature: Validate PT Stop route for Car option

@android
 Scenario Outline:  Verify android app PT Stop route for Car option
  Given An anonymous user open the application 
  When I Enter <Address> in Address field
  Then expect to see Route Button
  And click on Route Button 
  And I Enter <LocationAddress> in Location field
  Then I Verify all PT Stop options present or not
  And I click on car option
  And I verify car routes
  
   Examples: 
   |Address                                             |LocationAddress                                                         |       
   |426 Graham St,Port Melbourne                         |Beacon Cove Pharmacy 3/19                                               |                                                     
  

@iOS  
 Scenario Outline:  Verify iOS app PT Stop route for Car option
  Given An anonymous user open the application 
  When I Enter <Address> in Address field
  Then expect to see Route Button
  And click on Route Button 
  And I Enter <LocationAddress> in Location field
  Then I Verify all PT Stop options present or not
  And I click on car option
  And I verify car routes
  
   Examples: 
   |Address                                             |LocationAddress                                                         |       
    |426 Graham St,Port Melbourne                         |Beacon Cove Pharmacy 3/19                                               |                                                     
  #|426 Graham St, Port Melbourne VIC 3207, Australia   |Beacon Cove Pharmacy 3/19 Centre Ave,Port Melbourne VIC 3207, Australia |
  #|Beaconsfield Upper vic 3808, Australia              |Beaconsfield Parade, NorthCote VIC 3070, Australia                      |