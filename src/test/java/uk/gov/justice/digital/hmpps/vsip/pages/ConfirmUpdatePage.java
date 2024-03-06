package uk.gov.justice.digital.hmpps.vsip.pages;

import org.openqa.selenium.By;
import uk.gov.justice.digital.hmpps.vsip.annotation.ComponentWithWebDriver;

@ComponentWithWebDriver
public class ConfirmUpdatePage extends BasePage {

    public void selectYesRadioButton(){
        methodsService.selectRadioButton("xpath","//*[@id='confirmUpdate']");
    }
}
