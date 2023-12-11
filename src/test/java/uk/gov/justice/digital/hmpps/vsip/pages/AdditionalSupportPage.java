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

}