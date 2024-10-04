Feature: Unflag an event when booking is updated, cancelled or marked as 'Do not change'

  Background:
    Given I log in with "VSIP2_TST" and "Expired19"
    Then Im on "Manage prison visits - Manage prison visits" page
    Then I book a visit for "Vsip_prisoner06"
    # We do this to simulate a visit from an old prison
    Then I change booked visit prison to "BLI"
    # received prisoner
    Given A prisoner "A6539DZ" is received from "HEI" for "TRANSFERRED"
    And then we wait "5" second for the system to update
    And I sign out of the service
    # VSIP3_TST has bristol as default prison
    Then I log in with "VSIP3_TST" and "Expired19"
    And I goto home page
    Then Im on "Manage prison visits - Manage prison visits" page
    And I see need a Review option with a review number flag
    And I click on Need a Review option
    And I click on view link to see details of the booking needs review
    Then Im on "Manage prison visits - Visit booking details - <booking_reference>" visit view page

  @suite
  Scenario: An event is unflagged when marked as 'Do not change'
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

  @suite
  Scenario:  An event is unflagged when booking is cancelled
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


#  Enable this tests after we decide how we handle 'Update' option for a prisoner transfer
  @ignore
  Scenario:  An event is unflagged when the booking is Updated.
    Then I click on update booking button
    And Im on "Manage prison visits - Select visitors from the prisoner’s approved visitor list" page
    And click on continue button
    Then Im on "Manage prison visits - Select date and time of visit" page
    And I select time slot
    And click on continue button
    Then Im on "Manage prison visits - Is additional support needed for any of the visitors?" page
    And I select No for additional support needed
    And click on continue button
    Then Im on "Manage prison visits - Who is the main contact for this booking?" page
    And click on continue button
    Then Im on "Manage prison visits - How was this booking requested?" page
    And I select a phone call option on method used to make the request
    And click on continue button
    Then Im on "Manage prison visits - Check the visit details before booking" page
    And click on continue button
    Then Im on "Manage prison visits - Booking updated" page
    And I see "Booking updated" message displayed
    And I see a booking reference
    And I wait for "3" seconds
    And I goto home page
    Then Im on "Manage prison visits - Manage prison visits" page
    And the need to Review option is unset
    And I sign out of the service

