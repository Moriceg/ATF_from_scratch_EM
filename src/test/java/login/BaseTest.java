package login;

import factory.DriverFactory;
import org.openqa.selenium.WebDriver;
import uimap.UiMap;

public class BaseTest {


    public WebDriver driver;
    public UiMap uiMap;


    public void initialize() {
        //driver = new DriverFactory().get_driver();
        driver.manage().window().maximize();
        uiMap = new UiMap(driver);
    }

    public WebDriver getDriver(){
        return driver;
    }

    public void setDriver(WebDriver driver)
    {
        this.driver = driver;
    }


}
