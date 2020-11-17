package pages;

import common.ManagedDriverTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pages.levels.Level12Page;
import pages.levels.Level13Page;

class Level13Tests extends ManagedDriverTest {

    @Test
    void correctTest() {
        newDriver(url + "level13");
        Level13Page page = new Level13Page(driver);
        page.waitForLoaderAndClickContinue();
        Assertions.assertTrue(driver.getCurrentUrl().endsWith("level14"));
    }
}
