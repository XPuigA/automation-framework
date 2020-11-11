package pages;

import common.ManagedDriverTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pages.levels.Level2Page;
import pages.levels.Level3Page;

class Level3Tests extends ManagedDriverTest {

    @Test
    void correctTest() {
        newDriver(url + "level3");
        Level3Page page = new Level3Page(driver);
        page.fillInputTextbox(page.getGeneratedToken());
        page.clickContinueButton();
        Assertions.assertTrue(driver.getCurrentUrl().endsWith("level4"));
    }

    @Test
    void emptyInputTest() {
        newDriver(url + "level3");
        Level3Page page = new Level3Page(driver);
        page.clickContinueButton();
        Assertions.assertTrue(driver.getCurrentUrl().endsWith("level3"));
    }

    @Test
    void wrongInputTest() {
        newDriver(url + "level3");
        Level3Page page = new Level3Page(driver);
        page.fillInputTextbox("whatever");
        page.clickContinueButton();
        Assertions.assertTrue(driver.getCurrentUrl().endsWith("level3"));
    }
}
