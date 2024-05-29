Feature: When a prisoner with a booked visit is release then visit needs review

  @test_suite
  Scenario Outline: A prisoner with a booked visit is release then visit needs review
    Given I log in with "<userName>" and "<password>"
    Then Im on "Manage prison visits - Manage prison visits" page
    Then I book a visit for "<prisonerName>"
    # received prisoner
    Given A prisoner "<prisonerCode>" is received from "<prisonCode>" for "<reason>"
    And then we wait "5" second for the system to update
    And I goto home page
    Then Im on "Manage prison visits - Manage prison visits" page
    And I click on Need a Review option with a review number flag
    And Im on "Manage prison visits - Visit bookings that need review" page
    # This has to wait for front end to develop pahe
    # And I click on view link to see details of the booking needs review
    # Then Im on "Manage prison visits - Visit booking details - <booking_reference>" visit view page
    # And I see "This booking should be cancelled as the prisoner has been received." banner
    # And I choose Booking history tab
    # And I see "Needs review" option
    And I sign out of the service



    Examples:
      | userName  | password          | prisonerName    | prisonCode | prisonerCode | reason |
      | VSIP2_TST | Expired11         | VSIP_PRISONER06 | HEI        | A6539DZ      | TRANSFERRED |