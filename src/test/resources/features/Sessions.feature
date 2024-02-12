Feature: Session template based tests
  As a user, I should be able to view the Prison sessions based on session restrictions within the Prison establishments
# All the Test Data is pre-set in Admin service & via NOMIS ensure the Test Data is up-to-date with regards to session restrictions(in Admin service) within each establishment. All the tests are using Drake hall & Bristol establishments.

  @suite
  Scenario Outline: Open session - User able to book an Open session for all Prisoners within the establishment
    Given I navigate to VSIP service
    And Im on "HMPPS Digital Services - Sign in" page
    And I enter "<userName>"
    And I enter the "<password>"
    And click on submit button
    Then Im on "Manage prison visits - Manage prison visits" page
    And I select change establishment
    And I change the establishmnet to Bristol
    And click on continue button
    And I click on Book a visit option
    And Im on "Manage prison visits - Search for a prisoner" page
    When I enter "<prisonNumber>" to search for a prison
    And click on search button
    Then I choose prison from search results
    Then Im on "Manage prison visits - Vsip_prisoner12, Do Not Use" page
    And I click on Book a visit button
    Then Im on "Manage prison visits - Select visitors from the prisoner’s approved visitor list" page
    And I select a visitr form the list from Bristol establishment
    And click on continue button
    Then Im on "Manage prison visits - Select date and time of visit" page
    And I select time slot
    And click on continue button
    Then Im on "Manage prison visits - Is additional support needed for any of the visitors?" page
    And I select No for additional support needed
    And click on continue button
    Then Im on "Manage prison visits - Who is the main contact for this booking?" page
    And I select the main contact option
    And I enter "<phoneNumber>" to get text message
    And click on continue button
    Then Im on "Manage prison visits - How was this booking requested?" page
    And I select a phone call option on method used to make the reqest
    And click on continue button
    Then Im on "Manage prison visits - Check the visit details before booking" page
    And click on continue button
    #And click on submit booking button
    Then Im on "Manage prison visits - Booking confirmed" page
    And I see "Booking confirmed" message displayed
    And I see a booking reference
    And I click on Manage a Prison option
    Then Im on "Manage prison visits - Manage prison visits" page
    And I click on Book a visit option
    And Im on "Manage prison visits - Search for a prisoner" page
    When I enter "<prisonNumber>" to search for a prison
    And click on search button
    Then I choose prison from search results
    Then Im on "Manage prison visits - Vsip_prisoner12, Do Not Use" page
    And I select last booked visit reference
    And I check "open" session is booked
    And I sign out of the service
    #Reverting the Booking for consistent Test execution
    And I want to clean up after the above test

    Examples:
      | userName  | password          | prisonNumber | phoneNumber    |
      | VSIP4_TST | DigitalServices10 | A8897DZ      | 07806543211    |

  @suite
  Scenario Outline: Closed session - User able to book a Closed session for all Prisoners within the establishment
    Given I navigate to VSIP service
    And Im on "HMPPS Digital Services - Sign in" page
    And I enter "<userName>"
    And I enter the "<password>"
    And click on submit button
    Then Im on "Manage prison visits - Manage prison visits" page
    And I select change establishment
    And I change the establishmnet to Bristol
    And click on continue button
    And I click on Book a visit option
    And Im on "Manage prison visits - Search for a prisoner" page
    When I enter "<prisonNumber>" to search for a prison
    And click on search button
    Then I choose prison from search results
    Then Im on "Manage prison visits - Vsip_prisoner11, Do Not Use" page
    And I click on Book a visit button
    Then Im on "Manage prison visits - Select visitors from the prisoner’s approved visitor list" page
    And I select a visitor form the list from Bristol establishment
    And click on continue button
    Then Im on "Manage prison visits - Select date and time of visit" page
    And I select time slot
    And click on continue button
    Then Im on "Manage prison visits - Is additional support needed for any of the visitors?" page
    And I select No for additional support needed
    And click on continue button
    Then Im on "Manage prison visits - Who is the main contact for this booking?" page
    And I select the main contact option
    And I enter "<phoneNumber>" to get text message
    And click on continue button
    Then Im on "Manage prison visits - How was this booking requested?" page
    And I select a phone call option on method used to make the reqest
    And click on continue button
    Then Im on "Manage prison visits - Check the visit details before booking" page
    And click on continue button
    #And click on submit booking button
    Then Im on "Manage prison visits - Booking confirmed" page
    And I see "Booking confirmed" message displayed
    And I see a booking reference
    And I click on Manage a Prison option
    Then Im on "Manage prison visits - Manage prison visits" page
    And I click on Book a visit option
    And Im on "Manage prison visits - Search for a prisoner" page
    When I enter "<prisonNumber>" to search for a prison
    And click on search button
    Then I choose prison from search results
    Then Im on "Manage prison visits - Vsip_prisoner11, Do Not Use" page
    And I select last booked visit reference
    And I check "closed" session is booked
    And I sign out of the service
    #Reverting the Booking for consistent Test execution
    And I want to clean up after the above test


    Examples:
      | userName  | password          | prisonNumber |
      | VSIP4_TST | DigitalServices10 | A8899DZ      |

  @suite
  Scenario Outline: Location based - User able to book a visit based on a location within an establishment where the Prisoner is based
  # ensure a session restricted by location is only available to prisoners in that location

    Given I navigate to VSIP service
    And Im on "HMPPS Digital Services - Sign in" page
    And I enter "<userName>"
    And I enter the "<password>"
    And click on submit button
    Then Im on "Manage prison visits - Manage prison visits" page
    And I select change establishment
    And I change the establishmnet to Bristol
    And click on continue button
    And I click on Book a visit option
    And Im on "Manage prison visits - Search for a prisoner" page
    When I enter "<prisonNumber>" to search for a prison
    And click on search button
    Then I choose prison from search results
    Then Im on "Manage prison visits - Vsip_prisoner12, Do Not Use" page
    And I check Prisoner location "A-2-007, Bristol (HMP)"
    And I click on Book a visit button
    Then Im on "Manage prison visits - Select visitors from the prisoner’s approved visitor list" page
    And I select a visitor form the list from Bristol establishment
    And click on continue button
    Then Im on "Manage prison visits - Select date and time of visit" page
    And I select time slot
    And click on continue button
    Then Im on "Manage prison visits - Is additional support needed for any of the visitors?" page
    And I select No for additional support needed
    And click on continue button
    Then Im on "Manage prison visits - Who is the main contact for this booking?" page
    And I select the main contact option
    And I enter "<phoneNumber>" to get text message
    And click on continue button
    Then Im on "Manage prison visits - How was this booking requested?" page
    And I select a phone call option on method used to make the reqest
    And click on continue button
    Then Im on "Manage prison visits - Check the visit details before booking" page
    And click on continue button
    #And click on submit booking button
    Then Im on "Manage prison visits - Booking confirmed" page
    And I see "Booking confirmed" message displayed
    And I see a booking reference
    And I sign out of the service
    #Reverting the Booking for consistent Test execution
    And I want to clean up after the above test

    Examples:
      | userName  | password          | prisonNumber |
      | VSIP4_TST | DigitalServices10 | A8897DZ      |

  @suite
  Scenario Outline: Location not based - User not able to book a visit based on a location within an establishment where the Prisoner is based
  # ensure a session restricted by location is not available to a prisoner not in that location

    Given I navigate to VSIP service
    And Im on "HMPPS Digital Services - Sign in" page
    And I enter "<userName>"
    And I enter the "<password>"
    And click on submit button
    Then Im on "Manage prison visits - Manage prison visits" page
    And I select change establishment
    And I change the establishmnet to Bristol
    And click on continue button
    And I click on Book a visit option
    And Im on "Manage prison visits - Search for a prisoner" page
    When I enter "<prisonNumber>" to search for a prison
    And click on search button
    Then I choose prison from search results
    Then Im on "Manage prison visits - Vsip_prisoner07, Do Not Use" page

    And I sign out of the service

    Examples:
      | userName  | password          | prisonNumber |
      | VSIP4_TST | DigitalServices10 | A6540DZ      |

  @suite
  Scenario Outline: Incentive level - User check incentive level within an establishment where the Prisoner is based
  # ensure a session restricted by incentive level is only available to prisoners with that incentive level

    Given I navigate to VSIP service
    And Im on "HMPPS Digital Services - Sign in" page
    And I enter "<userName>"
    And I enter the "<password>"
    And click on submit button
    Then Im on "Manage prison visits - Manage prison visits" page
    And I select change establishment
    And I change the establishmnet to Bristol
    And click on continue button
    And I click on Book a visit option
    And Im on "Manage prison visits - Search for a prisoner" page
    When I enter "<prisonNumber>" to search for a prison
    And click on search button
    Then I choose prison from search results
    Then Im on "Manage prison visits - Vsip_prisoner13, Do Not Use" page
    And I check incentive level for that prisoner
    And I sign out of the service

    Examples:
      | userName  | password          | prisonNumber |
      | VSIP4_TST | DigitalServices10 | A8898DZ      |

  @suite
  Scenario Outline: Incentive level - User check on incentive level of a Prisoner within an establishment
  # ensure a session restricted by incentive level is not available to a prisoner with that incentive level

    Given I navigate to VSIP service
    And Im on "HMPPS Digital Services - Sign in" page
    And I enter "<userName>"
    And I enter the "<password>"
    And click on submit button
    Then Im on "Manage prison visits - Manage prison visits" page
    And I select change establishment
    And I change the establishmnet to Bristol
    And click on continue button
    And I click on Book a visit option
    And Im on "Manage prison visits - Search for a prisoner" page
    When I enter "<prisonNumber>" to search for a prison
    And click on search button
    Then I choose prison from search results
    Then Im on "Manage prison visits - Vsip_prisoner12, Do Not Use" page
    And I check enhanced incentive level for that prisoner
    And I sign out of the service

    Examples:
      | userName  | password          | prisonNumber |
      | VSIP4_TST | DigitalServices10 | A8897DZ      |

  @suite
  Scenario Outline: Category - User check the Category of a Prisoner within an establishment
  # ensure a session restricted by category is only available to prisoners with that category

    Given I navigate to VSIP service
    And Im on "HMPPS Digital Services - Sign in" page
    And I enter "<userName>"
    And I enter the "<password>"
    And click on submit button
    Then Im on "Manage prison visits - Manage prison visits" page
    And I select change establishment
    And I change the establishmnet to Bristol
    And click on continue button
    And I click on Book a visit option
    And Im on "Manage prison visits - Search for a prisoner" page
    When I enter "<prisonNumber>" to search for a prison
    And click on search button
    Then I choose prison from search results
    Then Im on "Manage prison visits - Vsip_prisoner12, Do Not Use" page
    And I check category for that prisoner
    And I sign out of the service

    Examples:
      | userName  | password          | prisonNumber |
      | VSIP4_TST | DigitalServices10 | A8897DZ      |

  @suite
  Scenario Outline: Category - User check the Category of a Prisoner within an establishment
  # ensure a session restricted by category is not available to a prisoner without that category

    Given I navigate to VSIP service
    And Im on "HMPPS Digital Services - Sign in" page
    And I enter "<userName>"
    And I enter the "<password>"
    And click on submit button
    Then Im on "Manage prison visits - Manage prison visits" page
    And I select change establishment
    And I change the establishmnet to Drake Hall
    And click on continue button
    And I click on Book a visit option
    And Im on "Manage prison visits - Search for a prisoner" page
    When I enter "<prisonNumber>" to search for a prison
    And click on search button
    Then I choose prison from search results
    Then Im on "Manage prison visits - Vsip_prisoner14, Do Not Use" page
    And I check Female category for that prisoner
    And I sign out of the service

    Examples:
      | userName  | password          | prisonNumber |
      | VSIP4_TST | DigitalServices10 | A8900DZ      |