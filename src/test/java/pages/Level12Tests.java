package pages;

import common.ManagedDriverUITest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;
import pages.levels.Level12Page;

@Execution(ExecutionMode.CONCURRENT)
class Level12Tests extends ManagedDriverUITest {

    @Test
    void correctTest() {
        newDriver(url + "level12");
        Level12Page page = new Level12Page(driver);
        page.clickAllButtonsInOrder();
        Assertions.assertTrue(driver.getCurrentUrl().endsWith("level13"));
    }

    @Test
    void clickOnly4Buttons () {
        newDriver(url + "level12");
        Level12Page page = new Level12Page(driver);
        page.clickButtonAtPosition(1);
        page.clickButtonAtPosition(2);
        page.clickButtonAtPosition(4);
        page.clickButtonAtPosition(5);
        Assertions.assertTrue(driver.getCurrentUrl().endsWith("level12"));
    }
}
