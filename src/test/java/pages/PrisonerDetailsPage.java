package pages;

public class PrisonerDetailsPage extends commonMethods {

    public void selectLatestPrisonVisit() {
        click("xpath","//*[@id=\"visits\"]/table/tbody/tr[1]/td[1]/a");
    }
}