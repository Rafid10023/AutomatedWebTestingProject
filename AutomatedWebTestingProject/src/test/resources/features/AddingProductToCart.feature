Feature: Add products to cart

  Scenario: User adds a product to the cart
    Given I am on the homepage to buy something
    When I add the Blue Top product to the cart
    Then the product should be added to the cart
    And When I go to the cart I should see the product there

  Scenario: User adds a product to the cart then continues shopping
    Given I am on the homepage to buy something
    When I add the Blue Top product to the cart
    Then the product should be added to the cart with a confirmation
    And I can continue shopping

  Scenario: User adds a product to the cart then verify number of products in cart
    Given I am on the homepage to buy something
    When I add the Blue Top product to the cart and the Men Tshirt
    Then the products should be added to the cart with a confirmation
    And I when i click on the carts the two products should be there


