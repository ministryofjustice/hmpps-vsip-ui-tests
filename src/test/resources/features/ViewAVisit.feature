Feature: View a Visit
  As a user, I should be able to view a visit using VSIP service

  @suite
  Scenario Outline: User able to view the Visit status
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
    And I check the visit status "Booked"
    And I sign out of the service

    Examples:
      | userName  | password          | value1 | value2 | value3 | value4 |
      | VSIP1_TST | Expired10         | qa     | cv     | mg     | cv     |

  @suite
  Scenario Outline: User able to view Visits by date
    Given I navigate to VSIP service
    And Im on "HMPPS Digital Services - Sign in" page
    And I enter "<userName>"
    And I enter the "<password>"
    And click on submit button
    Then Im on "Manage prison visits - Manage prison visits" page
    And I click on View visits by date option
    And Im on "Manage prison visits - View visits by date" page
    When I select Date picker option
    And I enter "<date>" to view the visits
    Then I click on view button
    Then I see tabs changed to the date
    And I sign out of the service

    Examples:
      | userName  | password          | date       |
      | VSIP1_TST | Expired10         | 20/11/2023 |

  @suite
  Scenario Outline: User able to view Visits by date
    Given I navigate to VSIP service
    And Im on "HMPPS Digital Services - Sign in" page
    And I enter "<userName>"
    And I enter the "<password>"
    And click on submit button
    Then Im on "Manage prison visits - Manage prison visits" page
    And I click on View visits by date option
    And Im on "Manage prison visits - View visits by date" page
    When I select Date picker option
    And I enter "<date>" to view the visits
    Then I click on view button
    Then I see a visit and click on view option
    Then I see "Visit booking details" of the visit of that date
    And I sign out of the service

    Examples:
      | userName  | password          | date       |
      | VSIP1_TST | Expired10         | 16/03/2024 |