package common;

import driver.Browser;
import driver.Driver;
import driver.DriverFactory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.extension.ExtendWith;

@ExtendWith(UITestWatcher.class)
@ExtendWith(UIAfterTestExecutionCallback.class)
public abstract class ManagedDriverTest extends AbstractTest {

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

    @AfterEach
    public void closeDriver() {
        // Takes care of the driver if there was an exception when executing the test
        if (driver != null) {
            try {
                driver.close();
            } catch (Exception ignored) {
                // If all was good, no driver will have to be closed
            }
        }
    }
}
