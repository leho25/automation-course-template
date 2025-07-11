Feature: Login Feature
    In order to access the application
    As a user
    I want to log In

  @smoke @tc1
  Scenario: Successful Login
    Given I am on the login page
    When I enter valid credentials
    Then I should be redirected to the dashboard

  @smoke @tc2
  Scenario Outline: Verify login
    Given I am on the login page
    When I enter username "<username>" and password "<password>"
    Then I should see "<message>"

    Examples:
      | username | password    | message      |
      | admin    | admin       |              |
      | admin    | admin123    | Login failed |
      | user1    | demouserpwd |              |
      | user2    | demouserpwd |              |
