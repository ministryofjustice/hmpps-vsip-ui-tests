Feature: When a booking get prisoner release notification
  but we do not want to change the visit

  @test_suite @suite
  Scenario Outline: mark visit notification for some one who released from prison as do not change and add remark

    Given I log in with "<userName>" and "<password>"
    Then Im on "Manage prison visits - Manage prison visits" page
    Then I book a visit for "<prisonerName>"
    And I click on Book a visit option
    And Im on "Manage prison visits - Search for a prisoner" page
    Then I click on option to search by booking reference
    And Im on "Manage prison visits - Search for a booking" page
    And I enter the booking reference
    Given A prisoner "<prisonerCode>" is released from "<prisonCode>" for "RELEASED"
    And I wait for "5" seconds
    And I goto home page
    Then Im on "Manage prison visits - Manage prison visits" page
    And I click on Need a Review option with a review number flag
    And Im on "Manage prison visits - Visit bookings that need review" page
    And I click on view link to see details of the booking needs review
    Then Im on "Manage prison visits - Visit booking details - <booking_reference>" visit view page
    And I see "This booking should be cancelled as the prisoner has been released." banner
    And I choose Booking history tab
    And click on do not change button
    Then Im on "Manage prison visits - Are you sure the visit does not need to be updated or cancelled?" page
    And I select yes to the question i am sure the visit dose not need to be updated or cancelled
    And I enter a "Because the prisoner is coming back" as a reason why the visit does not need to be updated or cancelled
    And click on submit button
    Then Im on "Manage prison visits - Visit booking details - <booking_reference>" visit view page
    And I do not see the do not change button
    And I sign out of the service

    Examples:
      | userName  | password            | prisonerName    | phoneNumber | prisonCode | prisonerCode |
      | VSIP2_TST | DigitalServices2024 | Vsip_prisoner06 | 07805123900 | HEI        | A6539DZ      |


  @test_suite @suite
  Scenario Outline: mark visit notification for some one who released from prison as do not change and do not add remark

    Given I log in with "<userName>" and "<password>"
    Then Im on "Manage prison visits - Manage prison visits" page
    Then I book a visit for "<prisonerName>"
    And I click on Book a visit option
    And Im on "Manage prison visits - Search for a prisoner" page
    Then I click on option to search by booking reference
    And Im on "Manage prison visits - Search for a booking" page
    And I enter the booking reference
    Given A prisoner "<prisonerCode>" is released from "<prisonCode>" for "RELEASED"
    And I wait for "5" seconds
    And I goto home page
    Then Im on "Manage prison visits - Manage prison visits" page
    And I click on Need a Review option with a review number flag
    And Im on "Manage prison visits - Visit bookings that need review" page
    And I click on view link to see details of the booking needs review
    Then Im on "Manage prison visits - Visit booking details - <booking_reference>" visit view page
    And I see "This booking should be cancelled as the prisoner has been released." banner
    And I choose Booking history tab
    And click on do not change button
    Then Im on "Manage prison visits - Are you sure the visit does not need to be updated or cancelled?" page
    And I select yes to the question i am sure the visit dose not need to be updated or cancelled
    And I enter a "" as a reason why the visit does not need to be updated or cancelled
    And click on submit button
    Then I see "Enter a reason for not changing the booking" on the page
    And I sign out of the service

    Examples:
      | userName  | password            | prisonerName    | prisonCode | prisonerCode |
      | VSIP2_TST | DigitalServices2024 | Vsip_prisoner06 | HEI        | A6539DZ      |


  @test_suite @suite
  Scenario Outline: goto visit notification page and press submit with out selecting options

    Given I log in with "<userName>" and "<password>"
    Then Im on "Manage prison visits - Manage prison visits" page
    Then I book a visit for "<prisonerName>"
    And I click on Book a visit option
    And Im on "Manage prison visits - Search for a prisoner" page
    Then I click on option to search by booking reference
    And Im on "Manage prison visits - Search for a booking" page
    And I enter the booking reference
    Given A prisoner "<prisonerCode>" is released from "<prisonCode>" for "RELEASED"
    And I wait for "5" seconds
    And I goto home page
    Then Im on "Manage prison visits - Manage prison visits" page
    And I click on Need a Review option with a review number flag
    And Im on "Manage prison visits - Visit bookings that need review" page
    And I click on view link to see details of the booking needs review
    Then Im on "Manage prison visits - Visit booking details - <booking_reference>" visit view page
    And I see "This booking should be cancelled as the prisoner has been released." banner
    And I choose Booking history tab
    And click on do not change button
    Then Im on "Manage prison visits - Are you sure the visit does not need to be updated or cancelled?" page
    And click on submit button
    Then I see "No answer selected" on the page
    And I sign out of the service

    Examples:
      | userName  | password            | prisonerName    | phoneNumber | prisonCode | prisonerCode |
      | VSIP2_TST | DigitalServices2024 | Vsip_prisoner06 | 07805123900 | HEI        | A6539DZ      |


  @test_suite @suite
  Scenario Outline: goto visit notification page and select no to are you sure the visit does not need to be updated or cancelled

    Given I log in with "<userName>" and "<password>"
    Then Im on "Manage prison visits - Manage prison visits" page
    Then I book a visit for "<prisonerName>"
    And I click on Book a visit option
    And Im on "Manage prison visits - Search for a prisoner" page
    Then I click on option to search by booking reference
    And Im on "Manage prison visits - Search for a booking" page
    And I enter the booking reference
    Given A prisoner "<prisonerCode>" is released from "<prisonCode>" for "RELEASED"
    And I wait for "5" seconds
    And I goto home page
    Then Im on "Manage prison visits - Manage prison visits" page
    And I click on Need a Review option with a review number flag
    And Im on "Manage prison visits - Visit bookings that need review" page
    And I click on view link to see details of the booking needs review
    Then Im on "Manage prison visits - Visit booking details - <booking_reference>" visit view page
    And I see "This booking should be cancelled as the prisoner has been released." banner
    And I choose Booking history tab
    And click on do not change button
    Then Im on "Manage prison visits - Are you sure the visit does not need to be updated or cancelled?" page
    And I select no to the question i am sure the visit dose not need to be updated or cancelled
    And click on submit button
    Then Im on "Manage prison visits - Visit booking details - <booking_reference>" visit view page
    And I see the do not change button
    And I sign out of the service

    Examples:
      | userName  | password            | prisonerName    | phoneNumber | prisonCode | prisonerCode |
      | VSIP2_TST | DigitalServices2024 | Vsip_prisoner06 | 07805123900 | HEI        | A6539DZ      |