package com.atf.factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;
import com.atf.utilities.Constants;

@Component
@PropertySource("classpath:environment.properties")
public class DriverFactory {

    public WebDriver getDriver() {
        return driver;
    }
    private WebDriver driver;

    public String getBrowser() {
        return browser;
    }

    public void setBrowser(String browser) {
        this.browser = browser;
    }

    @Value("${defaultBrowser}")
    public String browser;
    @Autowired
    public Constants constants;

    public WebDriver driverInitialize()
    {
        switch(browser)
        {
            case "firefox":
            {
                String path = constants.FIREFOX_DRIVER_DIRECTORY;
                System.setProperty("webdriver.gecko.driver", path);
                driver =  new FirefoxDriver();
                break;
            }

            case "ie":
            {
                String path = constants.IE_DRIVER_DIRECTORY;
                System.setProperty("webdriver.ie.driver", path);
                InternetExplorerOptions ieOptions = new InternetExplorerOptions();
                ieOptions.ignoreZoomSettings();
                ieOptions.introduceFlakinessByIgnoringSecurityDomains();
                ieOptions.withInitialBrowserUrl("about:blank");
                driver =  new InternetExplorerDriver(ieOptions);
                break;
            }

            default:
            {
                String path = constants.CHROME_DRIVER_DIRECTORY;
                System.setProperty("webdriver.chrome.driver", path);
                driver = new ChromeDriver();
                break;
            }
        }
        return driver;
    }

    public void quit()
    {
        driver.quit();
    }
}
