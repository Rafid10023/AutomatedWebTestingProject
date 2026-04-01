Feature: Scroll Up Feature

  In order to return to the top of the page
  As a user I want to click on a button to automatically scroll up

  @Happy
  Scenario: Successful in scrolling to the top of page
    Given I am on the homepage
    And I scroll to the bottom of the page
    When I click on the arrow button on the bottom right
    Then I the page will scroll automatically to the top