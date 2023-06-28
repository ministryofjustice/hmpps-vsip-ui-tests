package stepDefinitions;

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
    public void click_on_submit_button() throws InterruptedException {
        commonPage.clickOnContinueBtn();

    }
    @Then("Im on {string} page")
    public void im_on_vsip_page(String pageTitle) {
        commonMethods.isPageTitleDisplayed(pageTitle);

    }
}