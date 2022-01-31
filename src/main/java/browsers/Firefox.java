package browsers;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.remote.DesiredCapabilities;

public class Firefox implements WebDriverProvider {
    @Override
    public WebDriver createDriver(final DesiredCapabilities capabilities) {
        WebDriverManager.firefoxdriver().setup();

        return new FirefoxDriver(getFirefoxOptions().merge(capabilities));
    }

    public static FirefoxOptions getFirefoxOptions() {
        final FirefoxOptions firefoxOptions = new FirefoxOptions();
        firefoxOptions.addArguments("--disable-web-security");
        firefoxOptions.addArguments("--allow-running-insecure-content");

        final FirefoxProfile profile = new FirefoxProfile();
        profile.setAcceptUntrustedCertificates(true);
        profile.setAssumeUntrustedCertificateIssuer(false);
        profile.setPreference("pageLoadStrategy", "normal");

        firefoxOptions.setCapability(FirefoxDriver.Capability.PROFILE, profile);

        return firefoxOptions;
    }
}
