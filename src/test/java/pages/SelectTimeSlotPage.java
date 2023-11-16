package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class SelectTimeSlotPage extends commonMethods {

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