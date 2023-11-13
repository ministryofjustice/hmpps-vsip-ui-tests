Feature: Book a Visit Error messages
  As a user, I should be able to direct to enter correct details to Book a visit using VSIP service
#Error message Scenarios
   @suite
  Scenario Outline: Error message on search page
     Given I navigate to VSIP service
     And Im on "HMPPS Digital Services - Sign in" page
     And I enter "<userName>"
     And I enter the "<password>"
     And click on submit button
     Then Im on "Manage prison visits - Manage prison visits" page
     And I click on Book a visit option
     And Im on "Manage prison visits - Search for a prisoner" page
     And click on search button
     Then I see "You must enter at least 2 characters" on search page
     And I sign out of the service

  Examples:
     | userName                    | password                    |
     | VSIP1_TST                   | Unitedstatesofamerica10     |

   @suite
  Scenario Outline: Error message on select visitors page
     Given I navigate to VSIP service
     And Im on "HMPPS Digital Services - Sign in" page
     And I enter "<userName>"
     And I enter the "<password>"
     And click on submit button
     Then Im on "Manage prison visits - Manage prison visits" page
     And I click on Book a visit option
     And Im on "Manage prison visits - Search for a prisoner" page
     When I enter "<prisonNumber>" to search for a prison
     And click on search button
     Then I choose prison from search results
     Then Im on "Manage prison visits - Vsip_prisoner02, Do Not Use" page
     And I click on Book a visit button
     Then Im on "Manage prison visits - Select visitors from the prisoner’s approved visitor list" page
     And click on continue button
     Then I see "No visitors selected" on select visitors page
     And I sign out of the service

   Examples:
     | userName                    | password                    | prisonNumber  |
     | VSIP1_TST                   | Unitedstatesofamerica10     | A6037DZ       |

   @suite
  Scenario Outline: Error message on time slot page
     Given I navigate to VSIP service
     And Im on "HMPPS Digital Services - Sign in" page
     And I enter "<userName>"
     And I enter the "<password>"
     And click on submit button
     Then Im on "Manage prison visits - Manage prison visits" page
     And I click on Book a visit option
     And Im on "Manage prison visits - Search for a prisoner" page
     When I enter "<prisonNumber>" to search for a prison
     And click on search button
     Then I choose prison from search results
     Then Im on "Manage prison visits - Vsip_prisoner02, Do Not Use" page
     And I click on Book a visit button
     Then Im on "Manage prison visits - Select visitors from the prisoner’s approved visitor list" page
     And I select another visitor form the list
     And click on continue button
     Then Im on "Manage prison visits - Select date and time of visit" page
     And click on continue button
     Then I see "No time slot selected" on select timeslot page
     And I sign out of the service

   Examples:
     | userName                    | password                    | prisonNumber  |
     | VSIP1_TST                   | Unitedstatesofamerica10     | A6037DZ       |

  @suite
  Scenario Outline: Error message on additional support needed page
    Given I navigate to VSIP service
    And Im on "HMPPS Digital Services - Sign in" page
    And I enter "<userName>"
    And I enter the "<password>"
    And click on submit button
    Then Im on "Manage prison visits - Manage prison visits" page
    And I click on Book a visit option
    And Im on "Manage prison visits - Search for a prisoner" page
    When I enter "<prisonNumber>" to search for a prison
    And click on search button
    Then I choose prison from search results
    Then Im on "Manage prison visits - Vsip_prisoner02, Do Not Use" page
    And I click on Book a visit button
    Then Im on "Manage prison visits - Select visitors from the prisoner’s approved visitor list" page
    And I select another visitor form the list
    And click on continue button
    Then Im on "Manage prison visits - Select date and time of visit" page
    And I selecttime slot
    And click on continue button
    Then Im on "Manage prison visits - Is additional support needed for any of the visitors?" page
    And click on continue button
    Then I see "No answer selected" on support needed page
    And I sign out of the service

    Examples:
      | userName                    | password                    | prisonNumber  |
      | VSIP2_TST                   | Unitedstatesofamerica10     | A6037DZ       |

  @suite
  Scenario Outline: Error message on main contact page
    Given I navigate to VSIP service
    And Im on "HMPPS Digital Services - Sign in" page
    And I enter "<userName>"
    And I enter the "<password>"
    And click on submit button
    Then Im on "Manage prison visits - Manage prison visits" page
    And I click on Book a visit option
    And Im on "Manage prison visits - Search for a prisoner" page
    When I enter "<prisonNumber>" to search for a prison
    And click on search button
    Then I choose prison from search results
    Then Im on "Manage prison visits - Vsip_prisoner02, Do Not Use" page
    And I click on Book a visit button
    Then Im on "Manage prison visits - Select visitors from the prisoner’s approved visitor list" page
    And I select another visitor form the list
    And click on continue button
    Then Im on "Manage prison visits - Select date and time of visit" page
    And I select next time slot
    And click on continue button
    Then Im on "Manage prison visits - Is additional support needed for any of the visitors?" page
    And I select No for additional support needed
    And click on continue button
    Then Im on "Manage prison visits - Who is the main contact for this booking?" page
    Then I see "No main contact selected" on select main contact page
    And I select the main contact option
    And click on continue button
    Then I see "Enter a phone number" select main contact page
    And I sign out of the service

    Examples:
      | userName                    | password                    | prisonNumber  |
      | VSIP1_TST                   | Unitedstatesofamerica10     | A6037DZ       |

  @suite
  Scenario Outline: Error message on method used to request page
    Given I navigate to VSIP service
    And Im on "HMPPS Digital Services - Sign in" page
    And I enter "<userName>"
    And I enter the "<password>"
    And click on submit button
    Then Im on "Manage prison visits - Manage prison visits" page
    And I click on Book a visit option
    And Im on "Manage prison visits - Search for a prisoner" page
    When I enter "<prisonNumber>" to search for a prison
    And click on search button
    Then I choose prison from search results
    Then Im on "Manage prison visits - Vsip_prisoner02, Do Not Use" page
    And I click on Book a visit button
    Then Im on "Manage prison visits - Select visitors from the prisoner’s approved visitor list" page
    And I select another visitor form the list
    And click on continue button
    Then Im on "Manage prison visits - Select date and time of visit" page
    And I select a time slot
    And click on continue button
    Then Im on "Manage prison visits - Is additional support needed for any of the visitors?" page
    And I select No for additional support needed
    And click on continue button
    Then Im on "Manage prison visits - Who is the main contact for this booking?" page
    And I select the main contact option
    And I enter "<phoneNumber>" to get text message
    And click on continue button
    Then Im on "Manage prison visits - What method was used to make this request?" page
    And click on continue button
    Then I see "No request method selected" on method used to request page
    And I sign out of the service

    Examples:
      | userName                    | password                    | prisonNumber  |
      | VSIP1_TST                   | Unitedstatesofamerica10     | A6037DZ       |

  @suite
  Scenario Outline: Error message on view Visits by date page
    Given I navigate to VSIP service
    And Im on "HMPPS Digital Services - Sign in" page
    And I enter "<userName>"
    And I enter the "<password>"
    And click on submit button
    Then Im on "Manage prison visits - Manage prison visits" page
    And I click on View visits by date option
    And Im on "Manage prison visits - View visits by date" page
    When I select Date picker option
    Then I click on view button
    Then I see "Enter a valid date" on view visits by date page
    And I sign out of the service

    Examples:
      | userName                    | password                 |
      | VSIP1_TST                   | Unitedstatesofamerica10  |