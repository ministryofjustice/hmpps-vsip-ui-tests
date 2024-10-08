package uk.gov.justice.digital.hmpps.vsip.pages;

import uk.gov.justice.digital.hmpps.vsip.annotation.ComponentWithWebDriver;

@ComponentWithWebDriver
public class SelectOpenOrClosedTypePage extends BasePage {

    public void chooseClosedType(){
        methodsService.selectRadioButton("xpath","//input[@id='visitType-2']");
    }

    public void chooseOpenedType(){
        methodsService.selectRadioButton("xpath","//input[@id='visitType']");
    }

    public void checkErrormessage(){
        methodsService.isElementDisplayed("xpath","//a[text()='No visit type selected']");
    }

}
