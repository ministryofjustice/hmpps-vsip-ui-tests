package pages;

public class SelectTimeSlotPage extends commonMethods {

    public void selectTimeSlot() {
        click("xpath","//*[@id='slots-month-October2023']/div[2]/div[1]/h3/button/span[5]/span");
        selectRadioButton("xpath","//input[@id='1']");
    }
    public void selectNextTimeSlot() {
        click("xpath","//*[@id='slots-month-October2023']/div[3]/div[1]/h3/button/span[5]/span");
        selectRadioButton("xpath","//*[@id='2']");
    }

    public void selectTimeslotErrorDisplayed() {
        isElementDisplayed("xpath","//a[text() = 'No time slot selected']");
    }
}