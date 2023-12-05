package pages;

public class CheckYourAnswersPage extends CommonMethods {

    public void clickOnSubmitBookingBtn() {
        clickOnButton("xpath","//*[@id='main-content']/div[4]/div/form/button");
    }
}