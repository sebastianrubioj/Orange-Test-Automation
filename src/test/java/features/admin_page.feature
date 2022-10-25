Feature: Admin page tests

  Scenario Outline: [User Management] Search system users by user role
    Given user is on login page
    And user provide valid credentials
    And clicks on login button
    And lands in admin section
    When selects "<user_role>" user role
    And clicks on search button
    Then should see a list of system users with "<user_role>" user role

    Examples:
      | user_role |
      | Admin     |
      | ESS       |

  Scenario Outline: [User Management] Search system users by status
    Given user is on login page
    And user provide valid credentials
    And clicks on login button
    And lands in admin section
    When selects "<status>" status
    And clicks on search button
    Then should see a list of system users with "<status>" status

    Examples:
      | status   |
      | Enabled  |
      | Disabled |

  Scenario Outline: [User Management] Search system users by user role and status
    Given user is on login page
    And user provide valid credentials
    And clicks on login button
    And lands in admin section
    When selects "<user_role>" user role
    And selects "<status>" status
    And clicks on search button
    Then should see a list of system users with "<user_role>" user role
    And should see a list of system users with "<status>" status

    Examples:
      | user_role | status   |
      | Admin     | Enabled  |
      | ESS       | Enabled  |
      | Admin     | Disabled |
      | ESS       | Disabled |

    Scenario: [User Management] Search for an existing User by user name
    Scenario: [User Management] Search for an existing User by employee name
    Scenario: [User Management] Search for a non existing User by user name
    Scenario: [User Management] Search for a non existing User by employee name