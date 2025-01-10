@ignore
Feature: Login
  As a user, I should be able to book a slot with the correct category

  @suite
  Scenario Outline: Book a opened slot for given category that matches prisoners category
    Given I navigate to VSIP service
    And I want to setup a opened session for "<prison>" for two days time at 9am to 11am for prisoner category of "<category>"
    Given I log in with "<userName>" and "<password>"
    Then Im on "Manage prison visits - DPS" page
    And I select change establishment
     And I change the establishment to "Drake Hall (HMP & YOI)"
    And I click on Book a visit option
    And Im on "Search for a prisoner - Manage prison visits - DPS" page
    When I enter "<prisonNumber>" to search for a prison
    And click on search button
    Then I choose prisoner from search results
    Then Im on "Vsip_prisoner14, Do Not Use - Manage prison visits - DPS" page
    And I check Female category for that prisoner
    And I click on Book a visit button
    Then Im on "Select visitors from the prisoner’s approved visitor list - Manage prison visits - DPS" page
    And I select a visitor form the list from Drake hall establishment
    And click on continue button
    Then Im on "Select date and time of visit - Manage prison visits - DPS" page
    And I select a slot in two days time at 9am to 11am
    And click on continue button
    Then Im on "Is additional support needed for any of the visitors? - Manage prison visits - DPS" page
    And I select No for additional support needed
    And click on continue button
    Then Im on "Who is the main contact for this booking? - Manage prison visits - DPS" page
    And I select the main contact option
    And I choose No phone number provided option
    And click on continue button
    Then Im on "How was this booking requested? - Manage prison visits - DPS" page
    And I select a phone call option on method used to make the request
    And click on continue button
    Then Im on "Check the visit details before booking - Manage prison visits - DPS" page
    And click on continue button
    Then Im on "Booking confirmed - Manage prison visits - DPS" page
    And I see "Booking confirmed" message displayed
    And I see a booking reference
    And I sign out of the service

    Examples:
      | userName  | password            | prison | prisonNumber | category      |
      | VSIP4_TST | DigitalServices2025 | DHI    | A8900DZ      | FEMALE_CLOSED |

  @suite
  Scenario Outline: When a prisoner is not in given category then we cannot book
    Given I navigate to VSIP service
    And I want to setup a opened session for "<prison>" for two days time at 9am to 11am for prisoner location of "<category>"
    Given I log in with "<userName>" and "<password>"
    Then Im on "Manage prison visits - Manage prison visits" page
    And I select change establishment
     And I change the establishment to "Drake Hall (HMP & YOI)"
    And I click on Book a visit option
    And Im on "Manage prison visits - Search for a prisoner" page
    When I enter "<prisonNumber>" to search for a prison
    And click on search button
    Then I choose prisoner from search results
    Then Im on "Manage prison visits - Vsip_prisoner14, Do Not Use" page
    And I check Female category for that prisoner
    And I click on Book a visit button
    Then Im on "Manage prison visits - Select visitors from the prisoner’s approved visitor list" page
    And I select a visitor form the list from Drake hall establishment
    And click on continue button
    Then Im on "Manage prison visits - Select date and time of visit" page
    And I cant select a slot in two days time at 9am to 11am
    And I sign out of the service

    Examples:
      | userName  | password            | prison | prisonNumber | category |
      | VSIP4_TST | DigitalServices2025 | DHI    | A8900DZ      | A_HIGH   |