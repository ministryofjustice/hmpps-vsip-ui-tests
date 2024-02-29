package uk.gov.justice.digital.hmpps.vsip.cucumber.steps;

import io.cucumber.java.en.And;
import uk.gov.justice.digital.hmpps.vsip.annotation.LazyAutowired;
import uk.gov.justice.digital.hmpps.vsip.pages.NeedAReviewPage;
import uk.gov.justice.digital.hmpps.vsip.services.TestContextService;

public class NeedAReviewSteps {

    @LazyAutowired
    private NeedAReviewPage needAReviewPage;

    @LazyAutowired
    private TestContextService testContextService;

    @And("I check the list {string}")
    public void iCheckTheList(String summaryList) {
        needAReviewPage.isSummaryListOptionDisplayed(summaryList);
    }

    @And("I click on view link to see details of the booking needs review")
    public void iClickOnViewLinkToSeeDetailsOfTheBookingNeedsReview() {
        needAReviewPage.clickOnView();

    }

    @And("I see {string} option")
    public void iSeeOption(String msg) {
        needAReviewPage.checkReviewMsg(msg);

    }

    @And("I see booking reference is not available")
    public void iSeeBookingReferenceIsNotAvailable() {
        String reference = testContextService.getBookingReference();
        needAReviewPage.checkNoReferenceIsDisplayed(reference);

    }
}
