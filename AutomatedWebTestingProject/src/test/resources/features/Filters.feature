Feature: Filter products

  Scenario: User filters products by category
    Given I am on the homepage to find filters by category
    When I expand the woman category
    And I select a category option
    Then I should see only products related to that category

#  Scenario: User filters products by brand
#    Given I am on the homepage to find filters by brand
#    When I select the "Polo" brand
#    Then I should see only products from the "Polo" brand