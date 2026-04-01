Feature: Contact Us Form

  In order to contact the company,
  As a user I want to fill out a contact form to then send

  @Happy
  Scenario Outline: Successful sending of contact form
    Given I am on the Contact Us page
    And I have entered the name "<name>"
    And I have entered the email address "<email>"
    And I have entered the subject "<subject>"
    And I have entered the message "<message>"
    When I click the Submit button
    And I click the OK button
    Then I should see the verification message "Success! Your details have been submitter successfully'

    Examples:
      | name     | email            | subject | message                     |
      | John Doe | JohnDoe@test.com | Testing | Testing the contact us form |