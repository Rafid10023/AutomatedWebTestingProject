Feature: User Account Management

  As a customer
  I want to manage my account
  So that I can use the website securely

Scenario: Successful user registration
Given I am on the login page
When I enter valid registration details
And It takes me to the registration page
And I fill in all details
And I click create account
Then I should be logged in

Scenario: Register with existing email
    Given I am on the login page
    And I already have an account
    When I enter an existing email
    Then I should see an email already exists error