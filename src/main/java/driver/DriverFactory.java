package driver;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.util.HashMap;
import java.util.Map;

public class DriverFactory {

    private DriverFactory() {}

    public static Driver getDriver(Browser browser) {
        switch(browser) {
            case CHROME:
                return chromeDriver();
            case FIREFOX:
                return firefoxDriver();
        }
        return defaultDriver();
    }

    public static Driver defaultDriver() {
        return firefoxDriver();
    }

    private static ChromeOptions getChromeOptions() {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setAcceptInsecureCerts(true);
        chromeOptions.addArguments("--incognito");

        Map<String, Object> experimentalOptions = new HashMap<>();
        experimentalOptions.put("download.default_directory", System.getProperty("java.io.tmpdir"));
        experimentalOptions.put("download.prompt_for_download", false);
        experimentalOptions.put("plugins.always_open_pdf_externally", true);
        chromeOptions.setExperimentalOption("prefs", experimentalOptions);
        return chromeOptions;
    }

    private static FirefoxOptions getFirefoxOptions() {
        FirefoxOptions firefoxOptions = new FirefoxOptions();
        firefoxOptions.setAcceptInsecureCerts(true);
        firefoxOptions.addPreference("browser.private.browsing.autostart", true);
        return firefoxOptions;
    }

    public static Driver chromeDriver() {
        ChromeDriver driver = new ChromeDriver(getChromeOptions());
        driver.manage().window().maximize();
        return new DriverForChrome(driver);
    }

    public static Driver firefoxDriver() {
        FirefoxDriver driver = new FirefoxDriver(getFirefoxOptions());
        driver.manage().window().maximize();
        return new DriverForFirefox(driver);
    }
}
