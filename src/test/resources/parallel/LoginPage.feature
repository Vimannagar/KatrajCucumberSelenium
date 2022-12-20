Feature: Login Page
Scenario: title verification
Given user is on landing page
When user gets the title of page
Then page title should be "Amazon shopping site in India"


Scenario: Orders section display verification
Given user is on landing page
Then orders section should get display 


Scenario: Login with correct credentials
Given user is on landing page
When user enters the username "8176867662"
And user enters the password "123456"
And user click on login button


