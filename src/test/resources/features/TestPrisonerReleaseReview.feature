Feature: When a prisoner with a booked visit is release then visit needs review

  @test_suite
  Scenario Outline: A prisoner with a booked visit is release then visit needs review
    Given I log in with "<userName>" and "<password>"
    Then Im on "Manage prison visits - Manage prison visits" page
    And I click on Book a visit option
    And Im on "Manage prison visits - Search for a prisoner" page
    When I enter "<prisonerName>" to search for a prison
    And click on search button
    Then I choose prisoner from search results
    Then Im on "Manage prison visits - Vsip_prisoner06, Do Not Use" page
    And I click on Book a visit button
    Then Im on "Manage prison visits - Select visitors from the prisoner’s approved visitor list" page
    And I select a visitor form the lists
    And click on continue button
    Then Im on "Manage prison visits - Select date and time of visit" page
    And I select time slot
    And click on continue button
    Then Im on "Manage prison visits - Is additional support needed for any of the visitors?" page
    And I select No for additional support needed
    And click on continue button
    Then Im on "Manage prison visits - Who is the main contact for this booking?" page
    And I select the main contact option
    And I choose UK phone number option
    And I enter "<phoneNumber>" to get text message
    And click on continue button
    Then Im on "Manage prison visits - How was this booking requested?" page
    And I select a phone call option on method used to make the request
    And click on continue button
    Then Im on "Manage prison visits - Check the visit details before booking" page
    And click on continue button
    Then Im on "Manage prison visits - Booking confirmed" page
    And I see "Booking confirmed" message displayed
    And I see a booking reference
    # release prisoner
    Given A prisoner "<prisonerCode>" is released from "<prisonCode>"
    And then we wait "5" second for the system to update
    And I goto home page
    Then Im on "Manage prison visits - Manage prison visits" page
    And I click on Need a Review option with a review number flag
    And Im on "Manage prison visits - Visit bookings that need review" page
    And I click on view link to see details of the booking needs review
    Then Im on "Manage prison visits - Visit booking details - <booking_reference>" visit view page
    And I see "This booking should be cancelled as the prisoner has been released." banner
    And I choose Booking history tab
    And I see "Needs review" option
    And I sign out of the service





    Examples:
      | userName  | password          | prisonerName    | phoneNumber | prisonCode | prisonerCode |
      | VSIP2_TST | Expired10         | VSIP_PRISONER06 | 07805123900 | HEI        | A6539DZ      |