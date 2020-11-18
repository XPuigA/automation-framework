package pages;

import common.ManagedDriverTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pages.levels.Level19Page;
import pages.levels.Level20Page;

class Level20Tests extends ManagedDriverTest {

    @Test
    void correctTest() {
        newDriver(url + "level20");
        Level20Page page = new Level20Page(driver);
        page.setCookieValue(page.getValueForCookie());
        page.clickContinue();
        Assertions.assertTrue(driver.getCurrentUrl().endsWith("end"));
    }

    @Test
    void noChange() {
        newDriver(url + "level20");
        Level20Page page = new Level20Page(driver);
        page.clickContinue();
        Assertions.assertTrue(driver.getCurrentUrl().endsWith("level20"));
    }

    @Test
    void emptyCookie() {
        newDriver(url + "level20");
        Level20Page page = new Level20Page(driver);
        page.setCookieValue("");
        page.clickContinue();
        Assertions.assertTrue(driver.getCurrentUrl().endsWith("level20"));
    }

    @Test
    void wrongValue() {
        newDriver(url + "level20");
        Level20Page page = new Level20Page(driver);
        page.setCookieValue("AAAAAA");
        page.clickContinue();
        Assertions.assertTrue(driver.getCurrentUrl().endsWith("level20"));
    }

}
