package uimap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class UiMap {

    private WebDriver _driver;

    public UiMap(WebDriver driver)
    {
        _driver = driver;
    }

    public List<WebElement> getElements(String xPath)
    {
        return _driver.findElements(By.xpath(xPath));
    }

    public WebElement getElement(String xPath)
    {
        return _driver.findElement(By.xpath(xPath));
    }

}
