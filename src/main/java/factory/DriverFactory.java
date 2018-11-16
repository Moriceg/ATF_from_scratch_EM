package factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.springframework.beans.factory.annotation.Autowired;
import utilities.Constants;

public class DriverFactory {

    public WebDriver getDriver() {
        return driverInitialize();
    }
    private WebDriver driver;

    public void setDriver(WebDriver driver) {
        this.driver = driver;
    }

    public String getBrowser() {
        return browser;
    }

    public void setBrowser(String browser) {
        this.browser = browser;
    }

    public String browser;
    public Constants constants;

    public DriverFactory(){}
    @Autowired
    public DriverFactory(String browser, Constants constants)
    {
        this.browser = browser;
        this.constants = constants;
    }

    private WebDriver driverInitialize()
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
