package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import pages.HomePage;
import pages.CommonPage;


public class HomeStepDefinitions extends HomePage {

    CommonPage commonPage = new CommonPage();

    @Then("I click on Book a visit option")
    public void i_click_on_book_a_visit_option() {
        commonPage.clickOnBookAVisitOption();
    }

    @And("I click on Change a visit option")
    public void iClickOnChangeAVisitOption() {
        commonPage.clickOnChangeAVisitOption();
    }

    @And("I click on View visits by date option")
    public void iClickOnViewVisitsByDateOption() {
        commonPage.clickOnViewVisitsByDateOption();
    }

}