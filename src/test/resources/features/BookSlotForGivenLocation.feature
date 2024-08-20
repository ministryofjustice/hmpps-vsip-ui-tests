Feature: Login
  As a user, I should be able to book a slot

  @suite
  Scenario Outline: Book a opened slot for given cell location
    Given I navigate to VSIP service
    And I want to setup a opened session for "<prison>" for two days time at 9am to 11am for prisoner location of "<location>"
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
    Then Im on "Manage prison visits - Vsip_prisoner11, Do Not Use" page
    And I check Prisoner location "I-1-003, Drake Hall (HMP & YOI)"
    And I click on Book a visit button
    Then Im on "Manage prison visits - Select visitors from the prisoner’s approved visitor list" page
    And I select a visitor form the list from Drake hall establishment
    And click on continue button
    Then Im on "Manage prison visits - Check the prisoner&#39;s closed visit restrictions" page
    And I choose opened type visit
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
      | userName  | password          | prison       | prisonNumber | location  |
      | VSIP4_TST | DigitalServices12 | DHI          | A8899DZ      | I-1-003   |

  @suite
  Scenario Outline: Book a closed slot for given cell location
    Given I navigate to VSIP service
    And I want to setup a closed session for "<prison>" for two days time at 9am to 11am for prisoner location of "<location>"
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
    Then Im on "Manage prison visits - Vsip_prisoner11, Do Not Use" page
    And I check Prisoner location "I-1-003, Drake Hall (HMP & YOI)"
    And I click on Book a visit button
    Then Im on "Manage prison visits - Select visitors from the prisoner’s approved visitor list" page
    And I select a visitor form the list from Drake hall establishment
    And click on continue button
    Then Im on "Manage prison visits - Check the prisoner&#39;s closed visit restrictions" page
    And I choose closed type visit
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
      | userName  | password          | prison       | prisonNumber | location  |
      | VSIP4_TST | DigitalServices12 | DHI          | A8899DZ      | I-1-003   |

  @suite
  Scenario Outline: When a prisoner is not at given location then we cannot book
    Given I navigate to VSIP service
    And I want to setup a opened session for "<prison>" for two days time at 9am to 11am for prisoner location of "<location>"
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
    Then Im on "Manage prison visits - Vsip_prisoner11, Do Not Use" page
    And I check Prisoner location "I-1-003, Drake Hall (HMP & YOI)"
    And I click on Book a visit button
    Then Im on "Manage prison visits - Select visitors from the prisoner’s approved visitor list" page
    And I select a visitor form the list from Drake hall establishment
    And click on continue button
    Then Im on "Manage prison visits - Check the prisoner&#39;s closed visit restrictions" page
    And I choose opened type visit
    And click on continue button
    Then Im on "Manage prison visits - Select date and time of visit" page
    And I cant select a slot in two days time at 9am to 11am
    And I sign out of the service

    Examples:
      | userName  | password          | prison       | prisonNumber | location      |
      | VSIP4_TST | DigitalServices12 | DHI          | A8899DZ      | IM-NOT-HERE   |