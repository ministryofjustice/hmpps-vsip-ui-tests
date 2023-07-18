package pages;

public class MainContactPage extends commonMethods {

    public void selectMainContact() {
        selectRadioButton("xpath","//input[@id='contact']");
    }

    public void selectSomeOneElse() {
        selectRadioButton("xpath","//input[@id='contact-2']");
    }

    public void enterPhoneNo(String phoneNo) {
        enterValInTextField("xpath",phoneNo,"//input[@id='phoneNumber']");

    }

    public void enterContactName(String contactName) {
        enterValInTextField("xpath", contactName, "//input[@id='someoneElseName']");
    }
}
