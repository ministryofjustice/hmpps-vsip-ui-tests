package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import pages.commonPage;
import pages.commonMethods;

/**
 * Created by Anusha Nagula on 15/05/23.
 */
public class CommonSteps {

    pages.commonPage commonPage = new commonPage();
    pages.commonMethods commonMethods = new commonMethods();

    @Given("click on submit button")
    public void i_click_on_submit_button() {
        commonPage.clickOnSubmitBtn();

    }
    @Then("Im on {string} page")
    public void im_on_vsip_page(String pageTitle) {
        commonMethods.isPageTitleDisplayed(pageTitle);

    }
    @Then("click on continue button")
    public void click_on_continue_button() {
        commonPage.clickOnContinueBtn();

    }
    @And("I click on Manage a Prison option")
    public void iClickOnManageAPrisonOption() {
        commonPage.clickOnManagePrisonOptn();

    }
    @And("I sign out of the service")
    public void iSignOutOfTheService() {
        commonPage.clickOnSignOut();
    }

    @Then("I see {string} page")
    public void iSeePage(String errorMsg) {
        commonPage.errorMsgDisplayed(errorMsg);
    }

}
