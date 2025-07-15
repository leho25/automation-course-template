Feature: Shopping Cart Feature

  @smoke @tc3
  Scenario: Shopping Cart Successful
    Given I am on the page login
    When I enter valid credential
    And I search for product "merc"
    And I select the first product from the search results
    And I select proudct option "England"
    And I add the proudct to the cart
    Then The cart should display a message
