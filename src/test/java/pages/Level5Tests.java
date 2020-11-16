package pages;

import common.ManagedDriverTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pages.levels.Level5Page;

class Level5Tests extends ManagedDriverTest {

    @Test
    void correctTest() {
        newDriver(url + "level5");
        Level5Page page = new Level5Page(driver);
        page.clickRedButtons();
        Assertions.assertTrue(driver.getCurrentUrl().endsWith("level6"));
    }

    @Test
    void oneButtonClickedTest() {
        newDriver(url + "level5");
        Level5Page page = new Level5Page(driver);
        page.clickOneRedButton();
        Assertions.assertTrue(driver.getCurrentUrl().endsWith("level5"));
    }

    @Test
    void allButtonsRedTest() {
        newDriver(url + "level5");
        Level5Page page = new Level5Page(driver);
        page.clickAllGreenButtons();
        Assertions.assertTrue(driver.getCurrentUrl().endsWith("level5"));
    }
}
