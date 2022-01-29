package pages;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import static core.PageFactory.at;

public class LoginPage extends BasePage {

    private static final String LOGIN_STATUS = "Authorized successfully";
    private final By emailInput = By.id("ap_email");
    private final By passwordInput = By.id("ap_password");
    private final By signInButton = By.id("nav-signin-tooltip");
    private final By loginStatusButton = By.name("login_status");

    public LoginPage(WebDriver webDriver, WebDriverWait webDriverWait, WebElement webElement) {
        super(webDriver, webDriverWait, webElement);
    }

    public LoginPage login(final String username, final String password) {
        click(signInButton);
        clickAndType(emailInput, username);
        clickAndType(passwordInput, password);

        return at(LoginPage.class);
    }

    public void getLoginStatus() {
        getLocatorText(loginStatusButton, LOGIN_STATUS);
    }
}
