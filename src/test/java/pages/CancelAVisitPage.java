package pages;

public class CancelAVisitPage extends commonMethods {

    public void selectCancelByVisitor() {
        selectRadioButton("xpath","//input[@id='cancel']");
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
