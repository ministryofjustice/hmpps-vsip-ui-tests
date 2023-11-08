package pages;

public class PrisonerDetailsPage extends commonMethods {

    public void selectLatestPrisonVisit() {
        click("xpath","//*[@id='visits']/table[1]/tbody/tr/td[1]/a");
    }
}