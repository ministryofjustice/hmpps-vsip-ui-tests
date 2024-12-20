Feature: Book/Cancel/Amend a Visit
  As a user, I should be able to access new features to Book/Cancel/Amend a visit using VSIP service

  @suite
  Scenario Outline: Visit details captured by a method of booking
    Given I log in with "<userName>" and "<password>"
    Then Im on "Manage prison visits - Manage prison visits" page
    Then I book a visit for "<prisonerName>"
    And I click on Book a visit option
    And Im on "Manage prison visits - Search for a prisoner" page
    Then I click on option to search by booking reference
    And Im on "Manage prison visits - Search for a booking" page
    And I enter the booking reference
    And click on search button
    Then I choose prisoner from search results
    Then Im on "Manage prison visits - Visit booking details - <booking_reference>" visit view page
    And I see "Visit booking details" message displayed
    Then I choose Booking history tab
    And I see "Method: Phone booking" book request method displayed on booking history tab
    And I sign out of the service

    Examples:
      | userName  | password            | prisonerName    |
      | VSIP1_TST | DigitalServices2024 | Vsip_prisoner06 |


  @suite
  Scenario Outline: Visit details captured by a method of Cancellation
    Given I log in with "<userName>" and "<password>"
    Then Im on "Manage prison visits - Manage prison visits" page
    And I click on Book a visit option
    And Im on "Manage prison visits - Search for a prisoner" page
    Then I click on option to search by booking reference
    And Im on "Manage prison visits - Search for a booking" page
    Then I click on search by name or prison number option
    And Im on "Manage prison visits - Search for a prisoner" page
    When I enter "<prisonerName>" to search for a prison
    And click on search button
    Then I choose prisoner from search results
    Then Im on "Manage prison visits - Vsip_prisoner06, Do Not Use" page
    And I sign out of the service

    Examples:
      | userName  | password            | prisonerName    |
      | VSIP1_TST | DigitalServices2024 | VSIP_PRISONER06 |

  @suite
  Scenario Outline: User sees a message displayed if a Prisoner has no visitors over 18years old
    Given I log in with "<userName>" and "<password>"
    Then Im on "Manage prison visits - Manage prison visits" page
    And I click on Book a visit option
    And Im on "Manage prison visits - Search for a prisoner" page
    When I enter "<prisonNumber>" to search for a prison
    And click on search button
    Then I choose prisoner from search results
    Then Im on "Manage prison visits - Vsip_prisoner04, Do Not Use" page
    And I click on Book a visit button
    Then Im on "Manage prison visits - Select visitors from the prisoner’s approved visitor list" page
    And I check if the message is displayed no booking can be booked for this prisoner
    And I sign out of the service

    Examples:
      | userName  | password            | prisonNumber |
      | VSIP1_TST | DigitalServices2024 | A6445DZ      |

  @suite
  Scenario Outline: User can't Book a visit for a Prisoner for any of the Banned Visitors within their visitor list
    Given I log in with "<userName>" and "<password>"
    Then Im on "Manage prison visits - Manage prison visits" page
    And I click on Book a visit option
    And Im on "Manage prison visits - Search for a prisoner" page
    When I enter "<prisonNumber>" to search for a prison
    And click on search button
    Then I choose prisoner from search results
    Then Im on "Manage prison visits - Vsip_prisoner09, Do Not Use" page
    And I click on Book a visit button
    Then Im on "Manage prison visits - Select visitors from the prisoner’s approved visitor list" page
    And I check Banned status for the visitor
    And I check the Banned visitor is not selectable
    And I sign out of the service

    Examples:
      | userName  | password            | prisonNumber |
      | VSIP1_TST | DigitalServices2024 | A8416DZ      |