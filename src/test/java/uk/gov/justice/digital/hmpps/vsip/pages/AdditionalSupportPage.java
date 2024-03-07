package uk.gov.justice.digital.hmpps.vsip.pages;

import uk.gov.justice.digital.hmpps.vsip.annotation.ComponentWithWebDriver;

@ComponentWithWebDriver
public class AdditionalSupportPage extends BasePage {

    public void selectNoForAddAssistance() {
        methodsService.selectRadioButton("xpath", "//input[@id='additionalSupportRequired-2']");
    }

    public void selectYesForAddAssistance() {
        methodsService.selectRadioButton("xpath", "//input[@id='additionalSupportRequired']");
    }

    public void enterDetails(String details) {
        methodsService.enterValInTextField("xpath", details,"//*[@id='additionalSupport']");
    }

    public void checkDisabilityOption() {
        methodsService.checkCheckbox("xpath", "//input[@id='additionalSupport']");
    }

    public void checkOtherDisabilityOption() {
        methodsService.checkCheckbox("xpath", "//input[@id='additionalSupport-5']");
    }

    public void enterDisability(String disability) {
        methodsService.enterValInTextField("xpath", disability, "//*[@id='otherSupportDetails']");
    }

    public void selectAdditionalSupportOptErrorDisplayed() {
        methodsService.isElementDisplayed("xpath", "//a[text() = 'No answer selected']");
    }

    public void checkErrorMessageDisplayed() {
        methodsService.isElementDisplayed("xpath","//a[text() = 'Enter details of the request']");
    }

    public void checkCharacterLengthErrMsg() {
        methodsService.isElementDisplayed("xpath","//a[text() = 'Please enter at least 3 and no more than 512 characters']");
    }

}