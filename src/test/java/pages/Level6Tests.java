package pages;

import common.ManagedDriverTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pages.levels.Level6Page;

class Level6Tests extends ManagedDriverTest {

    @Test
    void correctTest() {
        newDriver(url + "level6");
        Level6Page page = new Level6Page(driver);
        page.findAndClickYesButton();
        Assertions.assertTrue(driver.getCurrentUrl().endsWith("level7"));
    }

    @Test
    void clickNoButtonHasNoEffect() {
        newDriver(url + "level6");
        Level6Page page = new Level6Page(driver);
        page.findAndClickNoButton();
        Assertions.assertTrue(driver.getCurrentUrl().endsWith("level6"));
    }
}
