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

    public WebElement waitForElement(String selector) {
        return waitForElement(By.cssSelector(selector));
    }

    public WebElement waitForElement(By by) {
        return new WebDriverWait(webDriver, 30)
                .pollingEvery(Duration.ofSeconds(1))
                .until(ExpectedConditions.presenceOfElementLocated(by));
    }

    public void waitForElementToDissapear(WebElement element) {
        new WebDriverWait(webDriver, 30)
                .pollingEvery(Duration.ofSeconds(1))
                .until(ExpectedConditions.invisibilityOf(element));
    }

    public void clearAndWrite(String locator, String text) {
        clearAndWrite(By.cssSelector(locator), text);
    }

    public void clearAndWrite(By selector, String text) {
        clearAndWrite(findElement(selector), text);
    }

    public void clearAndWrite(WebElement element, String text) {
        element.clear();
        element.sendKeys(text);
    }

    public void write(String locator, String text) {
        write(By.cssSelector(locator), text);
    }

    public void write(By selector, String text) {
        write(findElement(selector), text);
    }

    public void write(WebElement element, String text) {
        element.sendKeys(text);
    }

    public void waitForAlert() {
        new WebDriverWait(webDriver, 10)
                .pollingEvery(Duration.ofSeconds(1))
                .until(ExpectedConditions.alertIsPresent());
    }

    public void writeInAlert(String text) {
        waitForAlert();
        webDriver.switchTo().alert().sendKeys(text);
    }

    public void acceptAlert() {
        waitForAlert();
        webDriver.switchTo().alert().accept();
    }

    public void dismissAlert() {
        waitForAlert();
        webDriver.switchTo().alert().dismiss();
    }

    public void dragAndDrop(String elementToMove, String destinationElement) {
        dragAndDrop(By.cssSelector(elementToMove), By.cssSelector(destinationElement));
    }

    public void dragAndDrop(By elementToMove, By destinationElement) {
        dragAndDrop(findElement(elementToMove), findElement(destinationElement));
    }

    public void dragAndDrop(WebElement elementToMove, WebElement destinationElement) {
        Actions actions = new Actions(webDriver);
        actions.dragAndDrop(elementToMove, destinationElement).build().perform();
        actions.release().build().perform();
    }

    public void executeJavascript(String s) {
        ((JavascriptExecutor)webDriver).executeScript(s);
    }

    public void waitForLoaderToDissapear() {
        try {
            waitForElementToDissapear(findElement(LOADER_BY));
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
