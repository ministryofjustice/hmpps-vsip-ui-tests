Feature: Book/Cancel/Amend a Visit
  As a user, I should be able to access new features to Book/Cancel/Amend a visit using VSIP service

  @suite
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
    Then Im on "Manage prison visits - Visit booking details - em-il-ov-wq" page
    And I see "Visit booking details" message displayed
    Then I choose Booking history tab
    And I see "Email request" displayed on Booking details page
    And I sign out of the service

    Examples:
      | userName  | password          | value1 | value2 | value3 | value4 |
      | VSIP1_TST | DigitalServices10 | em     | il     | ov     | wq     |

  @suite
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
    Then Im on "Manage prison visits - Visit booking details - gm-iv-rv-br" page
    And I see "Visit booking details" message displayed
    Then I choose Booking history tab
    And I see "GOV.UK request" message displayed on Booking details page
    And I sign out of the service

    Examples:
      | userName  | password          | value1 | value2 | value3 | value4 |
      | VSIP1_TST | DigitalServices10 | gm     | iv     | rv     | br     |