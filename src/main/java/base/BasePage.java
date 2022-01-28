package base;

import core.Page;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import waiters.WaitConditions;

import java.util.function.Function;

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

    private static <T> WebElement elementOf(final T element) {
        return (WebElement) element;
    }

    private <T, V, R> R waitFor(final T arg1, final V arg2, final WaitConditions condition) {
        return (R) webDriverWait.ignoring(StaleElementReferenceException.class)
                .until((Function<WebDriver, ?>) condition.getType().apply(arg1, arg2));
    }
}
