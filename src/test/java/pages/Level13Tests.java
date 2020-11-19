package pages;

import common.ManagedDriverUITest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;
import pages.levels.Level13Page;

@Execution(ExecutionMode.CONCURRENT)
class Level13Tests extends ManagedDriverUITest {

    @Test
    void correctTest() {
        newDriver(url + "level13");
        Level13Page page = new Level13Page(driver);
        page.waitForLoaderAndClickContinue();
        Assertions.assertTrue(driver.getCurrentUrl().endsWith("level14"));
    }
}
