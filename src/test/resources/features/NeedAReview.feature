Feature: Need a review
  As a user, I should be able to review a visit using VSIP service

  @suite
  Scenario Outline: User able to view the Visit status
    Given I navigate to VSIP service
    And Im on "HMPPS Digital Services - Sign in" page
    And I enter "<userName>"
    And I enter the "<password>"
    And click on submit button
    Then Im on "Manage prison visits - Manage prison visits" page
    And I click on Need a Review option
    And Im on "Manage prison visits - Visit bookings that need review" page
    And I check the list "What checks are done to create this list?"
    And I sign out of the service

    Examples:
      | userName  | password          |
      | VSIP1_TST | DigitalServices10 |