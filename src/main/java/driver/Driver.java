package driver;

import org.openqa.selenium.WebDriver;

import java.util.logging.Logger;

public abstract class Driver {

    private static final Logger LOGGER = Logger.getLogger("MainLogger");

    protected WebDriver webDriver;

    protected Driver(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

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
     *
     * @param url to visit
     */
    public void get(String url) {
        webDriver.get(url);
    }
}
