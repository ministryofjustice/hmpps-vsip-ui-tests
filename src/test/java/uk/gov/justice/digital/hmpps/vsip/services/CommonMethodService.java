package uk.gov.justice.digital.hmpps.vsip.services;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import uk.gov.justice.digital.hmpps.vsip.annotation.ComponentWithWebDriver;
import uk.gov.justice.digital.hmpps.vsip.annotation.LazyAutowired;

import java.util.List;

@ComponentWithWebDriver
public class CommonMethodService {

    @LazyAutowired
    protected WebDriver driver;

    @LazyAutowired
    protected WebDriverWait wait;


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
     * method to get element status - displayed?
     *
     * @param accessType : String : Locator type (id, name, class, xpath, css)
     * @param accessName : String : Locator value
     * @return Boolean
     */
    public boolean isElementNotDisplayed(String accessType, String accessName) {
        WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(getElementByType(accessType, accessName)));
        return !element.isDisplayed();
    }

    public boolean isElementPresent(String accessType, String accessName) {
        try {
            driver.findElement(getElementByType(accessType, accessName));
            return true;
        } catch (org.openqa.selenium.NoSuchElementException e) {
            return false;
        }
    }
    /**
     * Method to select element 'by' type
     *
     * @param type       : String : 'By' type
     * @param accessName : String : Locator value
     * @return By
     */
    public By getElementByType(String type, String accessName) {
        return switch (type) {
            case "id" -> By.id(accessName);
            case "name" -> By.name(accessName);
            case "class" -> By.className(accessName);
            case "xpath" -> By.xpath(accessName);
            case "css" -> By.cssSelector(accessName);
            case "linkText" -> By.linkText(accessName);
            case "partialLinkText" -> By.partialLinkText(accessName);
            case "tagName" -> By.tagName(accessName);
            default -> null;
        };
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

    /**
     * method to check element disabled
     *
     * @param accessType : String : Locator type (id, name, class, xpath, css)
     * @param accessName : String : Locator value
     * @return Boolean
     */
    public boolean isElementDisabled(String accessType, String accessName) {
        WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(getElementByType(accessType, accessName)));
        return !element.isEnabled();
    }

    public void clickOnLoginSubmitBtn() {
        clickOnButton("xpath", "//*[@id='submit']");
    }

    public void clickOnSubmitBtn() {
        clickOnButton("xpath", "//*[@data-test='submit']");
    }

    public String getApplicationRef() {
        By by = getElementByType("xpath", "//button[contains(@data-test, 'submit')]");
        return driver.findElement(by).getAttribute("data-test-app-ref");
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
        var xpath = "//div[contains(@id, 'error-detail') and .//*[text() = '"+errorMsg+"']]";
        isElementDisplayed("xpath", xpath);
    }

    public void chooseBristol() {
        selectRadioButton("xpath", "//p[text()='Bristol (HMP & YOI)']");
    }

    public void chooseNoBristol() {
        isElementNotVisible("xpath", "//*[@id='BLI']");
    }

    public void chooseDrakeHall() {
        selectRadioButton("xpath","//p[text()='Drake Hall (HMP & YOI)']");
    }

    public void changeEstablishment() {
        click("xpath", "//a[contains(@data-test, 'change-establishment')]");
    }

}