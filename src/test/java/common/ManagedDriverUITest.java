package common;

import driver.Browser;
import driver.Driver;
import driver.DriverFactory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.extension.ExtendWith;

@ExtendWith(UITestWatcher.class)
@ExtendWith(UIAfterTestExecutionCallback.class)
public abstract class ManagedDriverUITest extends AbstractTest {

    protected Driver driver = null;

    protected String url = "https://automation-practice.web.app/";

    protected void newDriver() {
        this.driver = DriverFactory.defaultDriver();
    }

    protected void newDriver(Browser browser) {
        this.driver = DriverFactory.getDriver(browser);
    }

    protected void newDriver(String url) {
        newDriver();
        driver.get(url);
    }

    protected void newDriver(Browser browser, String url) {
        newDriver(browser);
        driver.get(url);
    }

    public Driver getDriver() {
        return driver;
    }

    @AfterEach
    public void closeDriver() {
        // Takes care of the driver when the test finishes
        if (driver != null) {
                driver.close();
        }
    }
}
