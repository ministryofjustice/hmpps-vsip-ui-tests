package uk.gov.justice.digital.hmpps.vsip.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import uk.gov.justice.digital.hmpps.vsip.annotation.ComponentWithWebDriver;

@ComponentWithWebDriver
public class OverBookingsPage extends BasePage {
    @FindBy(how = How.ID, using = "confirmOverBooking")
    private WebElement confirmOverBooking;

    public void clickConfirmOverbooking() {
        confirmOverBooking.click();
    }
}

