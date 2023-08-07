package stepDefinitions;

import io.cucumber.java.en.And;
import pages.WhatMethodPage;
import pages.commonPage;

public class WhatMethodStepDefinitions extends WhatMethodPage {
    pages.commonPage commonPage = new commonPage();
    //The below method can be written for multiple options Gov.uk,Email,In person
    @And("I select a phone call option on method used to make the reqest")
    public void iSelectAPhoneCallOptionOnMethodUsedToMakeTheReqest() {
        selectPhoneCall();
    }
}
