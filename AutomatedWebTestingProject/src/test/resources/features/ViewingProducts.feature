Feature: View Product Details

  As a user
  I want to view detailed information about a product
  So that I can decide whether to purchase it

  Scenario: User views the details of the Blue Top product
    Given I am on the homepage
    When I click on a product
    Then I should be redirected to the product details page
    And I should be able to see the Availability