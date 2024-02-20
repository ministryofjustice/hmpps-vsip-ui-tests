package uk.gov.justice.digital.hmpps.vsip.pages;

import uk.gov.justice.digital.hmpps.vsip.annotation.ComponentWithWebDriver;

@ComponentWithWebDriver
public class WhatMethodPage extends BasePage {

    public void selectPhoneCall() {

        methodsService.selectRadioButton("xpath", "//label[@for='method']");
    }

    public void selectByPrisoner() {

        methodsService.selectRadioButton("xpath", "//label[@for='method-5']");
    }

    public void checkErrorMsg() {
        methodsService.isElementDisplayed("xpath", "//a[text() = 'No request method selected']");
    }

}