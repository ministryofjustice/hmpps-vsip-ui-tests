package pages;

public class LoginPage extends CommonMethods {

    //Enter userName in textbox
    public void enterUserName(String user_Name) {

        enterValInTextField("xpath",user_Name,"//input[@id='username']");
    }
    //Enter password in password textbox
    public void enterPassword(String password) {
        enterValInTextField("xpath",password,"//input[@id='password']");
    }
}