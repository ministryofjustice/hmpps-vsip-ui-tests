@ignore
Feature: When a prisoner with a booked visit  has high priority alerts added then visit needs review

  @test_suite @suite
  Scenario: A prisoner with a booked visit has a high priority alert (C1) added then visit needs review
    Given I log in with "VSIP2_TST" and "DigitalServices2025"
    Then Im on "Manage prison visits - DPS" page
    And I click on Book a visit option
    And Im on "Search for a prisoner - Manage prison visits - DPS" page
    When I enter "VSIP_PRISONER06" to search for a prison
    And click on search button
    Then I choose prisoner from search results
    Then Im on "Vsip_prisoner06, Do Not Use - Manage prison visits - DPS" page
    And I click on Book a visit button
    Then Im on "Select visitors - Manage prison visits - DPS" page
    And I select a visitor form the lists
    And click on continue button
    Then Im on "Select date and time of visit - Manage prison visits - DPS" page
    And I select time slot
    And click on continue button
    Then Im on "Is additional support needed for any of the visitors? - Manage prison visits - DPS" page
    And I select No for additional support needed
    And click on continue button
    Then Im on "Who is the main contact for this booking? - Manage prison visits - DPS" page
    And I select the main contact option
    And I choose UK phone number option
    And I enter "01111111111" to get text message
    And click on continue button
    Then Im on "How was this booking requested? - Manage prison visits - DPS" page
    And I select a phone call option on method used to make the request
    And click on continue button
    Then Im on "Check the visit details before booking - Manage prison visits - DPS" page
    And click on continue button
    Then Im on "Booking confirmed - Manage prison visits - DPS" page
    And I see "Booking confirmed" message displayed
    And I see a booking reference
    # add alert event
    Given A prisoner "A6539DZ" has "C1,TEST" alerts updated
    And I wait for "8" seconds
    And I goto home page
    Then Im on "Manage prison visits - DPS" page
    And I click on Need a Review option with a review number flag
    And Im on "Visit bookings that need review - Manage prison visits - DPS" page
    And I click on view link to see details of the booking needs review
#    Then Im on "Manage prison visits - Visit booking details - <booking_reference>" visit view page
    And I click on Cancel a visit button
    Then Im on "Why is this booking being cancelled? - Manage prison visits - DPS" page
    And I select because booking details have changed option
    And I enter cancellation "<reason>" for the visit
    And click on cancel button
    Then Im on "Booking cancelled - Manage prison visits - DPS" page
    And I see "Booking cancelled" message displayed
    And I goto home page
    Then Im on "Manage prison visits - DPS" page
    And I click on Need a Review option
    And Im on "Visit bookings that need review - Manage prison visits - DPS" page
    And I check to see that there are no notifications for review
    And I sign out of the service


  @test_suite @suite
  Scenario: A prisoner with a booked visit has a alert added that does not impact visits (TEST) then visit does not need review
    Given I log in with "VSIP2_TST" and "DigitalServices2025"
    Then Im on "Manage prison visits - DPS" page
    And I click on Book a visit option
    And Im on "Search for a prisoner - Manage prison visits - DPS" page
    When I enter "VSIP_PRISONER06" to search for a prison
    And click on search button
    Then I choose prisoner from search results
    Then Im on "Vsip_prisoner06, Do Not Use - Manage prison visits - DPS" page
    And I click on Book a visit button
    Then Im on "Select visitors - Manage prison visits - DPS" page
    And I select a visitor form the lists
    And click on continue button
    Then Im on "Select date and time of visit - Manage prison visits - DPS" page
    And I select time slot
    And click on continue button
    Then Im on "Is additional support needed for any of the visitors? - Manage prison visits - DPS" page
    And I select No for additional support needed
    And click on continue button
    Then Im on "Who is the main contact for this booking? - Manage prison visits - DPS" page
    And I select the main contact option
    And I choose UK phone number option
    And I enter "01111111111" to get text message
    And click on continue button
    Then Im on "How was this booking requested? - Manage prison visits - DPS" page
    And I select a phone call option on method used to make the request
    And click on continue button
    Then Im on "Check the visit details before booking - Manage prison visits - DPS" page
    And click on continue button
    Then Im on "Booking confirmed - Manage prison visits - DPS" page
    And I see "Booking confirmed" message displayed
    And I see a booking reference
    # add alert event
    Given A prisoner "A6539DZ" has "TEST" alerts updated
    And then we wait "8" second for the system to update
    And I goto home page
    Then Im on "Manage prison visits - DPS" page
    And I click on Need a Review option
    And Im on "Visit bookings that need review - Manage prison visits - DPS" page
    And I check to see that there are no notifications for review
    And I sign out of the service

  @test_suite @suite
  Scenario: A prisoner with a booked visit has only alerts removed then visit does not need review
    Given I log in with "VSIP2_TST" and "DigitalServices2025"
    Then Im on "Manage prison visits - DPS" page
    And I click on Book a visit option
    And Im on "Search for a prisoner - Manage prison visits - DPS" page
    When I enter "VSIP_PRISONER06" to search for a prison
    And click on search button
    Then I choose prisoner from search results
    Then Im on "Vsip_prisoner06, Do Not Use - Manage prison visits - DPS" page
    And I click on Book a visit button
    Then Im on "Select visitors - Manage prison visits - DPS" page
    And I select a visitor form the lists
    And click on continue button
    Then Im on "Select date and time of visit - Manage prison visits - DPS" page
    And I select time slot
    And click on continue button
    Then Im on "Is additional support needed for any of the visitors? - Manage prison visits - DPS" page
    And I select No for additional support needed
    And click on continue button
    Then Im on "Who is the main contact for this booking? - Manage prison visits - DPS" page
    And I select the main contact option
    And I choose UK phone number option
    And I enter "01111111111" to get text message
    And click on continue button
    Then Im on "How was this booking requested? - Manage prison visits - DPS" page
    And I select a phone call option on method used to make the request
    And click on continue button
    Then Im on "Check the visit details before booking - Manage prison visits - DPS" page
    And click on continue button
    Then Im on "Booking confirmed - Manage prison visits - DPS" page
    And I see "Booking confirmed" message displayed
    And I see a booking reference
    # add alert event
    Given A prisoner "A6539DZ" has no alerts added
    And then we wait "8" second for the system to update
    And I goto home page
    Then Im on "Manage prison visits - DPS" page
    And I click on Need a Review option
    And Im on "Visit bookings that need review - Manage prison visits - DPS" page
    And I check to see that there are no notifications for review
    And I sign out of the service

