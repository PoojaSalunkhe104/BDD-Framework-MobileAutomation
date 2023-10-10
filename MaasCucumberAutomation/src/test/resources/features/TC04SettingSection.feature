  Feature: Settings Section Test

  @android 
   Scenario Outline: Verify the Android app Setting Section
   Given An user open the app
   When I navigate to <Section> section
   Then I expect to see all settings options
    Examples: 
    |Section           |                                                   
    |Setting           |


 @iOS 
  Scenario Outline: Verify the iOS app Setting Section
    Given An user open the app
    When I navigate to <Section> section
    Then I expect to see all settings options
     Examples: 
    |Section           |                                                   
    |Setting           |
  
  
