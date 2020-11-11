package pages;

import common.ManagedDriverTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pages.levels.Level3Page;
import pages.levels.Level4Page;

class Level4Tests extends ManagedDriverTest {

    @Test
    void correctTest() {
        newDriver(url + "level4");
        Level4Page page = new Level4Page(driver);
        page.clickAllButtons();
        Assertions.assertTrue(driver.getCurrentUrl().endsWith("level5"));
    }

    @Test
    void oneButtonClickedTest() {
        newDriver(url + "level4");
        Level4Page page = new Level4Page(driver);
        page.clickButtonInIndex(3);
        Assertions.assertTrue(driver.getCurrentUrl().endsWith("level4"));
    }
}
