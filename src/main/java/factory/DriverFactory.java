package factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;
import utilities.Constants;

public class DriverFactory {

    private WebDriver _driver;
    private String _browser;

    public DriverFactory(String browser)
    {
        _browser = browser;
        DriverInitialize();
    }

    private WebDriver DriverInitialize()
    {
        switch(_browser)
        {
            case "firefox":
            {
                String path = Constants.FIREFOX_DRIVER_DIRECTORY;
                System.setProperty("webdriver.gecko.driver", path);
                _driver =  new FirefoxDriver();
                break;
            }

            case "ie":
            {
                String path = Constants.IE_DRIVER_DIRECTORY;
                System.setProperty("webdriver.ie.driver", path);
                InternetExplorerOptions ieOptions = new InternetExplorerOptions();
                ieOptions.ignoreZoomSettings();
                ieOptions.introduceFlakinessByIgnoringSecurityDomains();
                ieOptions.withInitialBrowserUrl("about:blank");
                _driver =  new InternetExplorerDriver(ieOptions);
                break;
            }

            default:
            {
                String path = Constants.CHROME_DRIVER_DIRECTORY;
                System.setProperty("webdriver.chrome.driver", path);
                _driver = new ChromeDriver();
                break;
            }
        }
        return _driver;
    }

    public WebDriver get_driver() {
        return _driver;
    }

    public void set_driver(WebDriver _driver) {
        this._driver = _driver;
    }
}
