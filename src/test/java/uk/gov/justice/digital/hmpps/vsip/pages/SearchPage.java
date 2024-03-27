package uk.gov.justice.digital.hmpps.vsip.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import uk.gov.justice.digital.hmpps.vsip.annotation.ComponentWithWebDriver;

@ComponentWithWebDriver
public class SearchPage extends BasePage {

    @FindBy(how = How.XPATH, using = "//input[@id='search']")
    private WebElement prisonerDetailsInput;

    @FindBy(how = How.XPATH, using = "//*[@id='search-results-true']/tbody/tr/td[1]/a")
    private WebElement firstPrisonerReturnedLink;

    @FindBy(how = How.XPATH, using = "//input[@id='searchBlock1']")
    private WebElement referenceDetailsInput1;

    @FindBy(how = How.XPATH, using = "//input[@id='searchBlock2']")
    private WebElement referenceDetailsInput2;

    @FindBy(how = How.XPATH, using = "//input[@id='searchBlock3']")
    private WebElement referenceDetailsInput3;

    @FindBy(how = How.XPATH, using = "//input[@id='searchBlock4']")
    private WebElement referenceDetailsInput4;

    public void enterPrisonerDetails(String prisonerDetails) {
        prisonerDetailsInput.sendKeys(prisonerDetails);
    }

    public void selectPrisoner() {
        firstPrisonerReturnedLink.click();
    }

    public void enterConfirmationInBlock1(String value1) {
        referenceDetailsInput1.sendKeys(value1);
    }

    public void enterConfirmationInBlock2(String value2) {
        referenceDetailsInput2.sendKeys(value2);
    }

    public void enterConfirmationInBlock3(String value3) {
        referenceDetailsInput3.sendKeys(value3);
    }

    public void enterConfirmationInBlock4(String value4) {
        referenceDetailsInput4.sendKeys(value4);
    }

    public void searchErrorDisplayed(String errMsg) {
        methodsService.isElementDisplayed("xpath", "//a[contains(@href, 'search-error')]");
    }

    public void visitStatusDisplayed(String status) {
        methodsService.isElementDisplayed("xpath", "//td[text()='Booked']");
    }

    public void clickOnSearchBtn() {
        methodsService.click("xpath", "//button[contains(@data-test, 'search')]");
    }

    public void bookingRefSearchErrMsg() {
        methodsService.click("xpath","//a[text()='Booking reference must be 8 characters']");
    }
}