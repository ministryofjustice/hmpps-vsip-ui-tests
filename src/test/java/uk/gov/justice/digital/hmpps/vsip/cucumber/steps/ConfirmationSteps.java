package uk.gov.justice.digital.hmpps.vsip.cucumber.steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import uk.gov.justice.digital.hmpps.vsip.annotation.LazyAutowired;
import uk.gov.justice.digital.hmpps.vsip.pages.ConfirmationPage;
import uk.gov.justice.digital.hmpps.vsip.services.PrisonVisitsTestingHelperService;
import uk.gov.justice.digital.hmpps.vsip.services.TestContextService;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class ConfirmationSteps {

    @LazyAutowired
    private ConfirmationPage confirmationPage;

    @LazyAutowired
    private TestContextService testContextService;

    @LazyAutowired
    private PrisonVisitsTestingHelperService testHelper;

    @And("I see {string} message displayed")
    public void iSeeMessageDisplayed(String confirmationMsg) {
        confirmationPage.checkBookingHeading(confirmationMsg);
    }

    @And("I see a booking reference")
    public void iSeeABookingReferenceDisplayed() {
        String bookingReference = confirmationPage.getBookingReference();
        testContextService.setBookingReference(bookingReference);
    }
    @Given("A booking reference date is excluded")
    public void aBookingDateIsExcluded() {
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
        DateTimeFormatter outputFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        // Format the date to the desired output format
        String formattedDate = originalDate.format(outputFormatter);
        //set formatted date to use in further Test steps
        testContextService.setDateBookingReference(formattedDate);
        //API call
        testHelper.addVisitExcludeDateEvent("HEI",formattedDate);

        // Parse the original date string
        LocalDate original_DateValue = LocalDate.parse(originalDateValue, DateTimeFormatter.ofPattern("EEEE d MMMM yyyy"));

        // Format the date to the desired output format
        String truncatedDateValue = originalDate.format(DateTimeFormatter.ofPattern("d MMMM yyyy"));

        // Print the result
        System.out.println("Original Date value: " + originalDateValue);
        System.out.println("Truncated Date value: " + truncatedDateValue);
        testContextService.setOriginalDateBookingReference(truncatedDateValue);
     }
}
