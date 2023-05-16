Feature: Login
As a user, I should be able to login to VSIP service

Scenario Outline: Access VSIP homepage
Given I navigate to "https://manage-prison-visits-staging.prison.service.justice.gov.uk/"
And I enter "<userName>"
And I enter "<password>" and click on submit button
Then I see VSIP homepage

  Examples:
  |userName       | password               |
  |               |                        |
