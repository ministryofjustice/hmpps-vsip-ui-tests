@suite
Feature: Un-flag an event when booking is updated, cancelled or marked as 'Do not change'

  Background:
    Given I log in with "VSIP2_TST" and "DigitalServices2024"
    Then Im on "Manage prison visits - Manage prison visits" page
    Then I book a visit for "Vsip_prisoner06"
    # We do this to simulate a visit from an old prison
    Then I change booked visit prison to "BLI"
    # received prisoner
    Given A prisoner "A6539DZ" is received from "HEI" for "TRANSFERRED"
    And then we wait "5" second for the system to update
    And I sign out of the service
    # VSIP3_TST has bristol as default prison
    Then I log in with "VSIP3_TST" and "DigitalServices2024"
    And I goto home page
    Then Im on "Manage prison visits - Manage prison visits" page
    And I see need a Review option with a review number flag
    And I click on Need a Review option
    And I click on view link to see details of the booking needs review
    Then Im on "Manage prison visits - Visit booking details - <booking_reference>" visit view page

  Scenario: An event is un-flagged when marked as 'Do not change'
    And click on do not change button
    Then Im on "Manage prison visits - Are you sure the visit does not need to be updated or cancelled?" page
    And I select yes to the question i am sure the visit dose not need to be updated or cancelled
    And I enter a "Because the prisoner is coming back" as a reason why the visit does not need to be updated or cancelled
    And click on submit button
    And I wait for "3" seconds
    And I goto home page
    Then Im on "Manage prison visits - Manage prison visits" page
    And the need to Review option is unset
    And I sign out of the service

  Scenario:  An event is un-flagged when booking is cancelled
    And I click on Cancel a visit button
    Then Im on "Manage prison visits - Why is this booking being cancelled?" page
    And I select Visitor Cancelled option
    And I select Phone call option
    And I enter cancellation "ill" for the visit
    And click on cancel button
    And I wait for "3" seconds
    And I goto home page
    Then Im on "Manage prison visits - Manage prison visits" page
    And the need to Review option is unset
    And I sign out of the service

  Scenario:  An event is un-flagged when the booking is Updated.
    Then the update booking button is not displayed
    And I sign out of the service

