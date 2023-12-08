package uk.gov.justice.digital.hmpps.vsip.pages;


import uk.gov.justice.digital.hmpps.vsip.annotation.LazyComponent;

@LazyComponent
public class CancelAVisitPage extends BasePage {

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
}