package uk.gov.justice.digital.hmpps.vsip.cucumber.steps;

import io.cucumber.java.en.And;
import uk.gov.justice.digital.hmpps.vsip.annotation.LazyAutowired;
import uk.gov.justice.digital.hmpps.vsip.pages.NeedAReviewPage;
import uk.gov.justice.digital.hmpps.vsip.services.DateUtilService;
import uk.gov.justice.digital.hmpps.vsip.services.TestContextService;

public class NeedAReviewSteps {

    @LazyAutowired
    private NeedAReviewPage needAReviewPage;

    @LazyAutowired
    private TestContextService testContextService;

    @LazyAutowired
    private DateUtilService dateUtilService;

    @And("I check the list {string}")
    public void iCheckTheList(String summaryList) {
        needAReviewPage.isSummaryListOptionDisplayed(summaryList);
    }

    @And("I click on view link to see details of the booking needs review")
    public void iClickOnViewLinkToSeeDetailsOfTheBookingNeedsReview() {
        System.out.println("Original Booking Reference: " + testContextService.getBookingReference());
        needAReviewPage.clickOnViewWithRef(testContextService.getBookingReference());
    }

    @And("I see {string} option")
    public void iSeeOption(String msg) {
        needAReviewPage.checkReviewMsg(msg);
    }

    @And("I check to see that there are no notifications for review")
    public void iCheckToSeeIfThereNoNotificationsForReview() {
        needAReviewPage.iCheckToSeeIfThereNoNotificationsForReview();
    }
}
