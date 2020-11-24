package common;

import driver.Browser;
import driver.Driver;
import driver.DriverFactory;
import org.junit.jupiter.api.extension.ExtendWith;

/**
 * All UI tests should inherit from this.
 */
@ExtendWith(UITestWatcher.class)
@ExtendWith(UIAfterTestExecutionCallback.class)
public class UITest extends AbstractTest {

    protected Driver driver = null;

    protected void newDriver() {
        this.driver = DriverFactory.defaultDriver();
    }

    protected void newDriver(Browser browser) {
        this.driver = DriverFactory.getDriver(browser);
    }

    protected void newDriver(String url) {
        newDriver();
        goTo(url);
    }

    protected void newDriver(Browser browser, String url) {
        newDriver(browser);
        goTo(url);
    }

    protected void goTo(String url) {
        driver.get(url);
    }

    public Driver getDriver() {
        return driver;
    }
}
