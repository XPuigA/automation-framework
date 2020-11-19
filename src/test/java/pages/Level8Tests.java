package pages;

import common.ManagedDriverUITest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;
import pages.levels.Level8Page;

@Execution(ExecutionMode.CONCURRENT)
class Level8Tests extends ManagedDriverUITest {

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
