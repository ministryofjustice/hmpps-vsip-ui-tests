Feature: Exclude date
  As a user, I should be able to view a booking flagged when the booking date is excluded from an establishment and able to update the booking accordingly and see it is unflagged.

  @suite
  Scenario Outline: Exclude Date
    Given I navigate to VSIP service
    And Im on "HMPPS Digital Services - Sign in" page
    And I enter "<userName>"
    And I enter the "<password>"
    And click on submit button
    Then Im on "Manage prison visits - Manage prison visits" page
    And I click on Book a visit option
    And Im on "Manage prison visits - Search for a prisoner" page
    When I enter "<prisonNumber>" to search for a prison
    And click on search button
    Then I choose prison from search results
    Then Im on "Manage prison visits - Vsip_prisoner01, Do Not Use" page
    And I click on Book a visit button
    Then Im on "Manage prison visits - Select visitors from the prisoner’s approved visitor list" page
    And I select a visitor form the list
    And click on continue button
    Then Im on "Manage prison visits - Select date and time of visit" page
    And I select time slot
    And click on continue button
    Then Im on "Manage prison visits - Is additional support needed for any of the visitors?" page
    And I select No for additional support needed
    And click on continue button
    Then Im on "Manage prison visits - Who is the main contact for this booking?" page
    And I select the main contact option
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
    # exclude date
    Given A booking reference date is excluded
    And I goto home page
    Then Im on "Manage prison visits - Manage prison visits" page
    And I click on Need a Review option
    And Im on "Manage prison visits - Visit bookings that need review" page
    And I click on view link to see details of the booking needs review
    And I choose Booking history tab
    And I see "Reason: Time slot removed" time slot removed reason
    Then I click on update booking button
    And Im on "Manage prison visits - Select visitors from the prisoner’s approved visitor list" page
    Then I see "A new visit time must be selected." message is displayed
    # updating the booking
    And I select time slot
    And click on continue button
    Then Im on "Manage prison visits - Is additional support needed for any of the visitors?" page
    And I select No for additional support needed
    And click on continue button
    Then Im on "Manage prison visits - Who is the main contact for this booking?" page
    And I select the main contact option
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
    #check Needs A Review
    And I goto home page
    Then Im on "Manage prison visits - Manage prison visits" page
    And I click on Need a Review option
    And Im on "Manage prison visits - Visit bookings that need review" page
    And I see booking reference is not available
    And I sign out of the service


    Examples:
      | userName  | password          | prisonNumber | phoneNumber |
      | VSIP1_TST | Expired10         | A6036DZ      | 07805123900 |
