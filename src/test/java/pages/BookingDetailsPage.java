package pages;

public class BookingDetailsPage extends commonMethods {

    public void checkCancelMessageDisplayed() {
        isElementDisplayed("xpath","//*[@id='main-content']/div/div/ul[3]/li[2]/strong");

    }

    public void checkMethodofBooking(String msg) {
        isElementDisplayed("xpath","//*[@id='main-content']/div/div/ul[3]/li[2]/span");

    }
}