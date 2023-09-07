Feature: Book/Cancel/Amend a Visit
  As a user, I should be able to access new features to Book/Cancel/Amend a visit using VSIP service

  Scenario Outline: Visit details captured by a method of booking
    Given I navigate to VSIP service
    And Im on "HMPPS Digital Services - Sign in" page
    And I enter "<userName>"
    And I enter the "<password>"
    And click on submit button
    Then Im on "Manage prison visits - Manage prison visits" page
    And I click on Change a visit option
    And Im on "Manage prison visits - Search for a booking" page
    And I enter "<value1>" in first block
    And I enter "<value2>" in second block
    And I enter "<value3>" in third block
    And I enter "<value4>" in fourth block
    And click on search button
    Then I choose prison from search results
    Then Im on "Manage prison visits - Booking details - rx-um-sy-en" page
    And I see "Booking details" message displayed
    And I see "Tuesday 1 August 2023 at 11:02am by Anusha Nagula (phone call request)" displayed on Booking details page
    And I sign out of the service

    Examples:
      | userName                    | password                   | value1 | value2 | value3 | value4 |
      | VSIP1_TST                   | Unitedstatesofamerica10    |  rx    |  um    |   sy   |   en   |


  Scenario Outline: Visit details captured by a method of Cancellation
    Given I navigate to VSIP service
    And Im on "HMPPS Digital Services - Sign in" page
    And I enter "<userName>"
    And I enter the "<password>"
    And click on submit button
    Then Im on "Manage prison visits - Manage prison visits" page
    And I click on Change a visit option
    And Im on "Manage prison visits - Search for a booking" page
    And I enter "<value1>" in first block
    And I enter "<value2>" in second block
    And I enter "<value3>" in third block
    And I enter "<value4>" in fourth block
    And click on search button
    Then I choose prison from search results
    Then Im on "Manage prison visits - Booking details - rx-um-sy-en" page
    And I see "Booking details" message displayed
    And I see "Wednesday 2 August 2023 at 11:43am by Anusha Nagula (in person request)" displayed on Booking details page
    And I sign out of the service

    Examples:
      | userName                    | password                   | value1 | value2 | value3 | value4 |
      | VSIP1_TST                   | Unitedstatesofamerica10    |  rx    |  um    |   sy   |   en   |