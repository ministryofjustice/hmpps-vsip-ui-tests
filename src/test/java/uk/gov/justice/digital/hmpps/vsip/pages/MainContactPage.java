package uk.gov.justice.digital.hmpps.vsip.pages;

import uk.gov.justice.digital.hmpps.vsip.annotation.ComponentWithWebDriver;

@ComponentWithWebDriver
public class MainContactPage extends BasePage {

    public void selectMainContact() {
        methodsService.selectRadioButton("xpath", "//input[@id='contact']");
    }

    public void selectSomeOneElse() {
        methodsService.selectRadioButton("xpath", "//input[@id='contact-2']");
    }

    public void chooseUKPhoneNoOption() {
        methodsService.selectRadioButton("xpath","//*[@id='phoneNumber']");
    }

    public void chooseNoPhoneNoOption() {
        methodsService.selectRadioButton("xpath","//*[@id='phoneNumber-2']");
    }

    public void enterPhoneNo(String phoneNo) {
        methodsService.enterValInTextField("xpath", phoneNo, "//input[@id='phoneNumberInput']");
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

    public void checkNoAnswerErrorMsg() {
        methodsService.isElementDisabled("xpath","//a[text() = 'No answer selected']");
    }

    public void checkNameOfMainContactErrorMsg() {
        methodsService.isElementDisplayed("xpath","//a[text() = 'Enter the name of the main contact']");
    }

}