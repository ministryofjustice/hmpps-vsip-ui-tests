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
        String slotDetails = radioButton.getAttribute("data-test");
        TestRunContext.set(Context.SLOT_DATE_TIME,slotDetails);
    }

    public void selectTimeSlotAsBefore() {
        final String xPath = "//*[@data-test='" + TestRunContext.getTimeSlotDay() + "']";
        selectRadioButton("xpath",xPath);
    }

    public void noTimeslotAvailable(){
        isElementNotVisible("xpath","//*[@id='5']");
    }

}