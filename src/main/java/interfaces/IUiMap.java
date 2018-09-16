package interfaces;

import org.openqa.selenium.WebElement;

import java.util.List;

public interface IUiMap {

    List<WebElement> getElements(String xpath);
    WebElement getElement(String xpath);
    void click(WebElement element);
    void inputData(WebElement element, String value);

}
