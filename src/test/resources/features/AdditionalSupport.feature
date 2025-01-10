Feature: Additional Support
  As a user, I should be able to book a visit with additional support using VSIP service

  @suite
  Scenario Outline: Book a visit search via prison number
    Given I log in with "<userName>" and "<password>"
    Then Im on "Manage prison visits - DPS" page
    And I click on Book a visit option
    And Im on "Search for a prisoner - Manage prison visits - DPS" page
    When I enter "<prisonNumber>" to search for a prison
    And click on search button
    Then I choose prisoner from search results
    Then Im on "Vsip_prisoner01, Do Not Use - Manage prison visits - DPS" page
    And I click on Book a visit button
    Then Im on "Select visitors from the prisoner’s approved visitor list - Manage prison visits - DPS" page
    And I select a visitor form the list
    And click on continue button
    Then Im on "Select date and time of visit - Manage prison visits - DPS" page
    And I select time slot
    And click on continue button
    Then Im on "Is additional support needed for any of the visitors? - Manage prison visits - DPS" page
    And I select Yes for additional support needed
    And I enter "<details>" for additional support
    And click on continue button
    Then Im on "Who is the main contact for this booking? - Manage prison visits - DPS" page
    And I select the main contact option
    And I choose UK phone number option
    And I enter "<phoneNumber>" to get text message
    And click on continue button
    Then Im on "How was this booking requested? - Manage prison visits - DPS" page
    And I select a phone call option on method used to make the request
    And click on continue button
    Then Im on "Check the visit details before booking - Manage prison visits - DPS" page
    Then I verify additional support details is displayed
    And click on continue button
    Then Im on "Booking confirmed - Manage prison visits - DPS" page
    And I see "Booking confirmed" message displayed
    And I see a booking reference
    # Checking Additional support details displayed
    And I click on Manage a Prison option
    Then Im on "Manage prison visits - DPS" page
    And I click on Book a visit option
    And Im on "Search for a prisoner - Manage prison visits - DPS" page
    When I enter "<prisonNumber>" to search for a prison
    And click on search button
    Then I choose prisoner from search results
    Then Im on "Vsip_prisoner01, Do Not Use - Manage prison visits - DPS" page
    And I select last booked visit reference
    And I choose Booking visitors tab
    Then I check additional support is displayed
    And I sign out of the service

    Examples:
      | userName  | password            | prisonNumber | phoneNumber | details     |
      | VSIP2_TST | DigitalServices2025 | A6036DZ      | 07805123900 | wheel chair |
