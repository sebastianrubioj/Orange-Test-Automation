Feature: login tests

  Scenario: Success login with valid credentials
    Given user is on login page
    When user provide valid credentials
    And clicks on login button
    Then should be redirected to the homepage

  Scenario Outline: Error message login with invalid credentials
    Given user is on login page
    When user set "<username>" and "<password>"
    And clicks on login button
    Then should see the error message for invalid credentials

    Examples:
      | username | password     |
      | Admin    | fakePassword |
      | fakeUser | admin123     |
      | fakeUser | fakePassword |

  Scenario Outline: Error message login with empty credentials
    Given user is on login page
    When user set "<username>" and "<password>"
    And clicks on login button
    Then should see the error message for required credentials

    Examples:
      | username | password |
      | Admin    |          |
      |          | admin123 |
      |          |          |

  Scenario: Reset password page
    Given user is on login page
    When clicks on forgot your password link
    Then should be redirected to the reset password page
    And should see the "username_input" on reset password page
    And should see the "reset_password_button" on reset password page
    And should see the "cancel_button" on reset password page