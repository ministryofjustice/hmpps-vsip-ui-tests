package uk.gov.justice.digital.hmpps.vsip.cucumber.steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import uk.gov.justice.digital.hmpps.vsip.annotation.LazyAutowired;
import uk.gov.justice.digital.hmpps.vsip.pages.BlockVisitDatePage;

public class BlockVisitDateSteps {
    @LazyAutowired
    private BlockVisitDatePage blockVisitDatePage;

    @And("I enter a {string} to block the visit")
    public void iEnterAToBlockTheVisit(String dateinString) {
        blockVisitDatePage.enterDateToBlock(dateinString);
    }

    @And("I confirm the date to block")
    public void iConfirmTheDateToBlock() {
        blockVisitDatePage.clickConfirmBlockDate();
    }

    @And("the page has the confirmation message {string}")
    public void thePageTheConfirmationMessage(String confirmationMessage) {
        blockVisitDatePage.getConfirmationMessage(confirmationMessage);
    }

    @And("I unblock an existing blocked visit date")
    public void iUnblockAnExistingBlockedVisitDate()  {
        blockVisitDatePage.clickOnUnblockBtn();
    }

    @Then("I get an error message {string}")
    public void iGetAnErrorMessage(String errorMessage) {
        blockVisitDatePage.alreadyBlockedErrorMessage(errorMessage);
    }
}
