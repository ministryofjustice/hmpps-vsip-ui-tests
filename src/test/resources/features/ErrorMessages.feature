Feature: Book a Visit Error messages
  As a user, I should be able to direct to enter correct details to Book a visit using VSIP service
#Error message Scenarios
  @suite
  Scenario Outline: Error message on search page
    Given I log in with "<userName>" and "<password>"
    Then Im on "Manage prison visits - Manage prison visits" page
    And I click on Book a visit option
    And Im on "Manage prison visits - Search for a prisoner" page
    And click on search button
    Then I see "You must enter at least 2 characters" on search page
    And I sign out of the service

    Examples:
      | userName  | password          |
      | VSIP5_TST | DigitalServices11 |

  @suite
  Scenario Outline: Error message on search page
    Given I log in with "<userName>" and "<password>"
    Then Im on "Manage prison visits - Manage prison visits" page
    And I click on Book a visit option
    And Im on "Manage prison visits - Search for a prisoner" page
    Then I click on option to search by booking reference
    And click on search button
    Then I see "Booking reference must be 8 characters" on booking reference search page
    And I sign out of the service

    Examples:
      | userName  | password          |
      | VSIP5_TST | DigitalServices11 |

  @suite
  Scenario Outline: Error message on main contact page ~ Someone else option
    Given I log in with "<userName>" and "<password>"
    Then Im on "Manage prison visits - Manage prison visits" page
    And I click on Book a visit option
    And Im on "Manage prison visits - Search for a prisoner" page
    When I enter "<prisonNumber>" to search for a prison
    And click on search button
    Then I choose prisoner from search results
    Then Im on "Manage prison visits - Vsip_prisoner09, Do Not Use" page
    And I click on Book a visit button
    Then Im on "Manage prison visits - Select visitors from the prisoner’s approved visitor list" page
    And I select another visitor form the list
    And click on continue button
    Then Im on "Manage prison visits - Select date and time of visit" page
    And I select time slot
    And click on continue button
    Then Im on "Manage prison visits - Is additional support needed for any of the visitors?" page
    And I select No for additional support needed
    And click on continue button
    Then Im on "Manage prison visits - Who is the main contact for this booking?" page
    And click on continue button
    Then I see "No main contact selected" on select main contact page
    And I select the someone else option
    And click on continue button
    Then I see "Enter the name of the main contact" error message displayed
    Then I see "No answer selected" error message on main contact page
    And I choose UK phone number option
    And click on continue button
    Then I see "Enter a phone number" select main contact page
    And I sign out of the service

    Examples:
      | userName  | password          | prisonNumber |
      | VSIP5_TST | DigitalServices11 | A8416DZ      |

  @suite
  Scenario Outline: Error message on view Visits by date page
    Given I log in with "<userName>" and "<password>"
    Then Im on "Manage prison visits - Manage prison visits" page
    And I click on View visits by date option
    And Im on "Manage prison visits - View visits by date" page
    When I select Date picker option
    Then I click on view button
    Then I see "Enter a valid date" on view visits by date page
    And I sign out of the service

    Examples:
      | userName  | password          |
      | VSIP5_TST | DigitalServices11 |

  @suite
  Scenario Outline: Error message on select open or closed type visit page
    Given I log in with "<userName>" and "<password>"
    Then Im on "Manage prison visits - Manage prison visits" page
    And I select change establishment
    And I change the establishmnet to Drake Hall
    And click on continue button
    And I click on Book a visit option
    And Im on "Manage prison visits - Search for a prisoner" page
    When I enter "<prisonNumber>" to search for a prison
    And click on search button
    Then I choose prisoner from search results
    Then Im on "Manage prison visits - Vsip_prisoner11, Do Not Use" page
    And I click on Book a visit button
    Then Im on "Manage prison visits - Select visitors from the prisoner’s approved visitor list" page
    And I select a visitor form the list from Drake hall establishment
    And click on continue button
    Then Im on "Manage prison visits - Check the prisoner&#39;s closed visit restrictions" page
    And click on continue button
    Then I see "No visit type selected" on select open or closed type page
    And I sign out of the service

    Examples:
      | userName  | password          | prisonNumber |
      | VSIP4_TST | DigitalServices11 | A8899DZ      |
