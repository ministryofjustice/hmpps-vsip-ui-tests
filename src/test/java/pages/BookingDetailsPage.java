package pages;

public class BookingDetailsPage extends CommonMethods {

    public void clickOnBookingHistory() {
        clickOnButton("xpath","//*[@id='tab_history']");

    }

    public void checkCancelMessageDisplayed() {
        isElementDisplayed("xpath","//p[text() = 'GOV.UK request']");

    }

    public void checkMethodofBooking(String msg) {
        isElementDisplayed("xpath","//p[text() = 'Email request']");

    }
    public void checkMethodofNewBooking(String msg) {
        isElementDisplayed("xpath","//p[text() = 'By the prisoner']");
    }
}