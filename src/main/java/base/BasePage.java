package base;

import core.Page;
import org.junit.gen5.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import waiters.WaitConditions;

import java.util.function.Function;

import static org.junit.gen5.api.Assertions.assertTrue;
import static waiters.WaitConditions.visible;

public class BasePage implements Page {

    private final WebDriver webDriver;
    private final WebDriverWait webDriverWait;
    private final WebElement webElement;

    public BasePage(WebDriver webDriver, WebDriverWait webDriverWait, WebElement webElement) {
        this.webDriver = webDriver;
        this.webDriverWait = webDriverWait;
        this.webElement = webElement;
    }

    public Page navigateTo(String url) {
        webDriver.get(url);
        return this;
    }

    public void click(final By locator) {
        click(locator, visible);
    }

    private void click(final By locator, final WaitConditions condition) {
        elementOf(waitFor(locator, "", condition));
    }

    protected void clickAndType(final By locator, final CharSequence text) {
        webDriver.findElement(locator).sendKeys(text);
    }

    protected void getLocatorText(final By locator, final String value) {
        assertTrue(webDriver.findElement(locator).getText().contains(value));
    }

    private static <T> WebElement elementOf(final T element) {
        return (WebElement) element;
    }

    private <T, V, R> R waitFor(final T arg1, final V arg2, final WaitConditions condition) {
        return (R) webDriverWait.ignoring(StaleElementReferenceException.class)
                .until((Function<WebDriver, ?>) condition.getType().apply(arg1, arg2));
    }
}
