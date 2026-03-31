Feature: Homepage subscription

  Scenario: User subscribes successfully on the homepage
    Given I am on the homepage to find the subscriptions
    When I enter a valid email address
    And I click the subscribe button
    Then I should see a success message confirming my subscription

  Scenario: User subscribes successfully on the cart page
    Given I am on the cart page to find the subscriptions
    When I enter a valid email address on the cart page
    And I click the subscribe button on the cart page
    Then I should see a success message confirming my subscription on the cart page