Feature: View a Visit
  As a user, I should be able to view a visit using VSIP service

  @suite
  Scenario Outline: User able to view the Visit status
    Given I log in with "<userName>" and "<password>"
    Then Im on "Manage prison visits - DPS" page
    Then I book a visit for "<prisonerName>"
    And I click on Book a visit option
    And Im on "Search for a prisoner - Manage prison visits - DPS" page
    Then I click on option to search by booking reference
    And Im on "Search for a booking - Manage prison visits - DPS" page
    And I enter the booking reference
    And click on search button
    And I check the visit status "Booked"
    And I sign out of the service

    Examples:
      | userName  | password            | prisonerName    |
      | VSIP1_TST |DigitalServices2025 | Vsip_prisoner06 |

  # @suite // TODO: find a way to capture booking slot date and time to use when searching for visit by date.
  Scenario Outline: User able to view Visits by date
    Given I log in with "<userName>" and "<password>"
    Then Im on "Manage prison visits - DPS" page
    And I click on View visits by date option
    And Im on "View visits by date - Manage prison visits - DPS" page
    When I select Date picker option
    And I enter "<date>" to view the visits
    Then I click on view button
    Then I see tabs changed to the date
    And I sign out of the service

    Examples:
      | userName  | password            | date       |
      | VSIP1_TST |DigitalServices2025 | 20/11/2023 |

  # @suite // TODO: find a way to capture booking slot date and time to use when searching for visit by date.
  Scenario Outline: User able to view Visits by date
    Given I log in with "<userName>" and "<password>"
    Then Im on "Manage prison visits - DPS" page
    And I click on View visits by date option
    And Im on "View visits by date - Manage prison visits - DPS" page
    When I select Date picker option
    And I enter "<date>" to view the visits
    Then I click on view button
    Then I see a visit and click on view option
    Then I see "Visit booking details" of the visit of that date
    And I sign out of the service

    Examples:
      | userName  | password            | date       |
      | VSIP1_TST |DigitalServices2025 | 16/03/2024 |