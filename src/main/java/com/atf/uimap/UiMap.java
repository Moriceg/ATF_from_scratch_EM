package com.atf.uimap;

import com.atf.interfaces.IUiMap;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UiMap implements IUiMap {


    public UiMap(WebDriver driver)
    {
        this.driver = driver;
    }

    private WebDriver driver;

    @Override
    public List<WebElement> getElements(String xPath)
    {
        return driver.findElements(By.xpath(xPath));
    }

    @Override
    public WebElement getElement(String xPath)
    {
        return driver.findElement(By.xpath(xPath));
    }

    @Override
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

    @Override
    public void inputData(WebElement element, String value)
    {
        element.sendKeys(value);
    }
}
