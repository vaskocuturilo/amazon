package pages;

import base.BasePage;
import model.Category;
import model.SortItems;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import static java.lang.String.format;

public class ProductPage extends BasePage {

    private static final String COMPLETE_STATUS = "Operation was successfully completed";
    private final By resultProducts = By.cssSelector("");
    private final By buyButton = By.id("");

    public ProductPage(WebDriver webDriver, WebDriverWait webDriverWait, WebElement webElement) {
        super(webDriver, webDriverWait, webElement);
    }

    public ProductPage filterBy(final Category category, final String value) {
        click(By.xpath(format("",
                category.getName(),
                value)));
        return this;
    }

    public ProductPage selectProduct() {
        click(resultProducts);
        return this;
    }

    public ProductPage selectCategory(final String value) {
        click(By.linkText(value));
        return this;
    }

    public ProductPage buy() {
        click(buyButton);
        return this;
    }

    public ProductPage sortBy(final SortItems value) {
        click(By.xpath(format("", value.getName())));
        return this;
    }

    public void getLoginStatus() {
        getLocatorText(buyButton, COMPLETE_STATUS);
    }

}
