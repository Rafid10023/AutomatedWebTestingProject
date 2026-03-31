Feature: User Account Management

  As a customer
  I want to manage my account
  So that I can use the website securely


  @Happy
  Scenario Outline: Successful login with valid credentials
    Given I am on the login page
    When I enter the email address "<email>"
    And I enter the password "<password>"
    And I click the login button
    Then I should see the logout button

    Examples:
      | email                   | password         |
      | Rafiduddin18@gmail.com  | zxcvasdf123 |

  @Sad
  Scenario: Unsuccessful login with invalid credentials
    Given I am on the login page to put in wrong password
    When I enter an invalid email and password
    And I click the login button with wrong password
    Then I should see a login error message


  Scenario: Successful logout
    Given I am logged in
    When I click the logout button
    Then I should be logged out