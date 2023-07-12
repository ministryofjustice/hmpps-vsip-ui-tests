Feature: Book a Visit
  As a user, I should be able to book a visit using VSIP service

  Scenario Outline: Book a visit search via prison number
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
    Then Im on "Manage prison visits - Johnustine, Aichisa" page
    And I click on Book a visit button
    Then Im on "Manage prison visits - Select visitors from the prisoner’s approved visitor list" page
    And I select a visitor form the list
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
    Then Im on "Manage prison visits - Check the visit details before booking" page
    And click on submit booking button
    Then Im on "Manage prison visits - Booking confirmed" page
    And I see "Booking confirmed" message displayed

    Examples:
      | userName                    | password               | prisonNumber     | phoneNumber   |
      | ANAGULA_GEN                 | Mounteverest10         | G6570GW          | 07805123900   |

  Scenario Outline: Book a visit search via prisoner name
    Given I navigate to VSIP service
    And Im on "HMPPS Digital Services - Sign in" page
    And I enter "<userName>"
    And I enter the "<password>"
    And click on submit button
    Then Im on "Manage prison visits - Manage prison visits" page
    And I click on Book a visit option
    And Im on "Manage prison visits - Search for a prisoner" page
    When I enter "<prisonerName>" to search for a prison
    And click on search button
    Then I choose prison from search results
    Then Im on "Manage prison visits - Joannamin, Dizfmonios" page
    And I click on Book a visit button
    Then Im on "Manage prison visits - Select visitors from the prisoner’s approved visitor list" page
    And I select a visitor form the list
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
    Then Im on "Manage prison visits - Check the visit details before booking" page
    And click on submit booking button
    Then Im on "Manage prison visits - Booking confirmed" page
    And I see "Booking confirmed" message displayed

    Examples:
      | userName                    | password               | prisonerName     | phoneNumber   |
      | ANAGULA_GEN                 | Mounteverest10         | Jo               | 07805123900   |

  Scenario Outline: Book a visit - Additional support needed
    Given I navigate to VSIP service
    And Im on "HMPPS Digital Services - Sign in" page
    And I enter "<userName>"
    And I enter the "<password>"
    And click on submit button
    Then Im on "Manage prison visits - Manage prison visits" page
    And I click on Book a visit option
    And Im on "Manage prison visits - Search for a prisoner" page
    When I enter "<prisonerName>" to search for a prison
    And click on search button
    Then I choose prison from search results
    Then Im on "Manage prison visits - Johnustine, Aichisa" page
    And I click on Book a visit button
    Then Im on "Manage prison visits - Select visitors from the prisoner’s approved visitor list" page
    And I select a visitor form the list
    And click on continue button
    Then Im on "Manage prison visits - Select date and time of visit" page
    And I select a time slot
    And click on continue button
    Then Im on "Manage prison visits - Is additional support needed for any of the visitors?" page
    And I select Yes for additional support needed
    And I choose an option of disability
    And I choose other option additionally
    And I enter "<disability>" in the section
    And click on continue button
    Then Im on "Manage prison visits - Who is the main contact for this booking?" page
    And I select the main contact option
    And I enter "<phoneNumber>" to get text message
    And click on continue button
    Then Im on "Manage prison visits - Check the visit details before booking" page
    And click on submit booking button
    Then Im on "Manage prison visits - Booking confirmed" page
    And I see "Booking confirmed" message displayed

    Examples:
      | userName                    | password               | prisonerName     | disability           | phoneNumber   |
      | ANAGULA_GEN                 | Mounteverest10         | John             | hearing support      | 07806789076   |

  Scenario Outline: Book a visit - Someone else main contact
    Given I navigate to VSIP service
    And Im on "HMPPS Digital Services - Sign in" page
    And I enter "<userName>"
    And I enter the "<password>"
    And click on submit button
    Then Im on "Manage prison visits - Manage prison visits" page
    And I click on Book a visit option
    And Im on "Manage prison visits - Search for a prisoner" page
    When I enter "<prisonerName>" to search for a prison
    And click on search button
    Then I choose prison from search results
    Then Im on "Manage prison visits - Johnustine, Aichisa" page
    And I click on Book a visit button
    Then Im on "Manage prison visits - Select visitors from the prisoner’s approved visitor list" page
    And I select a visitor form the list
    And click on continue button
    Then Im on "Manage prison visits - Select date and time of visit" page
    And I select next time slot
    And click on continue button
    Then Im on "Manage prison visits - Is additional support needed for any of the visitors?" page
    And I select Yes for additional support needed
    And I choose an option of disability
    And I choose other option additionally
    And I enter "<disability>" in the section
    And click on continue button
    Then Im on "Manage prison visits - Who is the main contact for this booking?" page
    And I select the someone else option
    And I enter "<contactName>" in the someone else option
    And I enter "<phoneNumber>" to get text message
    And click on continue button
    Then Im on "Manage prison visits - Check the visit details before booking" page
    And click on submit booking button
    Then Im on "Manage prison visits - Booking confirmed" page
    And I see "Booking confirmed" message displayed

    Examples:
      | userName                    | password               | prisonerName     | disability           | contactName | phoneNumber  |
      | ANAGULA_GEN                 | Mounteverest10         | John             | hearing support      | John        | 07806432054  |