package uk.gov.justice.digital.hmpps.vsip.pages;

import uk.gov.justice.digital.hmpps.vsip.annotation.ComponentWithWebDriver;

@ComponentWithWebDriver
public class MainContactPage extends BasePage {

    public void selectMainContact() {
        methodsService.selectRadioButton("xpath", "//label[@for='contact']");
    }

    public void selectSomeOneElse() {
        methodsService.selectRadioButton("xpath", "//label[@for='contact-2']");
    }

    public void enterPhoneNo(String phoneNo) {
        methodsService.enterValInTextField("xpath", phoneNo, "//input[@id='phoneNumber']");
    }

    public void enterContactName(String contactName) {
        methodsService.enterValInTextField("xpath", contactName, "//input[@id='someoneElseName']");
    }

    public void selectMainConErrorDisplayed() {
        methodsService.isElementDisplayed("xpath", "//a[text() = 'No main contact selected']");
    }

    public void checkPhoneNoErrorMsg() {
        methodsService.isElementDisplayed("xpath", "//a[text() = 'Enter a phone number']");
    }

}