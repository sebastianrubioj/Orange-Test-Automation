Feature: login tests

  Scenario: Success login with valid credentials
    Given user is on login page
    When user provide valid credentials
    And clicks on login button
    Then should be redirected to the homepage