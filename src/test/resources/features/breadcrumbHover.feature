Feature: Breadcrumb Hover Show Menu
  @tc4
  Scenario: Verify breadcrumb hover displays menu
    Given I am on the home page
    When I hover over the breadcrumb "Hệ thống truyền động, Khung gầm" displays level 2 menu
    When I hover over level 2 menu "Hệ thống phanh"
    When I click level 3 menu "Phanh sau ô tô"
    Then The page title should contain "Phanh sau ô tô"
