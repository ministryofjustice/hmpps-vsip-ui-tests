@suite
Feature: Non-association visit
  As a user, I shouldn't be able to book a visit using VSIP service for a non-association prisoners

  Scenario: Non-association
    Given I log in with "VSIP3_TST" and "DigitalServices2025"
    Then Im on "Manage prison visits - DPS" page
    And I select change establishment
    And I change the establishment to "Bristol (HMP)"
    And I click on Book a visit option
    And Im on "Search for a prisoner - Manage prison visits - DPS" page
    When I enter "A6038DZ" to search for a prison
    And click on search button
    Then I choose prisoner from search results
    Then Im on "Vsip_prisoner03, Do Not Use - Manage prison visits - DPS" page
    And I click on Book a visit button
    Then Im on "Select visitors - Manage prison visits - DPS" page
    And I select a visitor form the list from Bristol establishment
    And click on continue button
    Then Im on "Select date and time of visit - Manage prison visits - DPS" page
    And I select time slot
#    And I select a time slot for a non-association prisoner
    And click on continue button
    Then Im on "Is additional support needed for any of the visitors? - Manage prison visits - DPS" page
    And I select No for additional support needed
    And click on continue button
    Then Im on "Who is the main contact for this booking? - Manage prison visits - DPS" page
    And I select the main contact option
    And I choose UK phone number option
    And I enter "07805123900" to get text message
    And click on continue button
    Then Im on "How was this booking requested? - Manage prison visits - DPS" page
    And I select a phone call option on method used to make the request
    And click on continue button
    Then Im on "Check the visit details before booking - Manage prison visits - DPS" page
    And click on continue button
    #And click on submit booking button
    Then Im on "Booking confirmed - Manage prison visits - DPS" page
    And I see "Booking confirmed" message displayed
    And I see a booking reference
#   NON-ASSOCIATION scenario begins here
    And I click on Manage a Prison option
    Then Im on "Manage prison visits - DPS" page
    And I click on Book a visit option
    And Im on "Search for a prisoner - Manage prison visits - DPS" page
    When I enter "VSIP_PRISONER08" to search for a prison
    And click on search button
    Then I choose prisoner from search results
    Then Im on "Vsip_prisoner08, Do Not Use - Manage prison visits - DPS" page
    And I click on Book a visit button
    Then Im on "Select visitors - Manage prison visits - DPS" page
    And I select a visitor form the list
    And click on continue button
    Then Im on "Select date and time of visit - Manage prison visits - DPS" page
    And I shouldn't be able to select a timeslot that was booked last
    And I sign out of the service
