package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.*;
import org.testng.Assert;
import stepDefinitions.WebDriverInstance;
import utils.Configuration;
import java.time.Duration;

/**
 * Created by Anusha Nagula on 15/05/23.
 */
 public class commonMethods implements WebDriverInstance {

    public Wait<WebDriver> wait = new FluentWait<>(driver)
            .withTimeout(Duration.ofSeconds(20));

    private WebElement element=null;

    public void navigateToPage(Configuration configuration) {
        driver.get(configuration.getBaseUrl());

    }

    public void isPageTitleDisplayed(String pageTitle) {
        String currentTitle = driver.getTitle();
        Assert.assertEquals(currentTitle, pageTitle);

    }

    /** method to get element status - displayed?
     @param accessType : String : Locator type (id, name, class, xpath, css)
     @param accessName : String : Locator value
     @return Boolean
     */
    public boolean isElementDisplayed(String accessType,String accessName) {
        element = wait.until(ExpectedConditions.presenceOfElementLocated(getelementbytype(accessType, accessName)));
        return element.isDisplayed();
    }

    /**Method to select element 'by' type
      * @param type : String : 'By' type
     * @param access_name : String : Locator value
     * @return By
     */
    public By getelementbytype(String type, String access_name) {
        switch (type) {
            case "id":
                return By.id(access_name);
            case "name":
                return By.name(access_name);
            case "class":
                return By.className(access_name);
            case "xpath":
                return By.xpath(access_name);
            case "css":
                return By.cssSelector(access_name);
            case "linkText":
                return By.linkText(access_name);
            case "partialLinkText":
                return By.partialLinkText(access_name);
            case "tagName":
                return By.tagName(access_name);
            default:
                return null;
        }
    }

    /** Method to enter text into text field
     * @param accessType : String : Locator type (id, name, class, xpath, css)
     * @param value : String : Text value to enter in field
     @param accessName : String : Locator value
     */

    public void enterValInTextField(String accessType, String value, String accessName) {
        wait.until(ExpectedConditions.presenceOfElementLocated(getelementbytype(accessType,accessName)));
        driver.findElement(getelementbytype(accessType,accessName)).sendKeys(value);

    }

    /** Method to select element from Dropdown by type
     * @param select_list : Select : Select variable
     * @param bytype : String : Name of by type
     * @param option : String : Option to select
     */
    public void selectelementfromdropdownbytype (Select select_list, String bytype, String option)
    {
        if(bytype.equals("selectByIndex"))
        {
            int index = Integer.parseInt(option);
            select_list.selectByIndex(index-1);
        }
        else if (bytype.equals("value"))
            select_list.selectByValue(option);
        else if (bytype.equals("text"))
            select_list.selectByVisibleText(option);
    }

    /** Method to click on an element
     @param accessType : String : Locator type (id, name, class, xpath, css)
     @param accessName : String : Locator value
     */

    public void clickOnButton(String accessType, String accessName) {
        wait.until(ExpectedConditions.elementToBeClickable(getelementbytype(accessType,accessName)));
        driver.findElement(getelementbytype(accessType,accessName)).click();
    }

    /** Method to click on an element
    @param accessType : String : Locator type (id, name, class, xpath, css)
    @param accessName : String : Locator value
	*/
    public void click(String accessType, String accessName)
    {
        element = wait.until(ExpectedConditions.presenceOfElementLocated(getelementbytype(accessType, accessName)));
        element.click();
    }

    public void verifyHeading(String text){
        driver.findElement(By.cssSelector("h1")).getText().equals(text);
    }

    public void isElementVisible(String accessType, String value, String accessName){
        driver.findElement(getelementbytype(accessType,accessName)).isDisplayed();
    }

    /** Method to select radio button
     @param accessType : String : Locator type (id, name, class, xpath, css)
     @param accessName : String : Locator value
     */
    public void selectRadioButton(String accessType, String accessName)
    {
        WebElement radioButton = wait.until(ExpectedConditions.presenceOfElementLocated(getelementbytype(accessType, accessName)));
        if(!radioButton.isSelected())
            radioButton.click();
    }

    /** Method to check check-box
     @param accessType : String : Locator type (id, name, class, xpath, css)
     @param accessName : String : Locator value
     */
    public void checkCheckbox(String accessType, String accessName)
    {
        WebElement checkbox= wait.until(ExpectedConditions.presenceOfElementLocated(getelementbytype(accessType, accessName)));
        if (!checkbox.isSelected())
            checkbox.click();
    }
}