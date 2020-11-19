package pages;

import common.ManagedDriverUITest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;
import pages.levels.Level2Page;

@Execution(ExecutionMode.CONCURRENT)
class Level2Tests extends ManagedDriverUITest {

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
