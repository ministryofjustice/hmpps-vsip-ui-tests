package pages;

public class SearchPage extends commonMethods {

    public void enterPrisonDetails(String prison_details) {
        enterValInTextField("xpath",prison_details,"//input[@id='search']");

    }

    public void enterConfimationInBlock1(String value1){
        enterValInTextField("xpath",value1,"//input[@id='searchBlock1']");
    }

    public void enterConfimationInBlock2(String value2){
        enterValInTextField("xpath",value2,"//input[@id='searchBlock2']");
    }

    public void enterConfimationInBlock3(String value3){
        enterValInTextField("xpath",value3,"//input[@id='searchBlock3']");
    }

    public void enterConfimationInBlock4(String value4){
        enterValInTextField("xpath",value4,"//input[@id='searchBlock4']");
    }


}
