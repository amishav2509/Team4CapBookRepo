Feature: CapBook RegistrationFeature
Using this feature user can create a new capbook account

Scenario: User want to register by entering his credentials
Given User is on CapBook Registration Page
When User submits valid details
Then Register the user

Scenario: User want to signup by entering valid credentials
Given User is on CapBook Registration Page
When User submits invalid details 
Then Ask to fill correct details

