package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import pages.util.Context;
import pages.util.TestRunContext;

import java.util.ArrayList;
import java.util.List;

public class SelectTimeSlotPage extends commonMethods {

    public void selectTimeslotErrorDisplayed() {
        isElementDisplayed("xpath","//a[text() = 'No time slot selected']");
    }

    public void selectNonAssTimeSlot(){
        click("xpath","//button[contains(@class, 'govuk-accordion__show-all')]");
        selectRadioButton("xpath","//*[@id='5']");

        String slotDay = verifyAndGetSlotDay();
        TestRunContext.set(Context.SLOT_DATE_TIME,slotDay);
    }

    public void selectTimeSlotAsBefore() {
        final String xPath = "//a[contains(text(),'" + TestRunContext.getTimeSlotDay() + "')]";
        selectRadioButton("xpath",xPath);
    }

    public void noTimeslotAvailable(){
        isElementNotVisible("xpath","//*[@id='5']");
    }

}