package uk.gov.justice.digital.hmpps.vsip.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import uk.gov.justice.digital.hmpps.vsip.annotation.ComponentWithWebDriver;

@ComponentWithWebDriver
public class NeedAReviewPage extends BasePage {
    @FindBy(how = How.XPATH, using = "//span[contains(@class, 'govuk-details__summary-text')]")
    private WebElement summaryList;

    public void isSummaryListOptionDisplayed(String summaryList) {
        methodsService.isElementDisplayed("xpath", "//span[contains(@class, 'govuk-details__summary-text')]");
    }

    public void clickOnView(String excludedate) {
        String xpath = "//*[starts-with(@data-test, 'visit-date-')]//li[contains(text(), '" + excludedate + "')]";
        methodsService.isElementDisplayed("xpath",xpath);
        methodsService.click("xpath","//a[text()='View']");
    }

    public void clickOnViewWithRef(String bookingReference) {
        final String xpath = "//a[@href='/visit/"+bookingReference+"?from=review']";
        methodsService.isElementDisplayed("xpath",xpath);
        methodsService.click("xpath",xpath);
    }

    public void checkReviewMsg(String reviewMsg) {
        methodsService.isElementDisplayed("xpath","//h2[text()='Needs review']");
    }

    public void iCheckToSeeIfThereNoNotificationsForReview() {
        methodsService.isElementDisplayed("xpath","//p[text()='There are no bookings for Hewell (HMP) that need review.']");
    }
}
