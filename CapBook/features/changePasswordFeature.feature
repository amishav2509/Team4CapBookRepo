Feature: CapBook Change Password Feature
Using this feture user can be able to change password in capbook

Scenario: User want to change password using valid set of credentials
Given User is in capbook change password page
When  User enters valid crdentials
Then user should be able to change password

Scenario: User tries to change password using invalid set of credentials
Given User is in capbook change password page
When   User enters invalid crdentials
Then user should be asked to try again
