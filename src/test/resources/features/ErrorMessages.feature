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
     | ANAGULA_GEN                 | Ministryofjustice10         |

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
     Then Im on "Manage prison visits - Benison, Aianilan" page
     And I click on Book a visit button
     Then Im on "Manage prison visits - Select visitors from the prisoner’s approved visitor list" page
     And click on continue button
     Then I see "No visitors selected" on select visitors page
     And I sign out of the service

   Examples:
     | userName                    | password                    | prisonNumber  |
     | ANAGULA_GEN                 | Ministryofjustice10         | G3432VF       |

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
     Then Im on "Manage prison visits - Benison, Aianilan" page
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
     | ANAGULA_GEN                 | Ministryofjustice10         | G3432VF       |