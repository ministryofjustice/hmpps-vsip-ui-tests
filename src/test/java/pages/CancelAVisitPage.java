package pages;

public class CancelAVisitPage extends commonMethods {

    public void selectCancelByVisitor() {
        selectRadioButton("xpath","//input[@id='cancel']");
    }

    public void selectCancelByPhone() {
        selectRadioButton("xpath","//input[@id='conditional-cancel']/div/fieldset/div/div[1]/label/text()");
    }

    public void selectCancelByGov(){
        selectRadioButton("xpath","//input[@id='conditional-cancel']/div/fieldset/div/div[2]/label/text()");
    }

    public void selectCancelByEmail(){
        selectRadioButton("xpath","//input[@id='conditional-cancel']/div/fieldset/div/div[3]/label/text()");
    }

    public void selectCancelByInperson(){
        selectRadioButton("xpath","//input[@id='conditional-cancel']/div/fieldset/div/div[4]/label/text()");
    }
    public void enterReasonForCancellation(String reason) {
        enterValInTextField("xpath", reason, "//input[@id='reason_visitor_cancelled']");
    }

    public void selectCancelByEstablishment() {
        selectRadioButton("xpath","//input[@id='cancel-2']");
    }

    public void selectCancelByPrisoner() {
        selectRadioButton("xpath","//input[@id='cancel-3']");
    }

    public void selectCancelByAdmin() {
        selectRadioButton("xpath","//input[@id='cancel-3']");
    }

}