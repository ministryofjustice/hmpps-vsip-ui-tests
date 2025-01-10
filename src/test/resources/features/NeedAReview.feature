Feature: Need a review
  As a user, I should be able to review a visit using VSIP service

  @suite
  Scenario Outline: User able to view the Visit status
    Given I log in with "<userName>" and "<password>"
    Then Im on "Manage prison visits - DPS" page
    And I click on Need a Review option
    And Im on "Visit bookings that need review - Manage prison visits - DPS" page
    And I check the list "What checks are done to create this list?"
    And I sign out of the service

    Examples:
      | userName  | password            |
      | VSIP1_TST | DigitalServices2025|