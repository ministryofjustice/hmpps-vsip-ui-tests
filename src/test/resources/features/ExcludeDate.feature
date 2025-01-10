@ignore
Feature: API based Exclude date
  As a user, I should be able to view a booking flagged when the booking date is excluded from an establishment and able to update the booking accordingly and see it is unflagged.

  @suite
  Scenario Outline: Exclude Date
    Given I log in with "<userName>" and "<password>"
    Then Im on "Manage prison visits - Manage prison visits" page
    Then I book a visit for "<prisonerName>" and stay on confirmation page
    # To exclude date ~~ API call
    Given A date is excluded for booking at "<prison>"
    And I goto home page
    Then Im on "Manage prison visits - Manage prison visits" page
    And I click on Need a Review option
    And Im on "Manage prison visits - Visit bookings that need review" page
    And I click on view link to see details of the booking needs review
    Then I see "A new visit time should be selected as the date is no longer available for social visits." message is displayed
    And I choose Booking history tab
    And I see "Reason: Time slot removed" time slot removed reason
    And I do not see the do not change button
    # updating the booking
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
    #check Needs A Review
    And I goto home page
    Then Im on "Manage prison visits - Manage prison visits" page
    And I click on Need a Review option
    And Im on "Manage prison visits - Visit bookings that need review" page
    And I check to see that there are no notifications for review
    And I sign out of the service
    And I want to clean up after the exclude date test at "<prison>"
    Examples:
      | userName  | password            | prisonerName    | prison |
      | VSIP1_TST | DigitalServices2025 | Vsip_prisoner06 | HEI    |

