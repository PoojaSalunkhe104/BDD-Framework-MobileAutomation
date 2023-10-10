 Feature: Validate Bike Stops information

@android 
 Scenario Outline:  Verify android app Bike Stop
  Given An anonymous user open the application and go to Bike stop
  When I Enter <Address> in Address field
  Then expect to see Route Button
  And click on Route Button 
  And I Enter <LocationAddress> in Location field
  Then I Verify all bike Stop options present or not
  And I Verify on Train_Icon of Bike stop
  And I Verify on Cycle_Icon of Bike stop
  And I Verify on Bus_Icon of Bike stop
  And I Verify on Walk_Icon of Bike stop
  And I Verify on All_Icon of Bike stop
  
   Examples: 
   |Address                                             |LocationAddress                                                         |
   |426 Graham St, Port Melbourne VIC 3207  |Beacon Cove Pharmacy 3/19 Centre Ave,Port Melbourne VIC  |
  # |Beaconsfield Upper vic 3808, Australia              |Beaconsfield Parade, NorthCote VIC 3070, Australia                      | 
   

@iOS  
 Scenario Outline:  Verify iOS app Bike Stop
  Given An anonymous user open the application and go to Bike stop
  When I Enter <Address> in Address field
  Then expect to see Route Button
  And click on Route Button 
  And I Enter <LocationAddress> in Location field
  Then I Verify all bike Stop options present or not
  And I Verify on Train_Icon of Bike stop
  And I Verify on Cycle_Icon of Bike stop
  And I Verify on Bus_Icon of Bike stop
  And I Verify on Walk_Icon of Bike stop
  And I Verify on All_Icon of Bike stop
  
   Examples: 
   |Address                                             |LocationAddress                                                         |
   |426 Graham St, Port Melbourne VIC 3207  |Beacon Cove Pharmacy 3/19 Centre Ave,Port Melbourne VIC  |
  # |Beaconsfield Upper vic 3808, Australia              |Beaconsfield Parade, NorthCote VIC 3070, Australia                      | 
   