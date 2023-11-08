package pages;

public class BookingDetailsPage extends commonMethods {

    public void clickOnBookingHistory() {
        clickOnButton("xpath","//*[@id='tab_history']");

    }

    public void checkCancelMessageDisplayed() {
        isElementDisplayed("xpath","//p[text() = 'GOV.UK request']");

    }

    public void checkMethodofBooking(String msg) {
        isElementDisplayed("xpath","//p[text() = 'Email request']");

    }
}