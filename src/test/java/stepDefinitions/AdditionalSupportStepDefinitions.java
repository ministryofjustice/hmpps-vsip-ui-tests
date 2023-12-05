package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import pages.AdditionalSupportPage;
import pages.CommonPage;

public class AdditionalSupportStepDefinitions extends AdditionalSupportPage {

    CommonPage commonPage = new CommonPage();

    @Then("I select No for additional support needed")
    public void i_select_no_for_additional_support_needed() {
        selectNoForAddAssistance();
    }

    @And("I select Yes for additional support needed")
    public void iSelectYesForAdditionalSupportNeeded() {
        selectYesForAddAssistance();
    }

    @And("I choose an option of disability")
    public void iChooseAnOptionOfDisability() {
        checkDisabilityOption();
    }

    @And("I choose other option additionally")
    public void iChooseOtherOptionAdditionally() {
        checkOtherDisabilityOption();
    }

    @And("I enter {string} in the section")
    public void iEnterInTheSection(String disability) {
        enterDisability(disability);
    }

    @Then("I see {string} on support needed page")
    public void iSeeOnSupportNeededPage(String errorMsg) {
        selectAdditionalSupprtOptErrorDisplayed();
    }
}