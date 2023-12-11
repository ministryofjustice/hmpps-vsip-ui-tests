package uk.gov.justice.digital.hmpps.vsip.pages;

import org.openqa.selenium.By;
import uk.gov.justice.digital.hmpps.vsip.annotation.ComponentWithWebDriver;

@ComponentWithWebDriver
public class ConfirmationPage extends BasePage {

    public void checkBookingHeading(String confirmationMsg) {
        verifyHeading(confirmationMsg);
    }

    public String getBookingReference() {
        By by = methodsService.getElementByType("class", "test-booking-reference");
        return driver.findElement(by).getText();
    }

}