package uk.gov.justice.digital.hmpps.vsip.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import uk.gov.justice.digital.hmpps.vsip.annotation.ComponentWithWebDriver;
import uk.gov.justice.digital.hmpps.vsip.util.Context;

import java.util.ArrayList;
import java.util.List;

@ComponentWithWebDriver
public class SelectTimeSlotPage extends BasePage {


    public void selectTimeslotErrorDisplayed() {
        methodsService.isElementDisplayed("xpath", "//a[text() = 'No time slot selected']");
    }

    public void selectNonAssTimeSlot() {
        final int inputIndex = 1;
        methodsService.click("xpath", "//button[contains(@class, 'govuk-accordion__show-all')]");
        WebElement radioButton = methodsService.selectRadioButton("xpath", "//*[@id='" + inputIndex + "']");
        final String slotDetails = radioButton.getAttribute("data-test");
        if (slotDetails != null) {
            testContextService.setToContext(Context.SLOT_DATE_TIME, slotDetails);
        } else {
            System.err.println("Error data-test not found on element time slot RadioButton!");
        }
    }


    public void selectLastBookedSlot() {
        methodsService.selectRadioButton("xpath", getDataTestXPathForTimeSlot());
    }


    public void noTimeslotAvailable() {
        methodsService.isElementNotVisible("xpath", "//*[@id='5']");
    }

    public void lastBookedTimeSlotNotAvailable() {
        methodsService.isElementAvailable("xpath", getDataTestXPathForTimeSlot());
    }

    private String getDataTestXPathForTimeSlot() {
        return "//*[@data-test='" + testContextService.getTimeSlotDay() + "']";
    }

    public void clickNextEnabledElement() {
        methodsService.click("xpath", "//button[contains(@class, 'govuk-accordion__show-all')]");

        // List of different XPaths for time slots elements
        List<String> xpaths = new ArrayList<>();
        xpaths.add("//*[@id='1']");
        xpaths.add("//*[@id='2']");
        xpaths.add("//*[@id='3']");
        xpaths.add("//*[@id='4']");
        xpaths.add("//*[@id='5']");
        xpaths.add("//*[@id='6']");
        xpaths.add("//*[@id='7']");
        xpaths.add("//*[@id='8']");
        xpaths.add("//*[@id='9']");
        xpaths.add("//*[@id='10']");

        // Iterate through the XPaths
        for (String xpath : xpaths) {
            // Find elements using the current XPath
            List<WebElement> elements = driver.findElements(By.xpath(xpath));

            // Iterate through the elements to find the first enabled one
            for (WebElement element : elements) {
                if (element.isEnabled()) {
                    // Click the first enabled element
                    element.click();
                    return; // Exit the method once the first enabled element is clicked
                }
            }
        }
    }
}