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

    public void click(WebElement element)
    {
        String elementType = element.getAttribute("type");
        switch (elementType)
        {
            case "submit":
            case "button":
                element.click();
                break;

            case "select":
            case "dropdown":
                //TO DO
                break;

            default:
                element.click();
                break;


        }
    }

    public void inputData(WebElement element, String value)
    {
        element.sendKeys(value);
    }
}
