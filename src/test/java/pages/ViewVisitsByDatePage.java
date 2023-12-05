package pages;

public class ViewVisitsByDatePage extends CommonMethods {

    public void selectDatePicker(){
        click("xpath","//button[contains(@data-test, 'another-date-button')]");
    }

    public void enterDate(String date) {
        enterValInTextField("xpath",date,"//*[@id='date']");
    }

    public void clickOnView(){
        click("xpath","//button[contains(@data-test, 'submit')]");
    }

    public void checkTabsDateChanged(){
        isElementDisplayed("xpath","//a[@href='/visits?selectedDate=2023-11-20&firstTabDate=2023-11-20']");
    }

    public void selectViewOption(){
        click("xpath","//a[contains(text(), 'View')]");
    }

    public void checkTextOnVisit(String text){
        isElementDisplayed("xpath","//h1[text()='Visit booking details']");
    }

    public void checkErrorMessage(){
        isElementDisplayed("xpath","//a[text() = 'Enter a valid date']");
    }

}
