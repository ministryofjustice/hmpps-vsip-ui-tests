package uk.gov.justice.digital.hmpps.vsip.pages;


import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import uk.gov.justice.digital.hmpps.vsip.annotation.ComponentWithWebDriver;

@ComponentWithWebDriver
public class CancelAVisitPage extends BasePage {

    @FindBy(how = How.XPATH, using = "//input[@data-test='clear-notification-yes']")
    private WebElement selectYesIAmSureTheVisitDoseNotNeed;

    @FindBy(how = How.XPATH, using = "//input[@data-test='clear-notification-no']")
    private WebElement selectNoIAmSureTheVisitDoseNotNeed;

    @FindBy(how = How.XPATH, using = "//input[@id='clearReason']")
    private WebElement reasonForDonNotChangeReasonInput;

    @FindBy(how = How.XPATH, using = "//a[contains(@data-test, 'clear-notifications')]")
    private WebElement doNotChangeButton;

    public void selectCancelByVisitor() {
        methodsService.selectRadioButton("xpath", "//input[@id='cancel']");
    }

    public void selectCancelByPhone() {
        methodsService.selectRadioButton("xpath", "//input[@id='method']");
    }

    public void selectCancelByGov() {
        methodsService.selectRadioButton("xpath", "//input[@id='method-2']");
    }

    public void selectCancelByEmail() {
        methodsService.selectRadioButton("xpath", "//input[@id='method-3']");
    }

    public void selectCancelByInperson() {
        methodsService.selectRadioButton("xpath", "//input[@id='method-4']");
    }

    public void enterReasonForCancellation(String reason) {
        methodsService.enterValInTextField("xpath", reason, "//input[@id='reason']");
    }

    public void selectCancelByEstablishment() {
        methodsService.selectRadioButton("xpath", "//input[@id='cancel-2']");
    }

    public void selectCancelByPrisoner() {
        methodsService.selectRadioButton("xpath", "//input[@id='cancel-3']");
    }

    public void selectCancelByAdmin() {
        methodsService.selectRadioButton("xpath", "//input[@id='cancel-3']");
    }

    public void clickOnCancelBtn() {
        methodsService.click("xpath", "//button[contains(@data-test, 'cancel-booking')]");
    }

    public void clickOnDoNotChangeBtn() {
        methodsService.click("xpath", "//a[contains(@data-test, 'clear-notifications')]");
    }

    public void clickOnDoNoChangeButton() {
        doNotChangeButton.click();
    }

    public boolean canISeeDoNotChangeButton() {
        try {
            doNotChangeButton.isDisplayed();
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public void clickSelectYesIAmSureTheVisitDoseNotNeed() {
        selectYesIAmSureTheVisitDoseNotNeed.click();
    }

    public void clickSelectNoIAmSureTheVisitDoseNotNeed() {
        selectNoIAmSureTheVisitDoseNotNeed.click();
    }

    public void entreReasonForDoNotChangeInput(String reason) {
        reasonForDonNotChangeReasonInput.sendKeys(reason);
    }
}