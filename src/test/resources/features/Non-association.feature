Feature: Non-association visit
  As a user, I shouldn't be able to book a visit using VSIP service for a non-association prisoners
  @suites
  Scenario Outline: Book a visit search via prison number
    Given I navigate to VSIP service
    And Im on "HMPPS Digital Services - Sign in" page
    And I enter "<userName>"
    And I enter the "<password>"
    And click on submit button
    Then Im on "Manage prison visits - Manage prison visits" page
    And I change the establishmnet to Bristol
    And click on continue button
    And I click on Book a visit option
    And Im on "Manage prison visits - Search for a prisoner" page
    When I enter "<prisonNumber>" to search for a prison
    And click on search button
    Then I choose prison from search results
    Then Im on "Manage prison visits - Vsip_prisoner03, Do Not Use" page
    And I click on Book a visit button
    Then Im on "Manage prison visits - Select visitors from the prisoner’s approved visitor list" page
    And I select a visitor form the list from Bristol establishment
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
    And I select a phone call option on method used to make the reqest
    And click on continue button
    Then Im on "Manage prison visits - Check the visit details before booking" page
    And click on continue button
    #And click on submit booking button
    Then Im on "Manage prison visits - Booking confirmed" page
    And I see "Booking confirmed" message displayed

#   NON-ASSOCIATION scenario begins here
    And I click on Manage a Prison option
    Then Im on "Manage prison visits - Manage prison visits" page
    And I click on Book a visit option
    And Im on "Manage prison visits - Search for a prisoner" page
    When I enter "<prisonerName>" to search for a prison
    And click on search button
    Then I choose prison from search results
    Then Im on "Manage prison visits - Vsip_prisoner08, Do Not Use" page
    And I click on Book a visit button
    Then Im on "Manage prison visits - Select visitors from the prisoner’s approved visitor list" page
    And I select a visitor form the list
    And click on continue button
    Then Im on "Manage prison visits - Select date and time of visit" page
    And I shouldn't be able to select a timeslot
    And click on continue button
#    Should be on the same page
    Then Im on "Manage prison visits - Select date and time of visit" page

    #Reverting the Booking for consistent Test execution
    And I click on Manage a Prison option
    Then Im on "Manage prison visits - Manage prison visits" page
    And I click on Book a visit option
    And Im on "Manage prison visits - Search for a prisoner" page
    When I enter "<prisonNumber>" to search for a prison
    And click on search button
    Then I choose prison from search results
    Then Im on "Manage prison visits - Vsip_prisoner03, Do Not Use" page
    And I select latest visit reference
    And I click on Cancel a visit button
    Then Im on "Manage prison visits - Why is this booking being cancelled?" page
    And I select Visitor Cancelled option
    And I select Phone call option
    And I enter cancellation "<reason>" for the visit
    And click on cancel button
    Then Im on "Manage prison visits - Booking cancelled" page
    And I see "Booking cancelled" message displayed

    And I sign out of the service

    Examples:
      | userName                    | password                    | prisonNumber     | prisonerName             | phoneNumber   | reason        |
      | VSIP1_TST                   | Unitedstatesofamerica10     | A6038DZ          | VSIP_PRISONER08          | 07805123900   | Health issues |