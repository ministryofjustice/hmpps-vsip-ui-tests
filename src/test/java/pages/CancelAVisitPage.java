package pages;

public class CancelAVisitPage extends commonMethods {

    public void selectCancelByVisitor() {
        selectRadioButton("xpath","//input[@id='cancel']");
    }

    public void selectCancelByPhone() {
        selectRadioButton("xpath","//input[@id='method']");
    }

    public void selectCancelByGov(){
        selectRadioButton("xpath","//input[@id='method-2']");
    }

    public void selectCancelByEmail(){
        selectRadioButton("xpath","//input[@id='method-3']");
    }

    public void selectCancelByInperson(){
        selectRadioButton("xpath","//input[@id='method-4']");
    }
    public void enterReasonForCancellation(String reason) {
        enterValInTextField("xpath", reason, "//input[@id='reason']");
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