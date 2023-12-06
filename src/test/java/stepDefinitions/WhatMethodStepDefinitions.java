package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import pages.WhatMethodPage;
import pages.CommonPage;

public class WhatMethodStepDefinitions extends WhatMethodPage {
    CommonPage commonPage = new CommonPage();
    //The below method can be written for multiple options Gov.uk,Email,In person
    @And("I select a phone call option on method used to make the reqest")
    public void iSelectAPhoneCallOptionOnMethodUsedToMakeTheReqest() {
        selectPhoneCall();
    }

    @And("I select by the prisoner option on method used to make the reqest")
    public void iSelectByThePrisonerOptionOnMethodUsedToMakeTheReqest() {
        selectByPrisoner();
    }

    @Then("I see {string} on method used to request page")
    public void iSeeOnMethodUsedToRequestPage(String errMsg) {
        checkErrorMsg();
    }

}
