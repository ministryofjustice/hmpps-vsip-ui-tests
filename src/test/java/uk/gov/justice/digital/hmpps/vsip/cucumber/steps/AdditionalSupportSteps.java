package uk.gov.justice.digital.hmpps.vsip.cucumber.steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import uk.gov.justice.digital.hmpps.vsip.annotation.LazyAutowired;
import uk.gov.justice.digital.hmpps.vsip.pages.AdditionalSupportPage;


public class AdditionalSupportSteps {

    @LazyAutowired
    private AdditionalSupportPage additionalSupportPage;

    @Then("I select No for additional support needed")
    public void i_select_no_for_additional_support_needed() {
        additionalSupportPage.selectNoForAddAssistance();
    }

    @And("I select Yes for additional support needed")
    public void iSelectYesForAdditionalSupportNeeded() {
        additionalSupportPage.selectYesForAddAssistance();
    }

    @And("I choose an option of disability")
    public void iChooseAnOptionOfDisability() {
        additionalSupportPage.checkDisabilityOption();
    }

    @And("I choose other option additionally")
    public void iChooseOtherOptionAdditionally() {
        additionalSupportPage.checkOtherDisabilityOption();
    }

    @And("I enter {string} in the section")
    public void iEnterInTheSection(String disability) {
        additionalSupportPage.enterDisability(disability);
    }

    @Then("I see {string} on support needed page")
    public void iSeeOnSupportNeededPage(String errorMsg) {
        additionalSupportPage.selectAdditionalSupportOptErrorDisplayed();
    }

    @And("I enter {string} for additional support")
    public void iEnterForAdditionalSupport(String details) {
        additionalSupportPage.enterDetails(details);
    }

    @Then("I see {string} on the additional support page")
    public void iSeeOnTheAdditionalSupportPage(String errMessage) {
        additionalSupportPage.checkErrorMessageDisplayed();
    }

    @Then("I see {string} error message on character length")
    public void iSeeErrorMessageOnCharacterLength(String characterLengthErrMsg) {
        additionalSupportPage.checkCharacterLengthErrMsg();
    }
}