package uk.gov.justice.digital.hmpps.vsip.cucumber.steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import uk.gov.justice.digital.hmpps.vsip.annotation.LazyAutowired;
import uk.gov.justice.digital.hmpps.vsip.pages.BasePage;
import uk.gov.justice.digital.hmpps.vsip.services.CommonMethodService;
import uk.gov.justice.digital.hmpps.vsip.services.PrisonVisitsTestingHelperService;

/**
 * Created by Anusha Nagula on 15/05/23.
 */
public class CommonSteps {

    @LazyAutowired
    private BasePage basePage;

    @LazyAutowired
    private CommonMethodService methodsService;

    @LazyAutowired
    private PrisonVisitsTestingHelperService testHelper;

    @Given("click on submit button")
    public void i_click_on_submit_button() {
        methodsService.clickOnSubmitBtn();
    }

    @Then("Im on {string} page")
    public void im_on_vsip_page(String pageTitle) {
        basePage.isPageTitleDisplayed(pageTitle);
    }

    @Then("click on continue button")
    public void click_on_continue_button() {
        methodsService.clickOnContinueBtn();
    }

    @And("I click on Manage a Prison option")
    public void iClickOnManageAPrisonOption() {
        methodsService.clickOnManagePrisonOption();
    }

    @And("I sign out of the service")
    public void iSignOutOfTheService() {
        methodsService.clickOnSignOut();
    }

    @Then("I see {string} page")
    public void iSeePage(String errorMsg) {
        methodsService.errorMsgDisplayed(errorMsg);
    }

    @And("I change the establishment to Bristol")
    public void iChangeTheEstablishmentToBristol() {
        methodsService.chooseBristol();
    }

    @And("I change the establishmnet to Drake Hall")
    public void iChangeTheEstablishmnetToDrakeHall() {
        methodsService.chooseDrakeHall();
    }

    @And("I should not be able to select Bristol establishment")
    public void iShouldNotBeAbleToSelectBristolEstablishment() {
        methodsService.chooseNoBristol();
    }

    @And("I select change establishment")
    public void iSelectChangeEstablishment() {
        methodsService.changeEstablishment();
    }

}
