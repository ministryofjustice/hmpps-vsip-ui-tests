package uk.gov.justice.digital.hmpps.vsip.services;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Autowired;
import uk.gov.justice.digital.hmpps.vsip.annotation.LazyAutowired;
import uk.gov.justice.digital.hmpps.vsip.annotation.LazyComponent;
import uk.gov.justice.digital.hmpps.vsip.util.Configuration;

import java.util.List;

@LazyComponent
public class CommonMethodService {

    @Autowired
    protected WebDriver driver;

    @Autowired
    protected WebDriverWait wait;

    @LazyAutowired
    protected Configuration configuration;


    /**
     * method to get element status - displayed?
     *
     * @param accessType : String : Locator type (id, name, class, xpath, css)
     * @param accessName : String : Locator value
     * @return Boolean
     */
    public boolean isElementDisplayed(String accessType, String accessName) {
        WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(getElementByType(accessType, accessName)));
        return element.isDisplayed();
    }

    /**
     * Method to select element 'by' type
     *
     * @param type       : String : 'By' type
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

    /**
     * Method to enter text into text field
     *
     * @param accessType : String : Locator type (id, name, class, xpath, css)
     * @param value      : String : Text value to enter in field
     * @param accessName : String : Locator value
     */

    public void enterValInTextField(String accessType, String value, String accessName) {
        wait.until(ExpectedConditions.presenceOfElementLocated(getElementByType(accessType, accessName)));
        driver.findElement(getElementByType(accessType, accessName)).sendKeys(value);
    }


    /**
     * Method to select element from Dropdown by type
     *
     * @param select_list : Select : Select variable
     * @param bytype      : String : Name of by type
     * @param option      : String : Option to select
     */
    public void selectElementFromDropdownByType(Select select_list, String bytype, String option) {
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

    /**
     * Method to click on an element
     *
     * @param accessType : String : Locator type (id, name, class, xpath, css)
     * @param accessName : String : Locator value
     */

    public void clickOnButton(String accessType, String accessName) {
        wait.until(ExpectedConditions.elementToBeClickable(getElementByType(accessType, accessName)));
        driver.findElement(getElementByType(accessType, accessName)).click();
    }

    /**
     * Method to click on an element
     *
     * @param accessType : String : Locator type (id, name, class, xpath, css)
     * @param accessName : String : Locator value
     */
    public void click(String accessType, String accessName) {
        WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(getElementByType(accessType, accessName)));
        element.click();
    }

    public void isElementNotVisible(String accessType, String accessName) {
        WebElement element = driver.findElement(getElementByType(accessType, accessName));
        // Verify if the element is not displayed
        boolean isElementNotDisplayed = !element.isDisplayed();
        // Assert the result
        Assert.assertTrue("Element is not displayed", isElementNotDisplayed);
    }

    public void isElementAvailable(String accessType, String accessName) {
        List<WebElement> list = driver.findElements(getElementByType(accessType, accessName));
        if (!list.isEmpty()) {
            Assert.fail("Element " + accessName + " is available when it should not be!");
        }
    }

    /**
     * Method to select radio button
     *
     * @param accessType : String : Locator type (id, name, class, xpath, css)
     * @param accessName : String : Locator value
     */
    public WebElement selectRadioButton(String accessType, String accessName) {
        WebElement radioButton = wait.until(ExpectedConditions.presenceOfElementLocated(getElementByType(accessType, accessName)));
        if (!radioButton.isSelected()) {
            radioButton.click();
        }

        return radioButton;
    }

    /**
     * Method to check check-box
     *
     * @param accessType : String : Locator type (id, name, class, xpath, css)
     * @param accessName : String : Locator value
     */
    public void checkCheckbox(String accessType, String accessName) {
        WebElement checkbox = wait.until(ExpectedConditions.presenceOfElementLocated(getElementByType(accessType, accessName)));
        if (!checkbox.isSelected())
            checkbox.click();
    }

    public void clickOnSubmitBtn() {
        clickOnButton("xpath", "//*[@id='submit']");
    }

    public void clickOnContinueBtn() {
        click("xpath", "//button[contains(@data-test, 'submit')]");
    }


    public void clickOnManagePrisonOption() {
        click("xpath", "//a[contains(@class, 'hmpps-header__link hmpps-header__title__service-name')]");
    }

    public void clickOnSignOut() {
        click("xpath", "/html/body/header/div/nav/ul/li[2]/a");
    }

    public void errorMsgDisplayed(String errorMsg) {
        isElementDisplayed("xpath", "//*[@id='error-detail']");
    }

    public void chooseBristol() {
        selectRadioButton("xpath", "//*[@id='BLI']");
    }

    public void chooseNoBristol() {
        isElementNotVisible("xpath", "//*[@id='BLI']");
    }

    public void changeEstablishment() {
        click("xpath", "//a[contains(@data-test, 'change-establishment')]");
    }

}
