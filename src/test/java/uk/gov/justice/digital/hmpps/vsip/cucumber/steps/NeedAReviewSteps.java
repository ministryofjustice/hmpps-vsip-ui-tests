package uk.gov.justice.digital.hmpps.vsip.cucumber.steps;

import io.cucumber.java.en.And;
import uk.gov.justice.digital.hmpps.vsip.annotation.LazyAutowired;
import uk.gov.justice.digital.hmpps.vsip.pages.NeedAReviewPage;

public class NeedAReviewSteps {

    @LazyAutowired
    private NeedAReviewPage needAReviewPage;

    @And("I check the list {string}")
    public void iCheckTheList(String summaryList) {
        needAReviewPage.isSummaryListOptionDisplayed(summaryList);
    }
}
