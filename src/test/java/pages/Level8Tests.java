package pages;

import common.ManagedDriverTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pages.levels.Level7Page;
import pages.levels.Level8Page;

class Level8Tests extends ManagedDriverTest {

    @Test
    void correctTest() {
        newDriver(url + "level8");
        Level8Page page = new Level8Page(driver);
        page.writeInDialog("automation-rocks");
        page.acceptDialog();
        Assertions.assertTrue(driver.getCurrentUrl().endsWith("level9"));
    }

    @Test
    void cancelDialogTest() {
        newDriver(url + "level8");
        Level8Page page = new Level8Page(driver);
        page.cancelDialog();
        Assertions.assertTrue(driver.getCurrentUrl().endsWith("level8"));
    }

    @Test
    void wrongInputTest() {
        newDriver(url + "level8");
        Level8Page page = new Level8Page(driver);
        page.writeInDialog("random-text");
        page.acceptDialog();
        Assertions.assertTrue(driver.getCurrentUrl().endsWith("level8"));
    }


}
