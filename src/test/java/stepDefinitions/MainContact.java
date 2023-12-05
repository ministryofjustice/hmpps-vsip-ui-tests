package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import pages.MainContactPage;
import pages.CommonPage;

public class MainContact extends MainContactPage {

    CommonPage commonPage = new CommonPage();

    @Then("I select the main contact option")
    public void i_select_the_main_contact_option() {
        selectMainContact();
    }
    @And("I enter {string} to get text message")
    public void iEnterToGetTextMessage(String phoneNo) {
        enterPhoneNo(phoneNo);
    }

    @And("I select the someone else option")
    public void iSelectTheSomeoneElseOption() {
        selectSomeOneElse();
    }

    @And("I enter {string} in the someone else option")
    public void iEnterInTheSomeoneElseOption(String contactName) {
        enterContactName(contactName);
    }

    @Then("I see {string} on select main contact page")
    public void iSeeOnSelectMainContactPage(String errorMg) {
        selectMainConErrorDisplayed();
    }

    @Then("I see {string} select main contact page")
    public void iSeeSelectMainContactPage(String errMsg) {
        checkPhoneNoErrorMsg();
    }
}