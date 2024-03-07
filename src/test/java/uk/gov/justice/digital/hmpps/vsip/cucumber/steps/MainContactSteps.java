package uk.gov.justice.digital.hmpps.vsip.cucumber.steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import uk.gov.justice.digital.hmpps.vsip.annotation.LazyAutowired;
import uk.gov.justice.digital.hmpps.vsip.pages.MainContactPage;

public class MainContactSteps {

    @LazyAutowired
    private MainContactPage mainContactPage;

    @Then("I select the main contact option")
    public void i_select_the_main_contact_option() {
        mainContactPage.selectMainContact();
    }

    @And("I enter {string} to get text message")
    public void iEnterToGetTextMessage(String phoneNo) {
        mainContactPage.enterPhoneNo(phoneNo);
    }

    @And("I select the someone else option")
    public void iSelectTheSomeoneElseOption() {
        mainContactPage.selectSomeOneElse();
    }

    @And("I enter {string} in the someone else option")
    public void iEnterInTheSomeoneElseOption(String contactName) {
        mainContactPage.enterContactName(contactName);
    }

    @Then("I see {string} on select main contact page")
    public void iSeeOnSelectMainContactPage(String errorMg) {
        mainContactPage.selectMainConErrorDisplayed();
    }

    @Then("I see {string} select main contact page")
    public void iSeeSelectMainContactPage(String errMsg) {
        mainContactPage.checkPhoneNoErrorMsg();
    }

    @And("I choose UK phone number option")
    public void iChooseUKPhoneNumberOption() {
        mainContactPage.chooseUKPhoneNoOption();
    }

    @And("I choose No phone number provided option")
    public void iChooseNoPhoneNumberProvidedOption() {
        mainContactPage.chooseNoPhoneNoOption();
    }

    @Then("I see {string} error message on main contact page")
    public void iSeeErrorMessageOnMainContactPage(String errMsg) {
        mainContactPage.checkNoAnswerErrorMsg();
    }

    @Then("I see {string} error message displayed")
    public void iSeeErrorMessageDisplayed(String nameErrorMessage) {
        mainContactPage.checkNameOfMainContactErrorMsg();
    }
}