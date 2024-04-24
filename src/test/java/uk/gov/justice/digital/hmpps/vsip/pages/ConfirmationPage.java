package uk.gov.justice.digital.hmpps.vsip.pages;

import org.openqa.selenium.By;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import uk.gov.justice.digital.hmpps.vsip.annotation.ComponentWithWebDriver;
import uk.gov.justice.digital.hmpps.vsip.annotation.LazyAutowired;
import uk.gov.justice.digital.hmpps.vsip.services.DateUtilService;

import java.time.LocalDate;

@ComponentWithWebDriver
public class ConfirmationPage extends BasePage {

    private static final Logger LOG = LoggerFactory.getLogger(ConfirmationPage.class);

    @LazyAutowired
    private DateUtilService dateUtilService;

    public void checkBookingHeading(String confirmationMsg) {
        verifyHeading(confirmationMsg);
    }
    public String getBookingReference() {
        By by = methodsService.getElementByType("class", "test-booking-reference");
        return driver.findElement(by).getText();
    }
    public LocalDate getBookingDate() {
        By by = methodsService.getElementByType("class","test-visit-date");
        var strDate = driver.findElement(by).getText();
        LOG.debug("Original Date value from confirmation page: " + strDate);
        return dateUtilService.getBookingDate(strDate);
    }
}
