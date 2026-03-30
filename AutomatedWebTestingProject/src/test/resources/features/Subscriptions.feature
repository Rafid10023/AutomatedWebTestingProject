Feature: Homepage subscription

  Scenario: User subscribes successfully on the homepage
    Given I am on the homepage to find the subscriptions
    When I enter a valid email address
    And I click the subscribe button
    Then I should see a success message confirming my subscription