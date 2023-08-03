package pages;

public class BookingDetailsPage extends commonMethods {

    public void checkCancelMessageDisplayed(String msg) {
        isElementDisplayed("xpath","//span[text() = 'This visit was cancelled by the visitor.']");

    }

    public void checkMethodofBooking(String msg) {
        isElementDisplayed("xpath","//*[@id='main-content']/div/div/ul[3]/li[2]/span");

    }
}