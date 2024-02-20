package uk.gov.justice.digital.hmpps.vsip.pages;

import uk.gov.justice.digital.hmpps.vsip.annotation.ComponentWithWebDriver;

@ComponentWithWebDriver
public class SelectOpenOrClosedTypePage extends BasePage {

    public void chooseClosedType(){
        methodsService.selectRadioButton("xpath","//label[@for='visitType-2']");
    }

    public void checkErrormessage(){
        methodsService.isElementDisplayed("xpath","//a[text()='No visit type selected']");
    }

}
