package pages;

import common.ManagedDriverUITest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;
import pages.levels.Level20Page;

@Execution(ExecutionMode.CONCURRENT)
class Level20Tests extends ManagedDriverUITest {

    @Test
    void correctTest() {
        goTo(url + "level20");
        Level20Page page = new Level20Page(driver);
        page.setCookieValue(page.getValueForCookie());
        page.clickContinue();
        Assertions.assertTrue(driver.getCurrentUrl().endsWith("end"));
    }

    @Test
    void noChange() {
        goTo(url + "level20");
        Level20Page page = new Level20Page(driver);
        page.clickContinue();
        Assertions.assertTrue(driver.getCurrentUrl().endsWith("level20"));
    }

    @Test
    void emptyCookie() {
        goTo(url + "level20");
        Level20Page page = new Level20Page(driver);
        page.setCookieValue("");
        page.clickContinue();
        Assertions.assertTrue(driver.getCurrentUrl().endsWith("level20"));
    }

    @Test
    void wrongValue() {
        goTo(url + "level20");
        Level20Page page = new Level20Page(driver);
        page.setCookieValue("AAAAAA");
        page.clickContinue();
        Assertions.assertTrue(driver.getCurrentUrl().endsWith("level20"));
    }

}
