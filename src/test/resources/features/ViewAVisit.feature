Feature: View a Visit
  As a user, I should be able to view a visit using VSIP service

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