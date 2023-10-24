package pages;

public class AdditionalSupportPage extends commonMethods {

    public void selectNoForAddAssistance() {
        selectRadioButton("xpath","//input[@id='additionalSupportRequired-2']");
    }
    public void selectYesForAddAssistance() {
        selectRadioButton("xpath","//input[@id='additionalSupportRequired']");
    }
    public void checkDisabilityOption() {
        checkCheckbox("xpath","//input[@id='additionalSupport']");
    }
    public void checkOtherDisabilityOption() {
        checkCheckbox("xpath", "//input[@id='additionalSupport-5']");
    }

    public void enterDisability(String disability) {
        enterValInTextField("xpath", disability, "//*[@id='otherSupportDetails']");
    }
}