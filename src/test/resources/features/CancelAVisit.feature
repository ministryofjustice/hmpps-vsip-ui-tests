Feature: Cancel a Visit
  As a user, I should be able to cancel a visit using VSIP service

  @suite
  Scenario Outline: Cancel a visit with Visitor Cancelled option
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
    And I click on Cancel a visit button
    Then Im on "Manage prison visits - Why is this booking being cancelled?" page
    And I select Visitor Cancelled option
    And I select Phone call option
    And I enter cancellation "<reason>" for the visit
    And click on cancel button
    Then Im on "Manage prison visits - Booking cancelled" page
    And I see "Booking cancelled" message displayed
    And I click on Manage a Prison option
    And I click on Book a visit option
    And Im on "Manage prison visits - Search for a prisoner" page
    Then I click on option to search by booking reference
    And Im on "Manage prison visits - Search for a booking" page
    And I enter the booking reference
    And click on search button
    Then I choose prisoner from search results
    Then Im on "Manage prison visits - Visit booking details - <booking_reference>" visit view page
    And I see "This visit was cancelled by the visitor." message displayed on Booking details page
    Then I choose Booking history tab
    And  I see "Reason: <reason>" reason message displayed on booking history tab
    And I see "Method: Phone booking" cancel request method displayed on booking history tab
    And I sign out of the service

    Examples:
      | userName  | password  | prisonerName    | reason              |
      | VSIP1_TST | Expired19 | Vsip_prisoner06 | Visitor broke a leg |

  @suite
  Scenario Outline: Cancel a visit with Establishment cancelled option
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
    And I click on Cancel a visit button
    Then Im on "Manage prison visits - Why is this booking being cancelled?" page
    And I select Establishment cancelled option
    And I enter cancellation "<reason>" for the visit
    And click on cancel button
    Then Im on "Manage prison visits - Booking cancelled" page
    And I see "Booking cancelled" message displayed
    And I click on Manage a Prison option
    And I click on Book a visit option
    And Im on "Manage prison visits - Search for a prisoner" page
    Then I click on option to search by booking reference
    And Im on "Manage prison visits - Search for a booking" page
    And I enter the booking reference
    And click on search button
    Then I choose prisoner from search results
    Then Im on "Manage prison visits - Visit booking details - <booking_reference>" visit view page
    And I see "This visit was cancelled by the establishment." message displayed on Booking details page
    Then I choose Booking history tab
    And I see "Reason: <reason>" reason message displayed on booking history tab
    And I sign out of the service

    Examples:
      | userName  | password  | prisonerName    | reason         |
      | VSIP1_TST | Expired19 | Vsip_prisoner06 | new visit room |

  @suite
  Scenario Outline: Cancel a visit with Prisoner cancelled option
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
    And I click on Cancel a visit button
    Then Im on "Manage prison visits - Why is this booking being cancelled?" page
    And I select Prisoner cancelled option
    And I enter cancellation "<reason>" for the visit
    And click on cancel button
    Then Im on "Manage prison visits - Booking cancelled" page
    And I see "Booking cancelled" message displayed
    And I click on Manage a Prison option
    And I click on Book a visit option
    And Im on "Manage prison visits - Search for a prisoner" page
    Then I click on option to search by booking reference
    And Im on "Manage prison visits - Search for a booking" page
    And I enter the booking reference
    And click on search button
    Then I choose prisoner from search results
    Then Im on "Manage prison visits - Visit booking details - <booking_reference>" visit view page
    And I see "This visit was cancelled by the prisoner." message displayed on Booking details page
    Then I choose Booking history tab
    And I see "Reason: <reason>" reason message displayed on booking history tab
    And I sign out of the service

    Examples:
      | userName  | password  | prisonerName    | reason          |
      | VSIP1_TST | Expired19 | Vsip_prisoner06 | prisoner is ill |

  @suite
  Scenario Outline: Cancel a visit with Administrative error option
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
    And I click on Cancel a visit button
    Then Im on "Manage prison visits - Why is this booking being cancelled?" page
    And I select Administrative error option
    And I enter cancellation "<reason>" for the visit
    And click on cancel button
    Then Im on "Manage prison visits - Booking cancelled" page
    And I see "Booking cancelled" message displayed
    And I click on Manage a Prison option
    And I click on Book a visit option
    And Im on "Manage prison visits - Search for a prisoner" page
    Then I click on option to search by booking reference
    And Im on "Manage prison visits - Search for a booking" page
    And I enter the booking reference
    And click on search button
    Then I choose prisoner from search results
    Then Im on "Manage prison visits - Visit booking details - <booking_reference>" visit view page
    And I see "This visit was cancelled due to an administrative error with the booking." message displayed on Booking details page
    Then I choose Booking history tab
    And I see "Reason: <reason>" reason message displayed on booking history tab
    And I sign out of the service

    Examples:
      | userName  | password  | prisonerName    | reason    |
      | VSIP1_TST | Expired19 | Vsip_prisoner06 | no tables |

  @suite
  Scenario Outline: Cancel a visit because booking details have changed error option
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
    And I click on Cancel a visit button
    Then Im on "Manage prison visits - Why is this booking being cancelled?" page
    And I select because booking details have changed option
    And I enter cancellation "<reason>" for the visit
    And click on cancel button
    Then Im on "Manage prison visits - Booking cancelled" page
    And I see "Booking cancelled" message displayed
    And I click on Manage a Prison option
    And I click on Book a visit option
    And Im on "Manage prison visits - Search for a prisoner" page
    Then I click on option to search by booking reference
    And Im on "Manage prison visits - Search for a booking" page
    And I enter the booking reference
    And click on search button
    Then I choose prisoner from search results
    Then Im on "Manage prison visits - Visit booking details - <booking_reference>" visit view page
    And I see "This visit was cancelled as the details changed after booking." message displayed on Booking details page
    Then I choose Booking history tab
    And I see "Reason: <reason>" reason message displayed on booking history tab
    And I sign out of the service

    Examples:
      | userName  | password  | prisonerName    | reason                |
      | VSIP1_TST | Expired19 | Vsip_prisoner06 | non ass not permitted |

