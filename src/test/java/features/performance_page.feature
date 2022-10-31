Feature: Performance page tests

  Scenario: [My Trackers] Validate performance "my trackers" section
    Given user is on login page
    And user provide valid credentials
    And clicks on login button
    When lands in Performance section
    And goes to My Trackers section
    Then should see "My Performance Trackers" title
    And should see the table tittle with the message "(1) Record Found"
    And should see the table with "Tracker" section
    And should see the table with "Added Date" section
    And should see the table with "Modified Date" section
    And should see the table with "Actions" section

    Scenario: [My Trackers] Validate view button for my trackers
      Given user is on login page
      And user provide valid credentials
      And clicks on login button
      And lands in Performance section
      And goes to My Trackers section
      When clicks on view button
      Then should see the profile picture
      And should see the profile header
      And should see the tracker container with title "Tracker Logs"
      And should see the add log button