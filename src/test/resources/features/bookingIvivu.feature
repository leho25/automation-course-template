Feature: Booking Ivivu Feature
    @tc5
    Scenario: Booking Ivivu Successful
        Given I am on the home page ivivu
        When I select the start date and end date
        And I click search and select the first item
        And I click search button
        And I select hotel from the search results
        Then I see the hotel name