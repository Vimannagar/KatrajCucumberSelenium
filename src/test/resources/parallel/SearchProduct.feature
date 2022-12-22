Feature: search functionality
@smoke
Scenario: search a product
Given user should already be logged in with "8176867662" and "123456"
When user enter the text - "mobile phone" and search
Then mobile phone should get display