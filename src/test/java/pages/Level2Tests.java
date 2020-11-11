package pages;

import common.ManagedDriverTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pages.levels.Level2Page;

class Level2Tests extends ManagedDriverTest {

    @Test
    void correctTest() {
        newDriver(url + "level2");
        Level2Page page = new Level2Page(driver);
        page.fillInputTextbox("automation");
        page.clickContinueButton();
        Assertions.assertTrue(driver.getCurrentUrl().endsWith("level3"));
    }

    @Test
    void emptyInputTest() {
        newDriver(url + "level2");
        Level2Page page = new Level2Page(driver);
        page.clickContinueButton();
        Assertions.assertTrue(driver.getCurrentUrl().endsWith("level2"));
    }

    @Test
    void wrongInputTest() {
        newDriver(url + "level2");
        Level2Page page = new Level2Page(driver);
        page.fillInputTextbox("whatever");
        page.clickContinueButton();
        Assertions.assertTrue(driver.getCurrentUrl().endsWith("level2"));
    }
}
