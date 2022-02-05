package pages;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SearchPage extends BasePage {

    private final By inputSearch = By.id("twotabsearchtextbox");

    public SearchPage(WebDriver webDriver, WebDriverWait webDriverWait, WebElement webElement) {
        super(webDriver, webDriverWait, webElement);
    }
    public SearchPage searchItem(final String item) {
        typeText(inputSearch, item);
        return this;
    }
}
