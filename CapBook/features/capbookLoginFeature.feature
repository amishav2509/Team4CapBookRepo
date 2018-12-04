Feature: CapBook Login Feature
Using this feture user can be able to login in capbook

Scenario: User want to login in Capbook using valid set of credentials
Given User is in capbook login page
When  User enters correct emailId and User enters correct  password
Then user should be able to login in capbook acount

Scenario: User tries to login in CapBook using invalid set of credentials
Given User is in capbook login page
When  User enters incorrect emailId or password
Then user should be asked to login again
