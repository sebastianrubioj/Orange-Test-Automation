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

  Scenario Outline: [User Management] Search for an existing User by user name
    Given user is on login page
    And user provide valid credentials
    And clicks on login button
    And lands in admin section
    When type the system user name "<username>"
    And clicks on search button
    Then should see the records table with "<username>" username only
    And should see the records table with "<user_role>"
    And should see the records table with "<employee_name>"
    And should see the records table with "<status>"

    Examples:
      | username      | user_role | employee_name | status  |
      | Aaliyah.Haq   | ESS       | Aaliyah Haq   | Enabled |
      | Dominic.Chase | Admin     | Dominic Chase | Enabled |

  Scenario Outline: [User Management] Search for an existing User by employee name
    Given user is on login page
    And user provide valid credentials
    And clicks on login button
    And lands in admin section
    When type the system employee name "<employee_name>"
    And clicks on search button
    Then should see the records table with "<employee_name>" employee name only
    And should see the records table with "<user_role>"
    And should see the records table with "<username>"
    And should see the records table with "<status>"

    Examples:
      | username      | user_role | employee_name | status  |
      | Aaliyah.Haq   | ESS       | Aaliyah Haq   | Enabled |
      | Dominic.Chase | Admin     | Dominic Chase | Enabled |

  Scenario: [User Management] Search for a non existing User by user name
    Given user is on login page
    And user provide valid credentials
    And clicks on login button
    And lands in admin section
    When type the system user name "fake username"
    And clicks on search button
    Then should see the notification info with message "No Records Found"
    And should not see any result in the records table


  Scenario: [User Management] Search for a non existing User by employee name
    Given user is on login page
    And user provide valid credentials
    And clicks on login button
    And lands in admin section
    When type the system employee name "fake employee"
    And clicks on search button
    Then should see the notification info with message "No Records Found"
    And should not see any result in the records table

  Scenario: [Job Titles] Validate job titles section
    Given user is on login page
    And user provide valid credentials
    And clicks on login button
    And lands in admin section
    When goes to Job Titles section
    Then should see "Job Titles" title
    And should see an Add button
    And should see the records tittle
    And should see the table with "Job Titles" section
    And should see the table with "Job Description" section
    And should see the table with "Actions" section

  Scenario: [Job Titles] Validate job titles select all
    Given user is on login page
    And user provide valid credentials
    And clicks on login button
    And lands in admin section
    And goes to Job Titles section
    When verifies the total amount of records
    And selects the checkbox for all results
    Then should see all the records selected
    And should appear the Delete Selected option button
    And should see the table tittle with the message "Records Selected"
    And should see the table tittle with the total amount of records verified previously

    Scenario: [Job Titles] Validate job titles single selection
      Given user is on login page
      And user provide valid credentials
      And clicks on login button
      And lands in admin section
      And goes to Job Titles section
      When selects one checkbox result
      Then should appear just one checkbox selected
      And should appear the Delete Selected option button
      And should see the table tittle with the message "(1) Record Selected"
