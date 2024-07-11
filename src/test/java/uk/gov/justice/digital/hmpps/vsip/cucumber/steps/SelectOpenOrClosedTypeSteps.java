package uk.gov.justice.digital.hmpps.vsip.cucumber.steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import uk.gov.justice.digital.hmpps.vsip.annotation.LazyAutowired;
import uk.gov.justice.digital.hmpps.vsip.pages.SelectOpenOrClosedTypePage;
import uk.gov.justice.digital.hmpps.vsip.pages.SelectVisitorsPage;

public class SelectOpenOrClosedTypeSteps {

    @LazyAutowired
    private SelectOpenOrClosedTypePage selectOpenOrClosedTypePage;

    @And("I choose closed type visit")
    public void iChooseClosedTypeVisit() {
        selectOpenOrClosedTypePage.chooseClosedType();
    }

    @And("I choose opened type visit")
    public void iChooseOpenedTypeVisit() {
        selectOpenOrClosedTypePage.chooseOpenedType();
    }

    @Then("I see {string} on select open or closed type page")
    public void iSeeOnSelectOpenOrClosedTypePage(String errorMsg) {
        selectOpenOrClosedTypePage.checkErrormessage();
    }
}
