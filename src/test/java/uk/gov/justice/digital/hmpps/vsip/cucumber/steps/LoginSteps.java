package uk.gov.justice.digital.hmpps.vsip.cucumber.steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import uk.gov.justice.digital.hmpps.vsip.annotation.LazyAutowired;
import uk.gov.justice.digital.hmpps.vsip.pages.LoginPage;
import uk.gov.justice.digital.hmpps.vsip.services.CommonMethodService;

public class LoginSteps {

    @LazyAutowired
    private LoginPage loginPage;

    @LazyAutowired
    private CommonMethodService methodsService;

    @Given("I navigate to VSIP service")
    public void iLoginToTheVipService() {
        loginPage.loginVSIPService();
    }

    @Given("I enter {string}")
    public void iEnterTheUserName(String uName) {
        loginPage.enterUserName(uName);
    }

    @Given("I enter the {string}")
    public void iEnterThePassword(String password) {
        loginPage.enterPassword(password);
    }

    @Given("click on login submit button")
    public void iClickOnLoginSubmitButton() {
        methodsService.clickOnLoginSubmitBtn();
    }

    @Given("I log in with {string} and {string}")
    public void iLogInWithAnd(String userName, String password) {
        iLoginToTheVipService();
        loginPage.isPageTitleDisplayed("HMPPS Digital Services - Sign in");
        iEnterTheUserName(userName);
        iEnterThePassword(password);
        iClickOnLoginSubmitButton();
    }
}