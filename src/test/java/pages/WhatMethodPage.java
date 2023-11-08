package pages;

public class WhatMethodPage extends commonMethods {

    public void selectPhoneCall() {

        selectRadioButton("xpath","//input[@id='method']");
    }

    public void checkErrorMsg(){
        isElementDisplayed("xpath","//a[text() = 'No request method selected']");
    }
}