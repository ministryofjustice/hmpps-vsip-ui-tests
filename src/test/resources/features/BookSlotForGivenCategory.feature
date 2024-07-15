Feature: Login
  As a user, I should be able to book a slot with the correct category

  Scenario Outline: Book a opened slot for given category that matches prisoners category
    Given I navigate to VSIP service
    And I want to setup a opened session for "<prison>" for two days time at 9am to 11am for prisoner category of "<category>"
    Given I log in with "<userName>" and "<password>"
    Then Im on "Manage prison visits - Manage prison visits" page
    And I select change establishment
    And I change the establishment to Drake Hall
    And click on continue button
    And I click on Book a visit option
    And Im on "Manage prison visits - Search for a prisoner" page
    When I enter "<prisonNumber>" to search for a prison
    And click on search button
    Then I choose prisoner from search results
    Then Im on "Manage prison visits - Vsip_prisoner14, Do Not Use" page
    And I check Female category for that prisoner
    And I click on Book a visit button
    Then Im on "Manage prison visits - Select visitors from the prisoner’s approved visitor list" page
    And I select a visitor form the list from Drake hall establishment
    And click on continue button
    Then Im on "Manage prison visits - Select date and time of visit" page
    And I select a slot in two days time at 9am to 11am
    And click on continue button
    Then Im on "Manage prison visits - Is additional support needed for any of the visitors?" page
    And I select No for additional support needed
    And click on continue button
    Then Im on "Manage prison visits - Who is the main contact for this booking?" page
    And I select the main contact option
    And I choose No phone number provided option
    And click on continue button
    Then Im on "Manage prison visits - How was this booking requested?" page
    And I select a phone call option on method used to make the request
    And click on continue button
    Then Im on "Manage prison visits - Check the visit details before booking" page
    And click on continue button
    Then Im on "Manage prison visits - Booking confirmed" page
    And I see "Booking confirmed" message displayed
    And I see a booking reference
    And I sign out of the service

    Examples:
      | userName  | password          | prison | prisonNumber | category      |
      | VSIP4_TST | DigitalServices12 | DHI    | A8900DZ      | FEMALE_CLOSED |

  Scenario Outline: When a prisoner is not in given category then we cannot book
    Given I navigate to VSIP service
    And I want to setup a opened session for "<prison>" for two days time at 9am to 11am for prisoner location of "<category>"
    Given I log in with "<userName>" and "<password>"
    Then Im on "Manage prison visits - Manage prison visits" page
    And I select change establishment
    And I change the establishment to Drake Hall
    And click on continue button
    And I click on Book a visit option
    And Im on "Manage prison visits - Search for a prisoner" page
    When I enter "<prisonNumber>" to search for a prison
    And click on search button
    Then I choose prisoner from search results
    Then Im on "Manage prison visits - Vsip_prisoner14, Do Not Use" page
    And I check Female category for that prisoner
    And I click on Book a visit button
    Then Im on "Manage prison visits - Select visitors from the prisoner’s approved visitor list" page
    And I select a visitor form the list from Drake hall establishment
    And click on continue button
    Then Im on "Manage prison visits - Select date and time of visit" page
    And I cant select a slot in two days time at 9am to 11am
    And I sign out of the service

    Examples:
      | userName  | password          | prison | prisonNumber | category |
      | VSIP4_TST | DigitalServices12 | DHI    | A8900DZ      | A_HIGH   |