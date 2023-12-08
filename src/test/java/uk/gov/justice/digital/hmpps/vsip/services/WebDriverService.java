package uk.gov.justice.digital.hmpps.vsip.services;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.LocalFileDetector;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.springframework.beans.factory.annotation.Value;
import uk.gov.justice.digital.hmpps.vsip.annotation.LazyComponent;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;


@LazyComponent
public class WebDriverService {

    @Value("${browser:chrome}")
    private String targetBrowser;

    public WebDriver getWebDriver() {

        final WebDriver webDriver;
        switch (targetBrowser.toLowerCase()) {
            case "chrome":
                webDriver = new ChromeDriver();
                break;
            case "firefox":
                webDriver = new FirefoxDriver();
                break;
            case "safari":
                webDriver = new SafariDriver();
                break;
            case "edge":
                webDriver = new EdgeDriver();
                break;
            case "remote-chrome":
            case "remote-firefox":
                webDriver = createRemoteDriver();
                break;
            default:
                throw new IllegalArgumentException("Target browser " + targetBrowser + " not recognized");
        }

        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
        webDriver.manage().timeouts().setScriptTimeout(60, TimeUnit.SECONDS);
        webDriver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        webDriver.getWindowHandle();

        return webDriver;
    }

    private WebDriver createRemoteDriver() {
        try {
            ChromeOptions options = new ChromeOptions();
            RemoteWebDriver driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), options);
            driver.setFileDetector(new LocalFileDetector());
            return driver;
        } catch (MalformedURLException e) {
            throw new RuntimeException("Failed to create RemoteWebDriver instance", e);
        }

    }
}