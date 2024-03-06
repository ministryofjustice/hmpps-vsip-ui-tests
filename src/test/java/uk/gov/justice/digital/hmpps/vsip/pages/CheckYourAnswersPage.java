package uk.gov.justice.digital.hmpps.vsip.pages;

import uk.gov.justice.digital.hmpps.vsip.annotation.ComponentWithWebDriver;

@ComponentWithWebDriver
public class CheckYourAnswersPage extends BasePage {

    public void verifyDetailsDisplayed() {
        methodsService.isElementDisplayed("xpath","//p[text()='wheel chair']");
    }
}
