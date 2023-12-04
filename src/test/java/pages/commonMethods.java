package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.*;
import org.testng.Assert;
import stepDefinitions.WebDriverInstance;
import utils.Configuration;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

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
        element = wait.until(ExpectedConditions.presenceOfElementLocated(getElementByType(accessType, accessName)));
        return element.isDisplayed();
    }

    /**Method to select element 'by' type
      * @param type : String : 'By' type
     * @param accessName : String : Locator value
     * @return By
     */
    public By getElementByType(String type, String accessName) {
        switch (type) {
            case "id":
                return By.id(accessName);
            case "name":
                return By.name(accessName);
            case "class":
                return By.className(accessName);
            case "xpath":
                return By.xpath(accessName);
            case "css":
                return By.cssSelector(accessName);
            case "linkText":
                return By.linkText(accessName);
            case "partialLinkText":
                return By.partialLinkText(accessName);
            case "tagName":
                return By.tagName(accessName);
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
        wait.until(ExpectedConditions.presenceOfElementLocated(getElementByType(accessType,accessName)));
        driver.findElement(getElementByType(accessType,accessName)).sendKeys(value);

    }

    /** Method to select element from Dropdown by type
     * @param select_list : Select : Select variable
     * @param bytype : String : Name of by type
     * @param option : String : Option to select
     */
    public void selectElementFromDropdownByType(Select select_list, String bytype, String option)
    {
        switch (bytype) {
            case "selectByIndex":
                int index = Integer.parseInt(option);
                select_list.selectByIndex(index - 1);
                break;
            case "value":
                select_list.selectByValue(option);
                break;
            case "text":
                select_list.selectByVisibleText(option);
                break;
        }
    }

    /** Method to click on an element
     @param accessType : String : Locator type (id, name, class, xpath, css)
     @param accessName : String : Locator value
     */

    public void clickOnButton(String accessType, String accessName) {
        wait.until(ExpectedConditions.elementToBeClickable(getElementByType(accessType,accessName)));
        driver.findElement(getElementByType(accessType,accessName)).click();
    }

    /** Method to click on an element
    @param accessType : String : Locator type (id, name, class, xpath, css)
    @param accessName : String : Locator value
	*/
    public void click(String accessType, String accessName)
    {
        element = wait.until(ExpectedConditions.presenceOfElementLocated(getElementByType(accessType, accessName)));
        element.click();
    }

    public void verifyHeading(String text){
        driver.findElement(By.cssSelector("h1")).getText().equals(text);
    }

    public String verifyAndGetBookingReference(){
        By by = getElementByType("class","test-booking-reference");
        return driver.findElement(by).getText();
    }

    public void isElementVisible(String accessType, String value, String accessName){
        driver.findElement(getElementByType(accessType,accessName)).isDisplayed();
    }

    public void isElementNotVisible(String accessType, String accessName){
        WebElement element = driver.findElement(getElementByType(accessType,accessName));
        // Verify if the element is not displayed
        boolean isElementNotDisplayed = !element.isDisplayed();
        // Assert the result
        Assert.assertTrue(isElementNotDisplayed, "Element is not displayed");
    }

    /** Method to select radio button
     @param accessType : String : Locator type (id, name, class, xpath, css)
     @param accessName : String : Locator value
     */
    public WebElement selectRadioButton(String accessType, String accessName)
    {
        WebElement radioButton = wait.until(ExpectedConditions.presenceOfElementLocated(getElementByType(accessType, accessName)));
        if(!radioButton.isSelected())
            radioButton.click();

        return radioButton;
    }

    /** Method to check check-box
     @param accessType : String : Locator type (id, name, class, xpath, css)
     @param accessName : String : Locator value
     */
    public void checkCheckbox(String accessType, String accessName)
    {
        WebElement checkbox= wait.until(ExpectedConditions.presenceOfElementLocated(getElementByType(accessType, accessName)));
        if (!checkbox.isSelected())
            checkbox.click();
    }
    public void clickNextEnabledElement() {
        click("xpath","//button[contains(@class, 'govuk-accordion__show-all')]");

        // List of different XPaths for time slots elements
        List<String> xpaths = new ArrayList<>();
        xpaths.add("//*[@id='1']");
        xpaths.add("//*[@id='2']");
        xpaths.add("//*[@id='3']");
        xpaths.add("//*[@id='4']");
        xpaths.add("//*[@id='5']");
        xpaths.add("//*[@id='6']");
        xpaths.add("//*[@id='7']");
        xpaths.add("//*[@id='8']");
        xpaths.add("//*[@id='9']");
        xpaths.add("//*[@id='10']");

        // Iterate through the XPaths
        for (String xpath : xpaths) {
            // Find elements using the current XPath
            List<WebElement> elements = driver.findElements(By.xpath(xpath));

            // Iterate through the elements to find the first enabled one
            for (WebElement element : elements) {
                if (element.isEnabled()) {
                    // Click the first enabled element
                    element.click();
                    return; // Exit the method once the first enabled element is clicked
                }
            }
        }
    }
}