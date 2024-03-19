package uk.gov.justice.digital.hmpps.vsip.cucumber.steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import uk.gov.justice.digital.hmpps.vsip.annotation.LazyAutowired;
import uk.gov.justice.digital.hmpps.vsip.pages.ConfirmationPage;
import uk.gov.justice.digital.hmpps.vsip.pages.ViewVisitsByDatePage;
import uk.gov.justice.digital.hmpps.vsip.services.TestContextService;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class ViewVisitsByDateStep {

    @LazyAutowired
    ViewVisitsByDatePage viewVisitsByDatePage;

    @LazyAutowired
    private ConfirmationPage confirmationPage;

    @LazyAutowired
    private TestContextService testContextService;


    @When("I select Date picker option")
    public void iSelectDatePickerOption() {
        viewVisitsByDatePage.selectDatePicker();
    }

    @Then("I click on view button")
    public void iClickOnViewButton() {
        viewVisitsByDatePage.clickOnView();
    }

    @Then("I see tabs changed to the date")
    public void iSeeTabsChangedToTheDate() {
        viewVisitsByDatePage.checkTabsDateChanged();
    }

    @And("I enter {string} to view the visits")
    public void iEnterToViewTheVisits(String date) {
        viewVisitsByDatePage.enterDate(date);
    }

    @Then("I see a visit and click on view option")
    public void iSeeAVisitAndClickOnViewOption() {
        viewVisitsByDatePage.selectViewOption();
    }

    @Then("I see {string} of the visit of that date")
    public void iSeeOfTheVisitOfThatDate(String text) {
        viewVisitsByDatePage.checkTextOnVisit(text);
    }

    @Then("I see {string} on view visits by date page")
    public void iSeeOnViewVisitsByDatePage(String errMsg) {
        viewVisitsByDatePage.checkErrorMessage();
    }

    @And("I capture date the Booking is booked")
    public void iCaptureDateTheBookingIsBooked() {
        //capturing date from booking confirmation page
        String originalDateValue = confirmationPage.getDateBooked();
        System.out.println("Original Date value from confirmation page: " + originalDateValue);

        testContextService.setOriginalDateBookingReference(originalDateValue);
        System.out.println("Original Date Booking Reference: " + testContextService.getOriginalDateBookingReference());

        //formatting the date to pass to API
        DateTimeFormatter originalFormatter = DateTimeFormatter.ofPattern("EEEE d MMMM yyyy");
        // Parse the original date string
        LocalDate originalDate = LocalDate.parse(originalDateValue, originalFormatter);
        // Define the formatter for the desired output format
        DateTimeFormatter outputFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        // Format the date to the desired output format
        String formattedDate = originalDate.format(outputFormatter);
        //set formatted date to use in further Test steps
        testContextService.setDateBookingReference(formattedDate);
    }
    @Then("I enter date to view the visits")
    public void iEnterToViewTheVisits() {
        viewVisitsByDatePage.enterDate(testContextService.getDateBookingReference());
    }

}
