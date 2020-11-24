package pages;

import common.ManagedDriverUITest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;
import pages.levels.Level3Page;

@Execution(ExecutionMode.CONCURRENT)
class Level3Tests extends ManagedDriverUITest {

    @Test
    void correctTest() {
        goTo(url + "level3");
        Level3Page page = new Level3Page(driver);
        page.fillInputTextbox(page.getGeneratedToken());
        page.clickContinueButton();
        Assertions.assertTrue(driver.getCurrentUrl().endsWith("level4"));
    }

    @Test
    void emptyInputTest() {
        goTo(url + "level3");
        Level3Page page = new Level3Page(driver);
        page.clickContinueButton();
        Assertions.assertTrue(driver.getCurrentUrl().endsWith("level3"));
    }

    @Test
    void wrongInputTest() {
        goTo(url + "level3");
        Level3Page page = new Level3Page(driver);
        page.fillInputTextbox("whatever");
        page.clickContinueButton();
        Assertions.assertTrue(driver.getCurrentUrl().endsWith("level3"));
    }
}
