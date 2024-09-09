package uk.gov.justice.digital.hmpps.vsip.pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import uk.gov.justice.digital.hmpps.vsip.annotation.ComponentWithWebDriver;
import uk.gov.justice.digital.hmpps.vsip.annotation.LazyAutowired;
import uk.gov.justice.digital.hmpps.vsip.services.Context;
import uk.gov.justice.digital.hmpps.vsip.services.PrisonVisitsTestingHelperService;

import java.time.LocalDate;
import java.util.List;

@ComponentWithWebDriver
public class SelectTimeSlotPage extends BasePage {

    @FindBy(how = How.XPATH, using = "//*[@data-test='visit-restriction']")
    private WebElement visitRestriction;

    @LazyAutowired
    private PrisonVisitsTestingHelperService testHelper;

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
        selectBookedSlot(getDataTestXPathForTimeSlot());
    }

    public void selectBookedSlot(String xpath) {
        methodsService.selectRadioButton("xpath", xpath);
    }

    public void noTimeslotAvailable() {
        methodsService.isElementNotVisible("xpath", "//*[@id='5']");
    }

    public void lastBookedTimeSlotNotAvailable() {
        methodsService.isElementAvailable("xpath", getDataTestXPathForTimeSlot());
    }

    private String getDataTestXPathForTimeSlot() {
        return getDataTestXPathForTimeSlot(testContextService.getTimeSlotDay());
    }
    private String getDataTestXPathForTimeSlot(String value) {
        return "//*[@data-test='" + value+ "']";
    }

    public String getBookingCapacity() {
        return "//*[contains(@id,’content-1’)]/div/div[1]/div/div/div/label/p/text()";
    }

    public void clickNextEnabledElement() {
        List<WebElement> allSections = driver.findElements(By.xpath("//span[text()='Show all sections']"));
        for (WebElement element : allSections) {
            element.click();
        }

        // List of different XPaths for time slots elements
        int numberOfElements = 30;  // or any other number of elements you have
        for (int i = 1; i <= numberOfElements; i++) {
            String xpath = "//*[@id='" + i + "']";

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

    public void checkOnlyOpenTimeSlots() {
        final String visitRestriction = this.visitRestriction.getText();
        Assert.assertEquals("Restriction should be Open not Closed","Open", visitRestriction);
        methodsService.isElementDisplayed("xpath","//p[contains(text(), 'tables available')]");
    }
    public void checkOnlyClosedTimeslotsAvailable() {
        final String visitRestriction = this.visitRestriction.getText();
        Assert.assertEquals("Restriction should be Closed not Open","Closed", visitRestriction);
        methodsService.isElementDisplayed("xpath","//p[contains(text(), 'tables available')]");
    }


    public void checkOnlyEnhancedTimeSlotsAvailable() {
        methodsService.isElementDisplayed("xpath","//p[contains(text(), '200 tables available')]");
    }

    public void checkNoStandardTimeslotsAvailable() {
        methodsService.isElementNotDisplayed("xpath","//p[not(contains(text(), '300 tables available'))]");
    }

    public void checkOnlyStandardTimeslotsAvailable() {
        methodsService.isElementDisplayed("xpath","//p[contains(text(), '300 tables available')]");
    }

    public void checkNoEnhancedTimeslotsAvailable() {
        methodsService.isElementNotDisplayed("xpath","//p[not(contains(text(), '200 tables available'))]");
    }

    public void checkOnlyThisLocationTimeslotsAvailable() {
        methodsService.isElementDisplayed("xpath","//p[contains(text(), '190 tables available')]");
    }


    public void showAllSlotsDates() {
        List<WebElement> allSections = driver.findElements(By.xpath("//span[text()='Show all sections']"));
        for (WebElement element : allSections) {
            element.click();
        }
    }

    public void iSelectASlotInTwoDaysTimeAt9amTo11am() {
        showAllSlotsDates();

        String dataTestValue = testHelper.getSlotDataTestValue(LocalDate.now().plusDays(2), 9, 11);
        methodsService.click("xpath", getDataTestXPathForTimeSlot(dataTestValue));
    }

    public void iCannotSelectASlotInTwoDaysTimeAt9amTo11am() {
        showAllSlotsDates();

        String dataTestValue = testHelper.getSlotDataTestValue(LocalDate.now().plusDays(2),9,11);
        var isElementDisplayed = methodsService.isElementPresent("xpath", getDataTestXPathForTimeSlot(dataTestValue));
        Assert.assertFalse(isElementDisplayed);
    }

    public void checkOtherLocationTimeSlotsNotAvailble() {
        methodsService.isElementNotDisplayed("xpath","//p[not(contains(text(), '315 tables available'))]");
    }

    public void checkTimeSlotsAvailableForThisLocation() {
        methodsService.isElementDisplayed("xpath","//p[contains(text(), '315 tables available')]");
    }

    public void checkNoOtherLocationTimeslotsAvailable() {
        methodsService.isElementNotDisplayed("xpath","//p[not(contains(text(), '450 tables available'))]");
    }



    public void checkNoOpenTimeSlotsAvailabe() {
        methodsService.isElementNotDisplayed("xpath","//p[not(contains(text(), '250 tables available'))]");
    }

    public void checkOnlyCatCTimeslotsAvailable() {
        methodsService.isElementDisplayed("xpath","//p[contains(text(), '150 tables available')]");
    }

    public void checkNoOtherCategoryTimeSlotsAvailable() {
        methodsService.isElementNotDisplayed("xpath","//p[not(contains(text(), '550 tables available'))]");
    }

    public void checkOnlyCatBTimeslotsAvailable() {
        methodsService.isElementDisplayed("xpath","//p[contains(text(), '550 tables available')]");
    }

    public void checkNoOthrCategoryTimeslotsAvailable() {
        methodsService.isElementNotDisplayed("xpath","//p[not(contains(text(), '150 tables available'))]");
    }

    public void checkAMessageDisplayed() {
        methodsService.isElementDisabled("xpath","//span[text()='A new visit time should be selected as the date is no longer available for social visits.']");
    }
}