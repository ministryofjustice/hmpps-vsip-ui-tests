Feature: When a prisoner with a booked visit is release then visit needs review

  @test_suite
  Scenario: A prisoner with a booked visit is release then visit needs review
    Given I log in with "VSIP2_TST" and "Expired11"
    Then Im on "Manage prison visits - Manage prison visits" page
    Then I book a visit for "Vsip_prisoner06"
    # We do this to simulate a visit from an old prison
    Then I change booked visit prison to "BLI"
    # received prisoner
    Given A prisoner "A6539DZ" is received from "HEI" for "TRANSFERRED"
    And then we wait "5" second for the system to update
    And I sign out of the service
    # VSIP3_TST has bristol as default prison
    Then I log in with "VSIP3_TST" and "Expired11"
    And I goto home page
    Then Im on "Manage prison visits - Manage prison visits" page
    And I see need a Review option with a review number flag
    # This has to wait for front end to be developed
    # And I click on view link to see details of the booking needs review
    # And Im on "Manage prison visits - Visit bookings that need review" page
    # This has to wait for front end to be developed
    # And I click on view link to see details of the booking needs review
    # Then Im on "Manage prison visits - Visit booking details - <booking_reference>" visit view page
    # And I see "This booking should be cancelled as the prisoner has been received." banner
    # And I choose Booking history tab
    # And I see "Needs review" option
    And I sign out of the service