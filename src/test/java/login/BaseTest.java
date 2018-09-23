import cucumber.api.java.After;
import cucumber.api.java.Before;
import factory.DriverFactory;
import org.openqa.selenium.WebDriver;
import pageobjects.LoginPageObject;
import uimap.UiMap;
import utilities.Constants;

public class BaseTest {

    public WebDriver driver;
    public String browserForTest = Constants.BROWSER;
    public LoginPageObject loginPage;
    public UiMap uiMap;


    @Before
    public void setUp() throws Exception {
        driver = new DriverFactory(browserForTest).get_driver();
        driver.manage().window().maximize();
        loginPage = new LoginPageObject();
        uiMap = new UiMap(driver);
    }

    @After
    public void tearDown() throws Exception {
        driver.quit();
    }
}
