package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends commonMethods {

    //Enter userName in textbox
    public void enterUserName(String user_Name) throws InterruptedException {
        enterValInTextField("xpath",user_Name,"//input[@id='username']");

    }

    //Enter password in password textbox
    public void enterPassword(String password) throws InterruptedException {
        enterValInTextField("xpath",password,"//input[@id='password']");

    }

}