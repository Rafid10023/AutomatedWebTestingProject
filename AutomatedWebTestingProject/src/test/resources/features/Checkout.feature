Feature: Place an order

  As a user I want to place an order and checkout

  @Happy
  Scenario: Successful Checkout
    Given I am logged in as a customer
    And I have added a product to the cart
    And I click on the cart button
    And I click proceed to checkout
    And I click Place Order
    And I enter Name on Card
    And I enter Card Number
    And I enter CVC
    And I enter Expiration date
    And I enter Year
    When I click Pay and Confirm Order button
    Then I should see the verification message for an order being placed
