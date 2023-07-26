package pages;

public class CheckYourAnswersPage extends commonMethods {

    public void clickOnSubmitBookingBtn() {
        clickOnButton("xpath","//*[@id=\"main-content\"]/div[4]/div/form/button");
    }
}