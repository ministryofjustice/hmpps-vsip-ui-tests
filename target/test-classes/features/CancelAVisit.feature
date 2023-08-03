Feature: Cancel a Visit
  As a user, I should be able to cancel a visit using VSIP service
  @suite
  Scenario Outline: Cancel a visit with Visitor Cancelled option
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
    Then Im on "Manage prison visits - Booking details - ol-fn-me-ml" page
    And I click on Cancel a visit button
    Then Im on "Manage prison visits - Why is this booking being cancelled?" page
    And I select Visitor Cancelled option
#   The below step can run in multiple options Gov.uk, Email, In person
    And I select Phone call option
    And I enter cancellation "<reason>" for the visit
    And click on cancel button
    Then Im on "Manage prison visits - Booking cancelled" page
    And I see "Booking cancelled" message displayed

    Examples:
      | userName                    | password               | value1 | value2 | value3 | value4 | reason           |
      | ANAGULA_GEN                 | Ministryofjustice10    |   ol   |  fn    |   me   |   ml   | Health issues    |

  Scenario Outline: Cancel a visit with Establishment cancelled option
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
    Then Im on "Manage prison visits - Booking details - rl-fy-lp-al" page
    And I click on Cancel a visit button
    Then Im on "Manage prison visits - Why is this booking being cancelled?" page
    And I select Establishment cancelled option
    And I enter cancellation "<reason>" for the visit
    And click on cancel button
    Then Im on "Manage prison visits - Booking cancelled" page
    And I see "Booking cancelled" message displayed

    Examples:
      | userName                    | password               | value1 | value2 | value3 | value4 | reason           |
      | ANAGULA_GEN                 | Ministryofjustice10    |   rl   |  fy    |   lp   |   al   | Health issues    |

  Scenario Outline: Cancel a visit with Prisoner cancelled option
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
    Then Im on "Manage prison visits - Booking details - rl-fy-lp-al" page
    And I click on Cancel a visit button
    Then Im on "Manage prison visits - Why is this booking being cancelled?" page
    And I select Prisoner cancelled option
    And I enter cancellation "<reason>" for the visit
    And click on cancel button
    Then Im on "Manage prison visits - Booking cancelled" page
    And I see "Booking cancelled" message displayed

    Examples:
      | userName                    | password               | value1 | value2 | value3 | value4 | reason           |
      | ANAGULA_GEN                 | Ministryofjustice10    |   rl   |  fy    |   lp   |   al   | Health issues    |

  Scenario Outline: Cancel a visit with Administrative error option
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
    Then Im on "Manage prison visits - Booking details - rl-fy-lp-al" page
    And I click on Cancel a visit button
    Then Im on "Manage prison visits - Why is this booking being cancelled?" page
    And I select Administrative error option
    And I enter cancellation "<reason>" for the visit
    And click on cancel button
    Then Im on "Manage prison visits - Booking cancelled" page
    And I see "Booking cancelled" message displayed

    Examples:
      | userName                    | password               | value1 | value2 | value3 | value4 | reason           |
      | ANAGULA_GEN                 | Ministryofjustice10    |   rl   |  fy    |   lp   |   al   | Health issues    |
  @suite
  Scenario Outline: Confirm Cancel a visit by a visitor
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
    Then Im on "Manage prison visits - Booking details - ql-iv-or-jm" page
    And I see "This visit was cancelled by the visitor." message displayed on Booking details page
    And I sign out of the service

    Examples:
      | userName                    | password               | value1 | value2 | value3 | value4 |
      | ANAGULA_GEN                 | Ministryofjustice10    |   ql   |  iv    |   or   |   jm   |