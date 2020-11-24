package pages;

import common.ManagedDriverUITest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;
import pages.levels.Level4Page;

@Execution(ExecutionMode.CONCURRENT)
class Level4Tests extends ManagedDriverUITest {

    @Test
    void correctTest() {
        goTo(url + "level4");
        Level4Page page = new Level4Page(driver);
        page.clickAllButtons();
        Assertions.assertTrue(driver.getCurrentUrl().endsWith("level5"));
    }

    @Test
    void oneButtonClickedTest() {
        goTo(url + "level4");
        Level4Page page = new Level4Page(driver);
        page.clickButtonInIndex(3);
        Assertions.assertTrue(driver.getCurrentUrl().endsWith("level4"));
    }
}
