package uk.gov.justice.digital.hmpps.vsip.cucumber.steps;

import io.cucumber.java.en.Given;
import uk.gov.justice.digital.hmpps.vsip.annotation.LazyAutowired;
import uk.gov.justice.digital.hmpps.vsip.pages.LoginPage;

public class LoginSteps {

    @LazyAutowired
    private LoginPage loginPage;

    @Given("I navigate to VSIP service")
    public void i_navigate_to_vsip_service() {
        loginPage.loginVSIPService();
    }

    @Given("I enter {string}")
    public void i_enter(String uName) {
        loginPage.enterUserName(uName);
    }

    @Given("I enter the {string}")
    public void i_enter_the(String password) {
        loginPage.enterPassword(password);
    }
}