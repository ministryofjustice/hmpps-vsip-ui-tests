package driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import stepDefinitions.WebDriverInstance;

import java.util.concurrent.TimeUnit;

/**
 * Created by Anusha Nagula on 15/05/23.
 */
public class Driver implements WebDriverInstance {

    public static String targetBrowser = System.getProperty("browser", "chrome").toLowerCase();
    //private String pwd = System.getProperty("user.dir");
    //System.setProperty("webdriver.chrome.driver", pwd + "/drivers/chromedriver");

    private static WebDriver webDriver;

    public static WebDriver GetWebDriver() {
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            if (webDriver != null) {
                webDriver.quit();
            }
        }));

        switch (targetBrowser) {
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
 //           Required for security tests
//            case "zap-firefox":
//            case "zap-chrome":
            case "remote-chrome":
            case "remote-firefox":
                //webDriver = createRemoteDriver();
                break;
            default:
                throw new IllegalArgumentException("Target browser " + targetBrowser + " not recognized");
        }

//        webDriver.manage().deleteAllCookies();
        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
        webDriver.manage().timeouts().setScriptTimeout(60, TimeUnit.SECONDS);
        webDriver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        webDriver.getWindowHandle();

        return webDriver;
    }

    private WebDriver createRemoteDriver() {
        // Implement remote driver creation logic here
        return webDriver;

    }

}
