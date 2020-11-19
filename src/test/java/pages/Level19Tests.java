package pages;

import common.ManagedDriverUITest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;
import pages.levels.Level19Page;

@Execution(ExecutionMode.CONCURRENT)
class Level19Tests extends ManagedDriverUITest {

    @Test
    void correctTest() {
        newDriver(url + "level19");
        Level19Page page = new Level19Page(driver);
        page.setTextInInput(page.getCookieValue());
        page.clickContinue();
        Assertions.assertTrue(driver.getCurrentUrl().endsWith("level20"));
    }

    @Test
    void emptyText() {
        newDriver(url + "level19");
        Level19Page page = new Level19Page(driver);
        page.clickContinue();
        Assertions.assertTrue(driver.getCurrentUrl().endsWith("level19"));
    }

    @Test
    void wrongValue() {
        newDriver(url + "level19");
        Level19Page page = new Level19Page(driver);
        page.setTextInInput("AAAAAA");
        page.clickContinue();
        Assertions.assertTrue(driver.getCurrentUrl().endsWith("level19"));
    }

}
