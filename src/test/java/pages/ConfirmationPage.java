package pages;

public class ConfirmationPage extends CommonMethods {

    public void checkBookingHeading(String confirmationMsg) {
        verifyHeading(confirmationMsg);
    }

    public String getBookingReference() {
        return verifyAndGetBookingReference();
    }
}