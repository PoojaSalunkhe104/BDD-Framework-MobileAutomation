Feature: Validate Favourite button

 @android  
 Scenario Outline:  Verify the Android Favourite button
  Given An user open an app
  When I click on Favourite
  Then I click on  Sign In
  Then I enter <Mobile_Number>
  Then I click on continue button and I expect displaying mobile number should be match with <Mobile_Number>
  Then I Entered <OTP>
  Then I click on validate Code
  Then I Enter <Address> in address field
  Then I Enter <NickName> in name filed
  Then I click on AddToFavourite Button
  Then I open Existing Favourite Location <Address>
  Then I delete Favorite Location
  Then I expect remove location from favourite Button
  Then I LogOut from app
  
  
  Examples: 
   |Mobile_Number|OTP   |Address           | NickName        |
   |512345679    |000000|Melbourne Airport |Melbourne Airport|
   
 
  
  
 @iOS  
 Scenario Outline:  Verify the iOS Favourite button
  Given An user open an app
  When I click on Favourite
  Then I click on  Sign In
  Then I enter <Mobile_Number>
  Then I click on continue button and I expect displaying mobile number should be match with <Mobile_Number>
  Then I Entered <OTP>
  Then I click on validate Code
  Then I Enter <Address> in address field
  Then I Enter <NickName> in name filed
  Then I click on AddToFavourite Button
  Then I open Existing Favourite Location <Address>
  Then I delete Favorite Location
  Then I expect remove location from favourite Button
  Then I LogOut from app
  
  Examples: 
   |Mobile_Number|OTP    |Address             |NickName         |
   |512345679    |000000 |Melbourne Airport   |Melbourne Airport|
 #  |512345679    |000000 |Magnetic Island     |Island           |