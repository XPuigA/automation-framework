package driver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.logging.Logger;

public abstract class Driver {

    private static final Logger LOGGER = Logger.getLogger("MainLogger");

    protected WebDriver webDriver;

    protected Driver(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    /**
     * Returns the internal WebDriver
     * @return webDriver
     */
    public WebDriver getWebDriver() {
        return webDriver;
    }

    /**
     * Closes the driver
     */
    public void close() {
        try {
            webDriver.close(); // Close current execution window
        } catch(Exception e) {
            LOGGER.info(e.getMessage());
        } finally {
            webDriver.quit();  // Safely close drive session
        }
    }

    /**
     * Goes to the parameter url
     * @param url to visit
     */
    public void get(String url) {
        webDriver.get(url);
    }

    public WebElement findElement(String selector) {
        return findElement(By.cssSelector(selector));
    }

    private WebElement findElement(By by) {
        return webDriver.findElement(by);
    }

    public List<WebElement> findElements(String selector) {
        return findElements(By.cssSelector(selector));
    }

    public List<WebElement> findElements(By by) {
        return webDriver.findElements(by);
    }


    public boolean elementExists(String s) {
        return findElements(s).size() > 0;
    }

    public boolean elementExists(By by) {
        return findElements(by).size() > 0;
    }

    public void click(String selector) {
        click(By.cssSelector(selector));
    }

    public void click(By by) {
        click(findElement(by));
    }

    public void click(WebElement element) {
        element.click();
    }

    public String getCurrentUrl() {
        return webDriver.getCurrentUrl();
    }

    public void waitForElement(String selector) {
        waitForElement(By.cssSelector(selector));
    }

    public void waitForElement(By by) {
        new WebDriverWait(webDriver, 30)
                .pollingEvery(Duration.ofSeconds(1))
                .until(ExpectedConditions.presenceOfElementLocated(by));
    }

    public void waitForElementToDissapear(WebElement element) {
        new WebDriverWait(webDriver, 30)
                .pollingEvery(Duration.ofSeconds(1))
                .until(ExpectedConditions.invisibilityOf(element));
    }
}
