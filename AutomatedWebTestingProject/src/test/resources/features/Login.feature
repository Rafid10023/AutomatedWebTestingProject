Feature: Login functionality

  As a shmuck user of this website
  I want to be able to login

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