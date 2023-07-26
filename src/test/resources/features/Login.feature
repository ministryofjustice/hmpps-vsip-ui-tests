Feature: Login
As a user, I should be able to login to VSIP service
  @suite
Scenario Outline: Access VSIP homepage
Given I navigate to VSIP service
And Im on "HMPPS Digital Services - Sign in" page
And I enter "<userName>"
And I enter the "<password>"
And click on submit button
Then Im on "Manage prison visits - Manage prison visits" page

  Examples:
  | userName                    | password               |
  | ANAGULA_GEN                 | Ministryofjustice10    |
