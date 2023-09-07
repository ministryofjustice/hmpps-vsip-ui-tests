Feature: View a Visit
  As a user, I should be able to view a visit using VSIP service

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

    Examples:
      | userName                    | password                 | value1 | value2 | value3 | value4 |
      | VSIP1_TST                   | Unitedstatesofamerica10  |   dm   |  he    |   lj   |   zj   |

