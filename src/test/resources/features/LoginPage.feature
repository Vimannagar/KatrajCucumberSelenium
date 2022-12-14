Feature: Login Page
Scenario: title verification
Given user is on landing page
When user gets the title of page
Then page title should be "Amazon shopping site in India"


Scenario: Orders section display verification
Given user is on landing page
Then orders section should get display 


Scenario: Login with correct credentials
