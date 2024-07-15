Feature: Session template based tests
  As a user, I should be able to view the Prison sessions based on session restrictions within the Prison establishments
# All the Test Data is pre-set in Admin service & via NOMIS ensure the Test Data is up-to-date with regards to session restrictions(in Admin service) within each establishment. All the tests are using Drake hall & Bristol establishments.

  @suite
  Scenario Outline: Open session - User able to book an Open session for all Prisoners within the establishment
    Given I log in with "<userName>" and "<password>"
    Then Im on "Manage prison visits - Manage prison visits" page
    And I select change establishment
    And I change the establishment to Bristol
    And click on continue button
    And I click on Book a visit option
    And Im on "Manage prison visits - Search for a prisoner" page
    When I enter "<prisonNumber>" to search for a prison
    And click on search button
    Then I choose prisoner from search results
    Then Im on "Manage prison visits - Vsip_prisoner12, Do Not Use" page
    And I click on Book a visit button
    Then Im on "Manage prison visits - Select visitors from the prisoner’s approved visitor list" page
    And I select a new visitor form the list from Bristol establishment
    And click on continue button
    Then Im on "Manage prison visits - Select date and time of visit" page
    And I check only Open time slots is available
    And I sign out of the service

    Examples:
      | userName  | password          | prisonNumber |
      | VSIP4_TST | DigitalServices12 | A8897DZ      |

  @suite
  Scenario Outline: Closed session - User able to book a Closed session for all Prisoners within the establishment
    Given I log in with "<userName>" and "<password>"
    Then Im on "Manage prison visits - Manage prison visits" page
    And I select change establishment
    And I change the establishment to Drake Hall
    And click on continue button
    And I click on Book a visit option
    And Im on "Manage prison visits - Search for a prisoner" page
    When I enter "<prisonNumber>" to search for a prison
    And click on search button
    Then I choose prisoner from search results
    Then Im on "Manage prison visits - Vsip_prisoner11, Do Not Use" page
    And I click on Book a visit button
    Then Im on "Manage prison visits - Select visitors from the prisoner’s approved visitor list" page
    And I select a visitor form the list from Drake hall establishment
    And click on continue button
    Then Im on "Manage prison visits - Check the prisoner&#39;s closed visit restrictions" page
    And I choose closed type visit
    And click on continue button
    Then Im on "Manage prison visits - Select date and time of visit" page
    #Closed type is displayed
    And I check "Closed" visit type is displayed
    And I check only closed time slots is available
    And I check open timeslots not available
    And I sign out of the service

    Examples:
      | userName  | password          | prisonNumber |
      | VSIP4_TST | DigitalServices12 | A8899DZ      |
