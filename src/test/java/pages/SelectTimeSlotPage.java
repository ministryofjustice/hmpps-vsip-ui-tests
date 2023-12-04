package pages;

import org.openqa.selenium.WebElement;
import pages.util.Context;
import pages.util.TestRunContext;

public class SelectTimeSlotPage extends commonMethods {

    public void selectTimeslotErrorDisplayed() {
        isElementDisplayed("xpath","//a[text() = 'No time slot selected']");
    }

    public void selectNonAssTimeSlot(){
        final int inputIndex = 1;
        click("xpath","//button[contains(@class, 'govuk-accordion__show-all')]");
        WebElement radioButton = selectRadioButton("xpath","//*[@id='"+inputIndex+"']");
        final String slotDetails = radioButton.getAttribute("data-test");
        if (slotDetails != null) {
            TestRunContext.set(Context.SLOT_DATE_TIME, slotDetails);
        } else {
            System.err.println("Error data-test not found on element time slot RadioButton!");
        }
    }

    public void selectLastBookedSlot() {
        final String xPath = "//*[@data-test='" + TestRunContext.getTimeSlotDay() + "']";
        selectRadioButton("xpath",xPath);
    }

    public void noTimeslotAvailable(){
        isElementNotVisible("xpath","//*[@id='5']");
    }

    public void lastBookedTimeSlotNotAvailable(){
        final String xPath = "//*[@data-test='" + TestRunContext.getTimeSlotDay() + "']";
        isElementNotVisible("xpath",xPath);
    }

}