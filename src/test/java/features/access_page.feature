Feature: Admin settings access tests

  Scenario: Validate Administrator access page
    Given user is on login page
    And user provide valid credentials
    And clicks on login button
    When goes to the Maintenance section
    And lands in Admin Access page
    Then should see the title "Administrator Access"
    And should see the description message
    And should see the username section disabled
    And I should see the username contains by default "Admin" value
    And should see the password section enabled

  Scenario: Validate error message for wrong password
    Given user is on login page
    And user provide valid credentials
    And clicks on login button
    When goes to the Maintenance section
    And set a "fake_password" password
    And clicks on Confirm button
    Then should see the error message for invalid credentials

  Scenario: Validate cancel button
    Given user is on login page
    And user provide valid credentials
    And clicks on login button
    And goes to the Maintenance section
    When clicks on cancel button
    Then should be redirected to the homepage


  Scenario: Validate link to Orange web page
    Given user is on login page
    And user provide valid credentials
    And clicks on login button
    And goes to the Maintenance section
    When clicks on Orange page link
    Then should be redirected to the Orange web page