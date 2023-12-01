package pages;

public class WhatMethodPage extends commonMethods {

    public void selectPhoneCall() {

        selectRadioButton("xpath","//input[@id='method']");
    }

    public void selectByPrisoner() {

        selectRadioButton("xpath","//input[@id='method-5']");
    }

    public void checkErrorMsg(){
        isElementDisplayed("xpath","//a[text() = 'No request method selected']");
    }
}