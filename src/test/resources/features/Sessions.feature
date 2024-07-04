Feature: Session template based tests
  As a user, I should be able to view the Prison sessions based on session restrictions within the Prison establishments
# All the Test Data is pre-set in Admin service & via NOMIS ensure the Test Data is up-to-date with regards to session restrictions(in Admin service) within each establishment. All the tests are using Drake hall & Bristol establishments.

  @suite
  Scenario Outline: Open session - User able to book an Open session for all Prisoners within the establishment
    Given I log in with "<userName>" and "<password>"
    Then Im on "Manage prison visits - Manage prison visits" page
    And I select change establishment
    And I change the establishment to Bristol
    And click on continue button
    And I click on Book a visit option
    And Im on "Manage prison visits - Search for a prisoner" page
    When I enter "<prisonNumber>" to search for a prison
    And click on search button
    Then I choose prisoner from search results
    Then Im on "Manage prison visits - Vsip_prisoner12, Do Not Use" page
    And I click on Book a visit button
    Then Im on "Manage prison visits - Select visitors from the prisoner’s approved visitor list" page
    And I select a new visitor form the list from Bristol establishment
    And click on continue button
    Then Im on "Manage prison visits - Select date and time of visit" page
    And I check only Open time slots is available
    And I sign out of the service

    Examples:
      | userName  | password          | prisonNumber |
      | VSIP4_TST | DigitalServices12 | A8897DZ      |

  @suite
  Scenario Outline: Closed session - User able to book a Closed session for all Prisoners within the establishment
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
    And I choose closed type visit
    And click on continue button
    Then Im on "Manage prison visits - Select date and time of visit" page
    #Closed type is displayed
    And I check "Closed" visit type is displayed
    And I check only closed time slots is available
    And I check open timeslots not available
    And I sign out of the service

    Examples:
      | userName  | password          | prisonNumber |
      | VSIP4_TST | DigitalServices12 | A8899DZ      |

  @suite
  Scenario Outline: Location based - User able to book a visit based on a location within an establishment where the Prisoner is based
  # ensure a session restricted by location is only available to prisoners in that location
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
    #Location of a prisoner is being checked in this step if they can't carry on means Location is changed.
    And I check Prisoner location "I-1-003, Drake Hall (HMP & YOI)"
    And I click on Book a visit button
    Then Im on "Manage prison visits - Select visitors from the prisoner’s approved visitor list" page
    And I select a visitor form the list from Drake hall establishment
    And click on continue button
    Then Im on "Manage prison visits - Check the prisoner&#39;s closed visit restrictions" page
    And I choose closed type visit
    And click on continue button
    Then Im on "Manage prison visits - Select date and time of visit" page
    And I check only this location time slots is available
    And I check other location within this establishment timeslots not available
    And I sign out of the service

    Examples:
      | userName  | password          | prisonNumber |
      | VSIP4_TST | DigitalServices12 | A8899DZ      |

  @suite
  Scenario Outline: Location not based - User not able to book a visit based on a location within an establishment where the Prisoner is based
  # ensure a session restricted by location is not available to a prisoner not in that location
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
    Then Im on "Manage prison visits - Vsip_prisoner14, Do Not Use" page
    And I check Prisoner location "F-1-018, Drake Hall (HMP & YOI)" for drake hall
    And I click on Book a visit button
    Then Im on "Manage prison visits - Select visitors from the prisoner’s approved visitor list" page
    And I select a visitor the list from the Drake hall establishment
    And click on continue button
    Then Im on "Manage prison visits - Select date and time of visit" page
    And I check this location time slots is available
    And I check no other location time slots is available
    And I sign out of the service

    Examples:
      | userName  | password          | prisonNumber |
      | VSIP4_TST | DigitalServices12 | A8900DZ      |

  @suite
  Scenario Outline: Incentive level - User check incentive level within an establishment where the Prisoner is based
  # ensure a session restricted by incentive level is only available to prisoners with that incentive level

    Given I log in with "<userName>" and "<password>"
    Then Im on "Manage prison visits - Manage prison visits" page
    And I select change establishment
    And I change the establishment to Bristol
    And click on continue button
    And I click on Book a visit option
    And Im on "Manage prison visits - Search for a prisoner" page
    When I enter "<prisonNumber>" to search for a prison
    And click on search button
    Then I choose prisoner from search results
    Then Im on "Manage prison visits - Vsip_prisoner13, Do Not Use" page
    And I check incentive level for that prisoner
    And I click on Book a visit button
    Then Im on "Manage prison visits - Select visitors from the prisoner’s approved visitor list" page
    And I select next visitor form the list from Bristol establishment
    And click on continue button
    Then Im on "Manage prison visits - Select date and time of visit" page
    And I check only standard incentive timeslots available
    And I check enhanced timeslots not available
    And I sign out of the service

    Examples:
      | userName  | password          | prisonNumber |
      | VSIP4_TST | DigitalServices12 | A8898DZ      |

  @suite
  Scenario Outline: Incentive level - User check on incentive level of a Prisoner within an establishment
  # ensure a session restricted by incentive level is not available to a prisoner with that incentive level

    Given I log in with "<userName>" and "<password>"
    Then Im on "Manage prison visits - Manage prison visits" page
    And I select change establishment
    And I change the establishment to Bristol
    And click on continue button
    And I click on Book a visit option
    And Im on "Manage prison visits - Search for a prisoner" page
    When I enter "<prisonNumber>" to search for a prison
    And click on search button
    Then I choose prisoner from search results
    Then Im on "Manage prison visits - Vsip_prisoner12, Do Not Use" page
    And I check enhanced incentive level for that prisoner
    And I click on Book a visit button
    Then Im on "Manage prison visits - Select visitors from the prisoner’s approved visitor list" page
    And I select a new visitor form the list from Bristol establishment
    And click on continue button
    Then Im on "Manage prison visits - Select date and time of visit" page
    And I check only enhanced incentive timeslots available
    And I check standard timeslots not available
    And I sign out of the service

    Examples:
      | userName  | password          | prisonNumber |
      | VSIP4_TST | DigitalServices12 | A8897DZ      |

  @suite
  Scenario Outline: Category - User check the Category of a Prisoner within an establishment
  # ensure a session restricted by category is only available to prisoners with that category

    Given I log in with "<userName>" and "<password>"
    Then Im on "Manage prison visits - Manage prison visits" page
    And I select change establishment
    And I change the establishment to Bristol
    And click on continue button
    And I click on Book a visit option
    And Im on "Manage prison visits - Search for a prisoner" page
    When I enter "<prisonNumber>" to search for a prison
    And click on search button
    Then I choose prisoner from search results
    Then Im on "Manage prison visits - Vsip_prisoner12, Do Not Use" page
    And I check category for that prisoner
    And I click on Book a visit button
    Then Im on "Manage prison visits - Select visitors from the prisoner’s approved visitor list" page
    And I select a new visitor form the list from Bristol establishment
    And click on continue button
    Then Im on "Manage prison visits - Select date and time of visit" page
    And I check only Cat C time slots is available for this prisoner
    And I check other category time slots is not available
    And I sign out of the service

    Examples:
      | userName  | password          | prisonNumber |
      | VSIP4_TST | DigitalServices12 | A8897DZ      |

  @suite
  Scenario Outline: Category - User check the Category of a Prisoner within an establishment
  # ensure a session restricted by category is not available to a prisoner without that category

    Given I log in with "<userName>" and "<password>"
    Then Im on "Manage prison visits - Manage prison visits" page
    And I select change establishment
    And I change the establishment to Bristol
    And click on continue button
    And I click on Book a visit option
    And Im on "Manage prison visits - Search for a prisoner" page
    When I enter "<prisonNumber>" to search for a prison
    And click on search button
    Then I choose prisoner from search results
    Then Im on "Manage prison visits - Vsip_prisoner13, Do Not Use" page
    And I click on Book a visit button
    Then Im on "Manage prison visits - Select visitors from the prisoner’s approved visitor list" page
    And I select next visitor form the list from Bristol establishment
    And click on continue button
    Then Im on "Manage prison visits - Select date and time of visit" page
    And I check only Cat B timeslots is available
    And I check no other category timeslots is available
    And I sign out of the service

    Examples:
      | userName  | password          | prisonNumber |
      | VSIP4_TST | DigitalServices12 | A8898DZ       |
