Feature: When a booking get prisoner release notification
  but we do not want to change the visit

  @test_suite
  Scenario Outline: mark visit notification for some one who released from prison as do not change and add remark

    Given I navigate to VSIP service
    And Im on "HMPPS Digital Services - Sign in" page
    And I enter "<userName>"
    And I enter the "<password>"
    And click on login submit button
    Then Im on "Manage prison visits - Manage prison visits" page
    And I click on Book a visit option
    And Im on "Manage prison visits - Search for a prisoner" page
    When I enter "<prisonerName>" to search for a prison
    And click on search button
    Then I choose prison from search results
    Then Im on "Manage prison visits - Vsip_prisoner06, Do Not Use" page
    And I click on Book a visit button
    Then Im on "Manage prison visits - Select visitors from the prisoner’s approved visitor list" page
    And I select a visitor form the lists
    And click on continue button
    Then Im on "Manage prison visits - Select date and time of visit" page
    And I select time slot
    And click on continue button
    Then Im on "Manage prison visits - Is additional support needed for any of the visitors?" page
    Then I take note of the hidden application reference
    And I select No for additional support needed
    And click on continue button
    Then Im on "Manage prison visits - Who is the main contact for this booking?" page
    And I select the main contact option
    And I choose UK phone number option
    And I enter "<phoneNumber>" to get text message
    And click on continue button
    Then Im on "Manage prison visits - How was this booking requested?" page
    And I select a phone call option on method used to make the reqest
    And click on continue button
    Then Im on "Manage prison visits - Check the visit details before booking" page
    And click on continue button
    Then Im on "Manage prison visits - Booking confirmed" page
    And I see "Booking confirmed" message displayed
    And I see a booking reference
    Given A prisoner "<prisonerCode>" is released from "<prisonCode>"
    And then we wait "2" second for the system to update
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
    And I select yes i am sure the visit dose not need to be updated or cancelled
    And I enter a "Because the prisoner is coming back" as a reason why the visit dose not need to be updated or cancelled
    And click on submit button
    Then Im on "Manage prison visits - Visit booking details - <booking_reference>" visit view page
    And I do not see the do not change button
    And I sign out of the service

    Examples:
          | userName  | password          | prisonerName    | phoneNumber | prisonCode | prisonerCode |
          | VSIP2_TST | Expired10         | VSIP_PRISONER06 | 07805123900 | HEI        | A6539DZ      |


  @test_suite
  Scenario Outline: mark visit notification for some one who released from prison as do not change and do not add remark

    Given I navigate to VSIP service
    And Im on "HMPPS Digital Services - Sign in" page
    And I enter "<userName>"
    And I enter the "<password>"
    And click on login submit button
    Then Im on "Manage prison visits - Manage prison visits" page
    And I click on Book a visit option
    And Im on "Manage prison visits - Search for a prisoner" page
    When I enter "<prisonerName>" to search for a prison
    And click on search button
    Then I choose prison from search results
    Then Im on "Manage prison visits - Vsip_prisoner06, Do Not Use" page
    And I click on Book a visit button
    Then Im on "Manage prison visits - Select visitors from the prisoner’s approved visitor list" page
    And I select a visitor form the lists
    And click on continue button
    Then Im on "Manage prison visits - Select date and time of visit" page
    And I select time slot
    And click on continue button
    Then Im on "Manage prison visits - Is additional support needed for any of the visitors?" page
    Then I take note of the hidden application reference
    And I select No for additional support needed
    And click on continue button
    Then Im on "Manage prison visits - Who is the main contact for this booking?" page
    And I select the main contact option
    And I choose UK phone number option
    And I enter "<phoneNumber>" to get text message
    And click on continue button
    Then Im on "Manage prison visits - How was this booking requested?" page
    And I select a phone call option on method used to make the reqest
    And click on continue button
    Then Im on "Manage prison visits - Check the visit details before booking" page
    And click on continue button
    Then Im on "Manage prison visits - Booking confirmed" page
    And I see "Booking confirmed" message displayed
    And I see a booking reference
    Given A prisoner "<prisonerCode>" is released from "<prisonCode>"
    And then we wait "2" second for the system to update
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
    And I select yes i am sure the visit dose not need to be updated or cancelled
    And I enter a "" as a reason why the visit dose not need to be updated or cancelled
    And click on submit button
    Then I see "Enter a reason for not changing the booking" on the page
    And I sign out of the service

    Examples:
      | userName  | password          | prisonerName    | phoneNumber | prisonCode | prisonerCode |
      | VSIP2_TST | Expired10         | VSIP_PRISONER06 | 07805123900 | HEI        | A6539DZ      |


  @test_suite
  Scenario Outline: goto visit notification page and press submit with out selecting options

    Given I navigate to VSIP service
    And Im on "HMPPS Digital Services - Sign in" page
    And I enter "<userName>"
    And I enter the "<password>"
    And click on login submit button
    Then Im on "Manage prison visits - Manage prison visits" page
    And I click on Book a visit option
    And Im on "Manage prison visits - Search for a prisoner" page
    When I enter "<prisonerName>" to search for a prison
    And click on search button
    Then I choose prison from search results
    Then Im on "Manage prison visits - Vsip_prisoner06, Do Not Use" page
    And I click on Book a visit button
    Then Im on "Manage prison visits - Select visitors from the prisoner’s approved visitor list" page
    And I select a visitor form the lists
    And click on continue button
    Then Im on "Manage prison visits - Select date and time of visit" page
    And I select time slot
    And click on continue button
    Then Im on "Manage prison visits - Is additional support needed for any of the visitors?" page
    Then I take note of the hidden application reference
    And I select No for additional support needed
    And click on continue button
    Then Im on "Manage prison visits - Who is the main contact for this booking?" page
    And I select the main contact option
    And I choose UK phone number option
    And I enter "<phoneNumber>" to get text message
    And click on continue button
    Then Im on "Manage prison visits - How was this booking requested?" page
    And I select a phone call option on method used to make the reqest
    And click on continue button
    Then Im on "Manage prison visits - Check the visit details before booking" page
    And click on continue button
    Then Im on "Manage prison visits - Booking confirmed" page
    And I see "Booking confirmed" message displayed
    And I see a booking reference
    Given A prisoner "<prisonerCode>" is released from "<prisonCode>"
    And then we wait "2" second for the system to update
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
      | userName  | password          | prisonerName    | phoneNumber | prisonCode | prisonerCode |
      | VSIP2_TST | Expired10         | VSIP_PRISONER06 | 07805123900 | HEI        | A6539DZ      |


  @test_suite
  Scenario Outline: goto visit notification page and select no to are you sure the visit does not need to be updated or cancelled

    Given I navigate to VSIP service
    And Im on "HMPPS Digital Services - Sign in" page
    And I enter "<userName>"
    And I enter the "<password>"
    And click on login submit button
    Then Im on "Manage prison visits - Manage prison visits" page
    And I click on Book a visit option
    And Im on "Manage prison visits - Search for a prisoner" page
    When I enter "<prisonerName>" to search for a prison
    And click on search button
    Then I choose prison from search results
    Then Im on "Manage prison visits - Vsip_prisoner06, Do Not Use" page
    And I click on Book a visit button
    Then Im on "Manage prison visits - Select visitors from the prisoner’s approved visitor list" page
    And I select a visitor form the lists
    And click on continue button
    Then Im on "Manage prison visits - Select date and time of visit" page
    And I select time slot
    And click on continue button
    Then Im on "Manage prison visits - Is additional support needed for any of the visitors?" page
    Then I take note of the hidden application reference
    And I select No for additional support needed
    And click on continue button
    Then Im on "Manage prison visits - Who is the main contact for this booking?" page
    And I select the main contact option
    And I choose UK phone number option
    And I enter "<phoneNumber>" to get text message
    And click on continue button
    Then Im on "Manage prison visits - How was this booking requested?" page
    And I select a phone call option on method used to make the reqest
    And click on continue button
    Then Im on "Manage prison visits - Check the visit details before booking" page
    And click on continue button
    Then Im on "Manage prison visits - Booking confirmed" page
    And I see "Booking confirmed" message displayed
    And I see a booking reference
    Given A prisoner "<prisonerCode>" is released from "<prisonCode>"
    And then we wait "2" second for the system to update
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
    And I select no i am sure the visit dose not need to be updated or cancelled
    And click on submit button
    Then Im on "Manage prison visits - Visit booking details - <booking_reference>" visit view page
    And I see the do not change button
    And I sign out of the service

    Examples:
      | userName  | password          | prisonerName    | phoneNumber | prisonCode | prisonerCode |
      | VSIP2_TST | Expired10         | VSIP_PRISONER06 | 07805123900 | HEI        | A6539DZ      |