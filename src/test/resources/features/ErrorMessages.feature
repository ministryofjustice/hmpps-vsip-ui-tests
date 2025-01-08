Feature: Book a Visit Error messages
  As a user, I should be able to direct to enter correct details to Book a visit using VSIP service
#Error message Scenarios
  @suite
  Scenario Outline: Error message on search page
    Given I log in with "<userName>" and "<password>"
    Then Im on "Manage prison visits - DPS" page
    And I click on Book a visit option
    And Im on "Search for a prisoner - Manage prison visits - DPS" page
    And click on search button
    Then I see "You must enter at least 2 characters" on search page
    And I sign out of the service

    Examples:
      | userName  | password               |
      | VSIP5_TST | MojDigitalServices2025 |

  @suite
  Scenario Outline: Error message on search page
    Given I log in with "<userName>" and "<password>"
    Then Im on "Manage prison visits - DPS" page
    And I click on Book a visit option
    And Im on "Search for a prisoner - Manage prison visits - DPS" page
    Then I click on option to search by booking reference
    And click on search button
    Then I see "Booking reference must be 8 characters" on booking reference search page
    And I sign out of the service

    Examples:
      | userName  | password               |
      | VSIP5_TST | MojDigitalServices2025 |

  @suite
  Scenario Outline: Error message on main contact page ~ Someone else option
    Given I log in with "<userName>" and "<password>"
    Then Im on "Manage prison visits - DPS" page
    And I click on Book a visit option
    And Im on "Search for a prisoner - Manage prison visits - DPS" page
    When I enter "<prisonNumber>" to search for a prison
    And click on search button
    Then I choose prisoner from search results
    Then Im on "Vsip_prisoner09, Do Not Use - Manage prison visits - DPS" page
    And I click on Book a visit button
    Then Im on "Select visitors from the prisoner’s approved visitor list - Manage prison visits - DPS" page
    And I select another visitor form the list
    And click on continue button
    Then Im on "Select date and time of visit - Manage prison visits - DPS" page
    And I select time slot
    And click on continue button
    Then Im on "Is additional support needed for any of the visitors? - Manage prison visits - DPS" page
    And I select No for additional support needed
    And click on continue button
    Then Im on "Who is the main contact for this booking? - Manage prison visits - DPS" page
    And click on continue button
    Then I see "No main contact selected" on select main contact page
    And I select the someone else option
    And click on continue button
    Then I see "Enter the name of the main contact" error message displayed
    Then I see "No answer selected" error message on main contact page
    And I choose UK phone number option
    And click on continue button
    Then I see "Enter a phone number" select main contact page
    And I sign out of the service

    Examples:
      | userName  | password               | prisonNumber |
      | VSIP5_TST | MojDigitalServices2025 | A8416DZ      |

  @suite
  Scenario Outline: Error message on view Visits by date page
    Given I log in with "<userName>" and "<password>"
    Then Im on "Manage prison visits - DPS" page
    And I click on View visits by date option
    And Im on "View visits by date - Manage prison visits - DPS" page
    When I select Date picker option
    Then I click on view button
    Then I see "Enter a valid date" on view visits by date page
    And I sign out of the service

    Examples:
      | userName  | password               |
      | VSIP5_TST | MojDigitalServices2025 |

  @suite
  Scenario Outline: Error message on select open or closed type visit page
    Given I log in with "<userName>" and "<password>"
    Then Im on "Manage prison visits - DPS" page
    And I select change establishment
    And I change the establishment to "Drake Hall (HMP & YOI)"
    And I click on Book a visit option
    And Im on "Search for a prisoner - Manage prison visits - DPS" page
    When I enter "<prisonNumber>" to search for a prison
    And click on search button
    Then I choose prisoner from search results
    Then Im on "Vsip_prisoner11, Do Not Use - Manage prison visits - DPS" page
    And I click on Book a visit button
    Then Im on "Select visitors from the prisoner’s approved visitor list - Manage prison visits - DPS" page
    And I select a visitor form the list from Drake hall establishment
    And click on continue button
    Then Im on "Check the prisoner's closed visit restrictions - Manage prison visits - DPS" page
    And click on continue button
    Then I see "No visit type selected" on select open or closed type page
    And I sign out of the service

    Examples:
      | userName  | password            | prisonNumber |
      | VSIP4_TST | DigitalServices2025 | A8899DZ      |
