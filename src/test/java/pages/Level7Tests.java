package pages;

import common.ManagedDriverTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pages.levels.Level6Page;
import pages.levels.Level7Page;

class Level7Tests extends ManagedDriverTest {

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
