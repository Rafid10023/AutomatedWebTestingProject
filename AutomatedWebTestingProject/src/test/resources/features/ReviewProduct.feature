Feature: Review a product

  In order to review a product
  As a user I want to fill out a review product form to then submit

  @Happy
  Scenario Outline:
    Given I am on a product page
    And I have entered a name "<name>"
    And I have entered an email address "<email>"
    And I have entered the review "<review>"
    When I click the Submit Review button
    Then I should see the verification message

    Examples:
      | name  | email | review |
      | John Doe | JohnDoe@test.com | I like this product! |

