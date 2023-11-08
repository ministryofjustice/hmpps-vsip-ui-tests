package pages;

public class SelectTimeSlotPage extends commonMethods {

    public void selectTimeSlot() {
        click("xpath","//button[contains(@class, 'govuk-accordion__show-all')]");
        selectRadioButton("xpath","//input[@id='1']");
    }
    public void selectNextTimeSlot() {
        click("xpath","//button[contains(@class, 'govuk-accordion__show-all')]");
        selectRadioButton("xpath","//*[@id='2']");
    }

    public void selectTimeslotErrorDisplayed() {
        isElementDisplayed("xpath","//a[text() = 'No time slot selected']");
    }

    public void selectNonAssTimeSlot(){
        click("xpath","//button[contains(@class, 'govuk-accordion__show-all')]");
        selectRadioButton("xpath","//*[@id='5']");
    }

    public void noTimeslotAvailable(){
        isElementNotVisible("xpath","//*[@id='5']");

    }
}