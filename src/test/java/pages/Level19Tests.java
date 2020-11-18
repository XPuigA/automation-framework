package pages;

import common.ManagedDriverTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pages.levels.Level18Page;
import pages.levels.Level19Page;

class Level19Tests extends ManagedDriverTest {

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
