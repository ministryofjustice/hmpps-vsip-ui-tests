package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import pages.HomePage;
import pages.commonPage;


public class HomeStepDefinitions extends HomePage {

    pages.commonPage commonPage = new commonPage();

    @Then("I click on Book a visit option")
    public void i_click_on_book_a_visit_option() {
        commonPage.clickOnBookAVisitOption();
    }

    @And("I click on Change a visit option")
    public void iClickOnChangeAVisitOption() {
        commonPage.clickOnChangeAVisitOption();
    }

}