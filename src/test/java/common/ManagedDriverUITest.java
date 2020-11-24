package common;

import driver.Browser;
import driver.Driver;
import driver.DriverFactory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;

/**
 * Use this class if you want the driver to be automatically opened before the test and closed after it.
 */
@ExtendWith(UITestWatcher.class)
@ExtendWith(UIAfterTestExecutionCallback.class)
public abstract class ManagedDriverUITest extends UITest {

    @BeforeEach
    public void createDefaultDriver() {
        newDriver();
    }

    @AfterEach
    public void closeDriver() {
        // Takes care of the driver when the test finishes
        if (driver != null) {
                driver.close();
        }
    }
}
