package pages;

public class SelectVisitorsPage extends CommonMethods {

    public void selectVisitorErrorDisplayed() {
        isElementDisplayed("xpath","//a[text() = 'No visitors selected']");
    }
}