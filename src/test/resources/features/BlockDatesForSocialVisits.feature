Feature: Block dates for visits
  As a staff user, I want to be able to block or unblock dates for social visits.

  Background:
    Given I log in with "VSIP3_TST" and "Expired19"
    Then Im on "Manage prison visits - Manage prison visits" page
    And I click on Block visit dates option
    Then Im on "Manage prison visits - Block visit dates" page

  Scenario Outline: Block visit dates
    And I enter a "<date>" to block the visit
    And click on continue button
    Then Im on "Manage prison visits - Are you sure you want to block visits on Saturday 25 October 2025?" page
    And I confirm the date to block
    And click on continue button
    Then Im on "Manage prison visits - Block visit dates" page
    And the page has the confirmation message "Visits are blocked for Saturday 25 October 2025."
    And I sign out of the service

    Examples:
      | date       |
      | 25/10/2025 |

  Scenario Outline: Verify error message & unblock an existing blocked visit date
    And I enter a "<date>" to block the visit
    And click on continue button
    Then I get an error message "The date entered is already blocked"
    And I unblock an existing blocked visit date
    Then the page has the confirmation message "Visits are unblocked for Saturday 25 October 2025."
    And I sign out of the service
    Examples:
      | date       |
      | 25/10/2025 |