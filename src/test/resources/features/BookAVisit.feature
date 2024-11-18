Feature: Book a Visit
  As a user, I should be able to book a visit using VSIP service

  @suite
  Scenario Outline: Book a visit search via prison number
    Given I log in with "<userName>" and "<password>"
    Then Im on "Manage prison visits - Manage prison visits" page
    And I click on Book a visit option
    And Im on "Manage prison visits - Search for a prisoner" page
    When I enter "<prisonNumber>" to search for a prison
    And click on search button
    Then I choose prisoner from search results
    Then Im on "Manage prison visits - Vsip_prisoner01, Do Not Use" page
    And I click on Book a visit button
    Then Im on "Manage prison visits - Select visitors from the prisoner’s approved visitor list" page
    And "2 people" can visit someone at "Hewell (HMP)" information is displayed on the page
    And I select a visitor form the list
    And click on continue button
    Then Im on "Manage prison visits - Select date and time of visit" page
    And I select time slot
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
      | userName  | password            | prisonNumber |
      | VSIP2_TST | DigitalServices2024 | A6036DZ      |

  @suite
  Scenario: Book a visit capacity is refilled after 10minutes
    Given I log in with "VSIP2_TST" and "DigitalServices2024"
    Then Im on "Manage prison visits - Manage prison visits" page
    And I click on Book a visit option
    And Im on "Manage prison visits - Search for a prisoner" page
    When I enter "A6036DZ" to search for a prison
    And click on search button
    Then I choose prisoner from search results
    Then Im on "Manage prison visits - Vsip_prisoner01, Do Not Use" page
    And I click on Book a visit button
    Then Im on "Manage prison visits - Select visitors from the prisoner’s approved visitor list" page
    And I select a visitor form the list
    And click on continue button
    Then Im on "Manage prison visits - Select date and time of visit" page
    And I capture the initial booking capacity size
    Then I select time slot
    And click on continue button
    And I take note of the hidden application reference
    Then I sign out of the service
    Then I update the last modified time in the database to be "11" minutes in the past
    Then I log in with "VSIP2_TST" and "DigitalServices2024"
    Then Im on "Manage prison visits - Manage prison visits" page
    And I click on Book a visit option
    And Im on "Manage prison visits - Search for a prisoner" page
    When I enter "A6037DZ" to search for a prison
    And click on search button
    Then I choose prisoner from search results
    Then Im on "Manage prison visits - Vsip_prisoner02, Do Not Use" page
    And I click on Book a visit button
    Then Im on "Manage prison visits - Select visitors from the prisoner’s approved visitor list" page
    And I select other prisoner visitor form the list
    And click on continue button
    Then Im on "Manage prison visits - Select date and time of visit" page
    And The available capacity is back to the initial capacity
    And I sign out of the service

  @smoke_tests_vs @suite
  Scenario Outline: Book a visit search via prisoner name
    Given I log in with "<userName>" and "<password>"
    Then Im on "Manage prison visits - Manage prison visits" page
    And I click on Book a visit option
    And Im on "Manage prison visits - Search for a prisoner" page
    When I enter "<prisonerName>" to search for a prison
    And click on search button
    Then I choose prisoner from search results
    Then Im on "Manage prison visits - Vsip_prisoner06, Do Not Use" page
    And I click on Book a visit button
    Then Im on "Manage prison visits - Select visitors from the prisoner’s approved visitor list" page
    And I select a visitor form the lists
    And click on continue button
    Then Im on "Manage prison visits - Select date and time of visit" page
    And I select time slot
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
    # capture Booking date and view
    And I capture date the Booking is booked
    And I click on Manage a Prison option
    And I click on View visits by date option
    And Im on "Manage prison visits - View visits by date" page
    When I select Date picker option
    And I enter date to view the visits
    Then I click on view button
    Then I see a visit and click on view option
    Then I see "Visit booking details" of the visit of that date
    And I sign out of the service

    Examples:
      | userName  | password            | prisonerName    |
      | VSIP2_TST | DigitalServices2024 | VSIP_PRISONER06 |

  @smoke_tests_os @suite @error_messages
  Scenario Outline: Book a visit - Additional support needed
    Given I log in with "<userName>" and "<password>"
    Then Im on "Manage prison visits - Manage prison visits" page
    And I click on Book a visit option
    And Im on "Manage prison visits - Search for a prisoner" page
    When I enter "<prisonerName>" to search for a prison
    And click on search button
    Then I choose prisoner from search results
    Then Im on "Manage prison visits - Vsip_prisoner06, Do Not Use" page
    And I click on Book a visit button
    Then Im on "Manage prison visits - Select visitors from the prisoner’s approved visitor list" page
    And click on continue button
    # checking error message
    Then I see "No visitors selected" on select visitors page
    And I select a visitor form the list for a prisoner
    And click on continue button
    Then Im on "Manage prison visits - Select date and time of visit" page
    And click on continue button
    # checking error message
    And I select time slot
    And click on continue button
    Then Im on "Manage prison visits - Is additional support needed for any of the visitors?" page
    And click on continue button
    # checking error messages
    Then I see "No answer selected" on support needed page
    And I select Yes for additional support needed
    And click on continue button
    Then I see "Enter details of the request" on the additional support page
    And I enter "<incorrectdetails>" for additional support
    And click on continue button
    Then I see "Please enter at least 3 and no more than 512 characters" error message on character length
    And I select No for additional support needed
    And click on continue button
    Then Im on "Manage prison visits - Who is the main contact for this booking?" page
    And click on continue button
    # checking error messages
    Then I see "No main contact selected" on select main contact page
    And I select the main contact option
    And click on continue button
    Then I see "No answer selected" error message on main contact page
    And I choose UK phone number option
    And click on continue button
    Then I see "Enter a phone number" select main contact page
    And I select the main contact option
    And I choose UK phone number option
    And I enter "<phoneNumber>" to get text message
    And click on continue button
    Then Im on "Manage prison visits - How was this booking requested?" page
    And click on continue button
    # checking error message
    Then I see "No request method selected" on method used to request page
    And I select a phone call option on method used to make the request
    And click on continue button
    Then Im on "Manage prison visits - Check the visit details before booking" page
    And click on continue button
    Then Im on "Manage prison visits - Booking confirmed" page
    And I see "Booking confirmed" message displayed
    And I see a booking reference
    And I sign out of the service

    Examples:
      | userName  | password            | prisonerName    | phoneNumber | incorrectdetails |
      | VSIP2_TST | DigitalServices2024 | Vsip_prisoner06 | 07806789076 | w                |

  @ignore
  Scenario Outline: Book a visit - Someone else main contact
    Given I log in with "<userName>" and "<password>"
    Then Im on "Manage prison visits - Manage prison visits" page
    And I click on Book a visit option
    And Im on "Manage prison visits - Search for a prisoner" page
    When I enter "<prisonerName>" to search for a prison
    And click on search button
    Then I choose prisoner from search results
    Then Im on "Manage prison visits - Vsip_prisoner06, Do Not Use" page
    And I click on Book a visit button
    Then Im on "Manage prison visits - Select visitors from the prisoner’s approved visitor list" page
    And I select a visitor form the lists
    And click on continue button
    Then Im on "Manage prison visits - Select date and time of visit" page
    And I select time slot
    And click on continue button
    Then Im on "Manage prison visits - Is additional support needed for any of the visitors?" page
    And I select Yes for additional support needed
    And I enter "<details>" for additional support
    And click on continue button
    Then Im on "Manage prison visits - Who is the main contact for this booking?" page
    And I select the someone else option
    And I enter "<contactName>" in the someone else option
    And I choose UK phone number option
    And I enter "<phoneNumber>" to get text message
    And click on continue button
    Then Im on "Manage prison visits - How was this booking requested?" page
    And I select by the prisoner option on method used to make the reqest
    And click on continue button
    Then Im on "Manage prison visits - Check the visit details before booking" page
    And click on continue button
    Then Im on "Manage prison visits - Booking confirmed" page
    And I see "Booking confirmed" message displayed
    And I see a booking reference
    #Now I cancel the booking
    And I click on Manage a Prison option
    Then Im on "Manage prison visits - Manage prison visits" page
    And I click on Book a visit option
    And Im on "Manage prison visits - Search for a prisoner" page
    When I enter "<prisonNumber>" to search for a prison
    And click on search button
    Then I choose prisoner from search results
    Then Im on "Manage prison visits - Vsip_prisoner06, Do Not Use" page
    And I select last booked visit reference
    And I click on Cancel a visit button
    Then Im on "Manage prison visits - Why is this booking being cancelled?" page
    And I select Visitor Cancelled option
    And I select Phone call option
    And I enter cancellation "<reason>" for the visit
    And click on cancel button
    Then Im on "Manage prison visits - Booking cancelled" page
    And I see "Booking cancelled" message displayed
    # Checking the method used to make this Booking
    And I click on Manage a Prison option
    Then Im on "Manage prison visits - Manage prison visits" page
    And I click on Book a visit option
    And Im on "Manage prison visits - Search for a prisoner" page
    When I enter "<prisonNumber>" to search for a prison
    And click on search button
    Then I choose prisoner from search results
    Then Im on "Manage prison visits - Vsip_prisoner06, Do Not Use" page
    And I select last booked visit reference
    And I see "This visit was cancelled by a visitor." banner
    And I choose Booking history tab
    And I see "Reason: Health issues" reason used to Book a visit
    And I see "Method: Phone booking" used to cancel booking
    And I sign out of the service

    Examples:
      | userName  | password            | prisonerName    | contactName | phoneNumber | reason        | prisonNumber |
      | VSIP2_TST | DigitalServices2024 | VSIP_PRISONER06 | John        | 07806432054 | Health issues | A6539DZ      |

