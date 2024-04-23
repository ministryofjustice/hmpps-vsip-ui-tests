package uk.gov.justice.digital.hmpps.vsip.cucumber.steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import uk.gov.justice.digital.hmpps.vsip.annotation.LazyAutowired;
import uk.gov.justice.digital.hmpps.vsip.pages.ConfirmationPage;
import uk.gov.justice.digital.hmpps.vsip.services.PrisonVisitsTestingHelperService;
import uk.gov.justice.digital.hmpps.vsip.services.TestContextService;
import java.time.LocalDate;

public class ConfirmationSteps {

    private static final Logger LOG = LoggerFactory.getLogger(ConfirmationSteps.class);

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


}
