package pages;

public class WhatMethodPage extends commonMethods {

    public void selectPhoneCall() {
        selectRadioButton("xpath","//input[@id='method']");
    }
}