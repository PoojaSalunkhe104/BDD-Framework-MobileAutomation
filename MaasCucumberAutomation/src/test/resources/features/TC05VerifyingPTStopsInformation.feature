 Feature: Validate PT Stops information
 
 
 @android  
 Scenario Outline:  Verify android app PT Stop
  Given An anonymous user open the application 
  When I Enter <Address> in Address field
  Then expect to see Route Button
  And click on Route Button 
  And I Enter <LocationAddress> in Location field
  Then I Verify all PT Stop options present or not
  And I Verify on Train_Icon
  And I Verify on Cycle_Icon
  And I Verify on Bus_Icon
  And I Verify on Walk_Icon
  And I Verify on All_Icon
  
   Examples: 
   |Address                                             |LocationAddress                                                         |
   |426 Graham St, Port Melbourne VIC 3207, Australia   |Beacon Cove Pharmacy 3/19 Centre Ave,Port Melbourne VIC 3207, Australia |
   
   
   
 @iOS  
 Scenario Outline:  Verify iOS app PT Stop
  Given An anonymous user open the application 
  When I Enter <Address> in Address field
  Then expect to see Route Button
  And click on Route Button 
  And I Enter <LocationAddress> in Location field
  Then I Verify all PT Stop options present or not
  And I Verify on Train_Icon
  And I Verify on Cycle_Icon
  And I Verify on Bus_Icon
  And I Verify on Walk_Icon
  And I Verify on All_Icon
  
   Examples: 
   |Address                                             |LocationAddress                                                         |
   |426 Graham St, Port Melbourne VIC 3207, Australia   |Beacon Cove Pharmacy 3/19 Centre Ave,Port Melbourne VIC 3207, Australia |
  # |Beaconsfield Upper vic 3808, Australia              |Beaconsfield Parade, NorthCote VIC 3070, Australia                      | 
   
