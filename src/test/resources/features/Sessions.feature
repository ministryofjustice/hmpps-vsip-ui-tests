Feature: Session template based tests
  As a user, I should be able to view the Prison sessions based on session restrictions within the Prison establishments
# All the Test Data is pre-set in Admin service & via NOMIS ensure the Test Data is up-to-date with regards to session restrictions(in Admin service) within each establishment. All the tests are using Drake hall & Bristol establishments.

  @suite
  Scenario Outline: Open session - User able to book an Open session for all Prisoners within the establishment
    Given I log in with "<userName>" and "<password>"
    Then Im on "Manage prison visits - DPS" page
    And I select change establishment
    And I change the establishment to "Bristol (HMP)"
#    And I change the establishment to Bristol
#    And click on continue button
    And I click on Book a visit option
    And Im on "Search for a prisoner - Manage prison visits - DPS" page
    When I enter "<prisonNumber>" to search for a prison
    And click on search button
    Then I choose prisoner from search results
    Then Im on "Vsip_prisoner12, Do Not Use - Manage prison visits - DPS" page
    And I click on Book a visit button
    Then Im on "Select visitors - Manage prison visits - DPS" page
    And I select a new visitor form the list from Bristol establishment
    And click on continue button
    Then Im on "Select date and time of visit - Manage prison visits - DPS" page
    And I check only Open time slots is available
    And I sign out of the service

    Examples:
      | userName  | password            | prisonNumber |
      | VSIP4_TST | DigitalServices2025 | A8897DZ      |

  @suite
  Scenario Outline: Closed session - User able to book a Closed session for all Prisoners within the establishment
    Given I log in with "<userName>" and "<password>"
    Then Im on "Manage prison visits - DPS" page
    And I select change establishment
    And I change the establishment to "Drake Hall (HMP & YOI)"
#    And click on continue button
    And I click on Book a visit option
    And Im on "Search for a prisoner - Manage prison visits - DPS" page
    When I enter "<prisonNumber>" to search for a prison
    And click on search button
    Then I choose prisoner from search results
    Then Im on "Vsip_prisoner11, Do Not Use - Manage prison visits - DPS" page
    And I click on Book a visit button
    Then Im on "Select visitors - Manage prison visits - DPS" page
    And I select a visitor form the list from Drake hall establishment
    And click on continue button
    Then Im on "Check the prisoner's closed visit restrictions - Manage prison visits - DPS" page
    And I choose closed type visit
    And click on continue button
    Then Im on "Select date and time of visit - Manage prison visits - DPS" page
    #Closed type is displayed
    And I check "Closed" visit type is displayed
    And I check only closed time slots is available
    And I check open timeslots not available
    And I sign out of the service

    Examples:
      | userName  | password            | prisonNumber |
      | VSIP4_TST | DigitalServices2025 | A8899DZ      |
