package pages;

public class SelectVisitorsPage extends commonMethods {

    public void selectVisitorErrorDisplayed(String errMsg) {
        isElementDisplayed("xpath","//a[contains(@href, 'No time slot selected')]");
    }
}