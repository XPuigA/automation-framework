package pages;

import common.ManagedDriverUITest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;
import pages.levels.Level7Page;

@Execution(ExecutionMode.CONCURRENT)
class Level7Tests extends ManagedDriverUITest {

    @Test
    void correctTest() {
        newDriver(url + "level7");
        Level7Page page = new Level7Page(driver);
        page.acceptDialog();
    }

    @Test
    void cancelDialogTest() {
        newDriver(url + "level7");
        Level7Page page = new Level7Page(driver);
        page.cancelDialog();
        Assertions.assertTrue(driver.getCurrentUrl().endsWith("level7"));
    }


}
