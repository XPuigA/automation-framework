package driver;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.logging.Logger;

/**
 * Proxy for Webdriver.
 * Each browser that we want to support should have a class that extends this.
 * That way we can modify the behaviour of one or more functions in only one browser.
 */
public abstract class Driver {

    private static final Logger LOGGER = Logger.getLogger("MainLogger");

    protected final WebDriver webDriver;

    protected final static By LOADER_BY = By.className("loader");

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

    /**
     * Find one element in the page that matches the locator
     * @param selector selector of the element we want to find
     * @return element that matched the locator
     */
    public WebElement findElement(String selector) {
        return findElement(By.cssSelector(selector));
    }

    /**
     * Find one element in the page that matches the locator
     * @param by locator of the element we want to find
     * @return element that matched the locator
     */
    private WebElement findElement(By by) {
        return webDriver.findElement(by);
    }

    /**
     * Finds all elements in the page that matches the locator
     * @param selector selector of the elements we want to find
     * @return elements that matched the locator
     */
    public List<WebElement> findElements(String selector) {
        return findElements(By.cssSelector(selector));
    }

    /**
     * Finds all elements in the page that matches the locator
     * @param by locator of the elements we want to find
     * @return elements that matched the locator
     */
    public List<WebElement> findElements(By by) {
        return webDriver.findElements(by);
    }

    /**
     * Checks if an element is present in the page
     * @param selector selector of the element we want to check if exists
     * @return boolean indicating if the element was present (true) or not (false)
     */
    public boolean elementExists(String selector) {
        return findElements(selector).size() > 0;
    }

    /**
     * Checks if an element is present in the page
     * @param by locator of the element we want to check if exists
     * @return boolean indicating if the element was present (true) or not (false)
     */
    public boolean elementExists(By by) {
        return findElements(by).size() > 0;
    }

    /**
     * Clicks an element in the page
     * @param selector selector of the element to click
     */
    public void click(String selector) {
        click(By.cssSelector(selector));
    }

    /**
     * Clicks an element in the page
     * @param by locator of the element to click
     */
    public void click(By by) {
        click(findElement(by));
    }

    /**
     * Clicks an element in the page
     * @param element element to click
     */
    public void click(WebElement element) {
        element.click();
    }

    /**
     * Gets the URL of the current page
     * @return the url of the current page
     */
    public String getCurrentUrl() {
        return webDriver.getCurrentUrl();
    }

    /**
     * Wait for an element to be present in the page
     * @param selector selector of the element to wait
     * @return the element we were waiting for
     */
    public WebElement waitForElement(String selector) {
        return waitForElement(By.cssSelector(selector));
    }

    /**
     * Wait for an element to be present in the page
     * @param by locator of the element to wait
     * @return the element we were waiting for
     */
    public WebElement waitForElement(By by) {
        return new WebDriverWait(webDriver, 30)
                .pollingEvery(Duration.ofSeconds(1))
                .until(ExpectedConditions.presenceOfElementLocated(by));
    }

    /**
     * Wait for an element to disappear in the page
     * @param element element we expect to disappear
     */
    public void waitForElementToDisappear(WebElement element) {
        new WebDriverWait(webDriver, 30)
                .pollingEvery(Duration.ofSeconds(1))
                .until(ExpectedConditions.invisibilityOf(element));
    }

    /**
     * Clears an input and writes a text into an element
     * @param locator locator of the element to clear and write into
     * @param text text to write
     */
    public void clearAndWrite(String locator, String text) {
        clearAndWrite(By.cssSelector(locator), text);
    }

    /**
     * Clears an input and writes a text into an element
     * @param selector selector of the element to clear and write into
     * @param text text to write
     */
    public void clearAndWrite(By selector, String text) {
        clearAndWrite(findElement(selector), text);
    }

    /**
     * Clears an input and writes a text into an element
     * @param element element to clear and write into
     * @param text text to write
     */
    public void clearAndWrite(WebElement element, String text) {
        element.clear();
        element.sendKeys(text);
    }

    /**
     * Writes a text into an element
     * @param locator locator of the element to write into
     * @param text text to write
     */
    public void write(String locator, String text) {
        write(By.cssSelector(locator), text);
    }

    /**
     * Writes a text into an element
     * @param selector selector of the element to write into
     * @param text text to write
     */
    public void write(By selector, String text) {
        write(findElement(selector), text);
    }

    /**
     * Writes a text into an element
     * @param element element to write into
     * @param text text to write
     */
    public void write(WebElement element, String text) {
        element.sendKeys(text);
    }

    /**
     * Waits for an alert to be present in the page
     */
    public void waitForAlert() {
        new WebDriverWait(webDriver, 10)
                .pollingEvery(Duration.ofSeconds(1))
                .until(ExpectedConditions.alertIsPresent());
    }

    /**
     * Writes a text into an alert present in the page
     * @param text what will be written in the alert
     */
    public void writeInAlert(String text) {
        waitForAlert();
        webDriver.switchTo().alert().sendKeys(text);
    }

    /**
     * Accepts and alert present in the page
     */
    public void acceptAlert() {
        waitForAlert();
        webDriver.switchTo().alert().accept();
    }

    /**
     * Closes an alert present in the page
     */
    public void dismissAlert() {
        waitForAlert();
        webDriver.switchTo().alert().dismiss();
    }

    /**
     * Makes drag and drop of one element onto another
     * @param elementToMove selector of the element we want to drag
     * @param destinationElement selector of the element we want to drop to
     */
    public void dragAndDrop(String elementToMove, String destinationElement) {
        dragAndDrop(By.cssSelector(elementToMove), By.cssSelector(destinationElement));
    }

    /**
     * Makes drag and drop of one element onto another
     * @param elementToMove locator of the element we want to drag
     * @param destinationElement locator of the element we want to drop to
     */
    public void dragAndDrop(By elementToMove, By destinationElement) {
        dragAndDrop(findElement(elementToMove), findElement(destinationElement));
    }

    /**
     * Makes drag and drop of one element onto another
     * @param elementToMove element we want to drag
     * @param destinationElement element we want to drop to
     */
    public void dragAndDrop(WebElement elementToMove, WebElement destinationElement) {
        Actions actions = new Actions(webDriver);
        actions.dragAndDrop(elementToMove, destinationElement).build().perform();
        actions.release().build().perform();
    }

    /**
     * Executes javascript code in the page
     * @param code script to execute
     */
    public void executeJavascript(String code) {
        ((JavascriptExecutor)webDriver).executeScript(code);
    }

    /**
     * Wait for the loader element to no longer be in the page
     */
    public void waitForLoaderToDissapear() {
        try {
            waitForElementToDisappear(findElement(LOADER_BY));
        } catch (NoSuchElementException nsr){
            // If the element was not present, there is nothing to wait for
        }
    }

    /**
     * Takes a screenshot of the page viewport
     *
     * @return path and filename of the taken screenshot
     */
    public String screenShot() {
        return screenShot("");
    }

    /**
     * Takes a screenshot of the page viewport
     *
     * @param prefix string that will be added as part of the name before the timestamp
     * @return path and filename of the taken screenshot
     */
    public String screenShot(String prefix) {
        String date = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd_HH-mm-ss-SSS"));
        String screenShotPath = System.getProperty("screenshot.folder") + "\\" + (!prefix.isEmpty() ? prefix + "_" : "") + date + ".png";

        try {
            File screenshot = ((TakesScreenshot) webDriver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(screenshot, new File(screenShotPath));
            return screenShotPath;
        } catch (IOException e) {
            LOGGER.severe("[IMG] Could not take screenshot. " + e.getMessage());
        }
        return null;
    }

    /**
     * Saves the html code of the current page
     *
     * @param prefix string that will be added as part of the name before the timestamp
     * @return path and filename of the saved html
     */
    public String saveHtml(String prefix) {
        String date = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd_HH-mm-ss-SSS"));
        String htmlPath = System.getProperty("html.folder") + "\\" + (!prefix.isEmpty() ? prefix + "_" : "") + date + ".html";
        File sourceFile = new File(htmlPath);
        try (FileWriter writer = new FileWriter(sourceFile)){
            writer.write(webDriver.getPageSource());
            return htmlPath;
        } catch (IOException e) {
            LOGGER.severe("[HTML] Could not save page source. " + e.getMessage());
        }
        return null;
    }
}
