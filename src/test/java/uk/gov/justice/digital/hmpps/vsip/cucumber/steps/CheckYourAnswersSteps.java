package uk.gov.justice.digital.hmpps.vsip.cucumber.steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import uk.gov.justice.digital.hmpps.vsip.annotation.LazyAutowired;
import uk.gov.justice.digital.hmpps.vsip.pages.CheckYourAnswersPage;

public class CheckYourAnswersSteps {

    @LazyAutowired
    private CheckYourAnswersPage checkYourAnswersPage;

    @Then("I verify additional support details is displayed")
    public void iVerifyAdditionalSupportDetailsIsDisplayed() {
        checkYourAnswersPage.verifyDetailsDisplayed();
    }
}
