package uk.gov.justice.digital.hmpps.vsip.cucumber.steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import uk.gov.justice.digital.hmpps.vsip.annotation.LazyAutowired;
import uk.gov.justice.digital.hmpps.vsip.pages.WhatMethodPage;

public class WhatMethodSteps {

    @LazyAutowired
    private WhatMethodPage whatMethodPage;

    //The below method can be written for multiple options Gov.uk,Email,In person
    @And("I select a phone call option on method used to make the reqest")
    public void iSelectAPhoneCallOptionOnMethodUsedToMakeTheReqest() {
        whatMethodPage.selectPhoneCall();
    }

    @And("I select by the prisoner option on method used to make the reqest")
    public void iSelectByThePrisonerOptionOnMethodUsedToMakeTheReqest() {
        whatMethodPage.selectByPrisoner();
    }

    @Then("I see {string} on method used to request page")
    public void iSeeOnMethodUsedToRequestPage(String errMsg) {
        whatMethodPage.checkErrorMsg();
    }

}
