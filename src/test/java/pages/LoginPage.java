package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends commonMethods {

    WebDriver driver;

    By userName = By.id("username");
    By password = By.id("password");


    //Enter userName in textbox
    public void enterUserName(String user_Name){
        enterValInTextField("id",user_Name,"username");

    }

    //Enter password in password textbox
    public void enterPassword(String password){
        enterValInTextField("id",password,"password");

    }

}
