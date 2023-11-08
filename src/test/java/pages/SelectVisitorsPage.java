package pages;

public class SelectVisitorsPage extends commonMethods {

    public void selectVisitorErrorDisplayed() {
        isElementDisplayed("xpath","//a[text() = 'No visitors selected']");
    }
}