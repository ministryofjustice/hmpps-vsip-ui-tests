package uk.gov.justice.digital.hmpps.vsip.config;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.LocalFileDetector;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Scope;
import uk.gov.justice.digital.hmpps.vsip.annotation.LazyConfiguration;
import uk.gov.justice.digital.hmpps.vsip.annotation.WebdriverScopeBean;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

@LazyConfiguration
public class WebDriverConfig {

    private static final Logger LOG = LoggerFactory.getLogger(WebDriverConfig.class);
    @Value("${default.timeout:20}")
    private int timeout;
    @Value("${browser:chrome}")
    private String targetBrowser;
    @Value("${remote.driver.url:http://localhost:4444/wd/hub}")
    private String remoteDriverURl;

    /**
     * Method as static to allow the bean to be created without first creating an instance of your @Configuration
     **/
    @Bean
    public static BeanFactoryPostProcessor beanFactoryPostProcessor() {
        return new WebDriverScopePostProcessor();
    }

    @WebdriverScopeBean
    @Primary
    public WebDriver createDriverBean() {
        return getWebDriver();
    }

    /**
     * The prototype scope type will return a different bean everytime it is autowired
     */
    @Bean
    @Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
    public WebDriverWait webdriverWait(WebDriver driver) {
        return new WebDriverWait(driver, Duration.ofMillis(this.timeout));
    }


    private WebDriver getWebDriver() {

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
        webDriver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(60));
        webDriver.manage().timeouts().setScriptTimeout(Duration.ofSeconds(60));
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        webDriver.getWindowHandle();

        LOG.debug("Enter createDriverBean , Created Webdriver :" + webDriver.getClass().getSimpleName() + "/" + targetBrowser);

        return webDriver;
    }

    private WebDriver createRemoteDriver() {
        try {
            ChromeOptions options = new ChromeOptions();
            RemoteWebDriver driver = new RemoteWebDriver(new URL(remoteDriverURl), options);
            driver.setFileDetector(new LocalFileDetector());
            return driver;
        } catch (MalformedURLException e) {
            throw new RuntimeException("Failed to create RemoteWebDriver instance URL:" + remoteDriverURl, e);
        }

    }
}