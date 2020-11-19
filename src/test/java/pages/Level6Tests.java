package pages;

import common.ManagedDriverUITest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;
import pages.levels.Level6Page;

@Execution(ExecutionMode.CONCURRENT)
class Level6Tests extends ManagedDriverUITest {

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
