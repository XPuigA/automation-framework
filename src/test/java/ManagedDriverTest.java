import driver.Driver;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.extension.ExtendWith;

@ExtendWith(UITestWatcher.class)
@ExtendWith(UIAfterTestExecutionCallback.class)
public class ManagedDriverTest extends AbstractTest {

    protected Driver driver = null;

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
