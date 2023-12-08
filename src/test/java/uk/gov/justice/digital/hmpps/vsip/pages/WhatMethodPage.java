package uk.gov.justice.digital.hmpps.vsip.pages;

import uk.gov.justice.digital.hmpps.vsip.annotation.LazyComponent;

@LazyComponent
public class WhatMethodPage extends BasePage {

    public void selectPhoneCall() {

        methodsService.selectRadioButton("xpath", "//input[@id='method']");
    }

    public void selectByPrisoner() {

        methodsService.selectRadioButton("xpath", "//input[@id='method-5']");
    }

    public void checkErrorMsg() {
        methodsService.isElementDisplayed("xpath", "//a[text() = 'No request method selected']");
    }

}