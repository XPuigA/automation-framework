package pages;

import common.ManagedDriverUITest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;
import pages.levels.Level15Page;

import java.util.List;

@Execution(ExecutionMode.CONCURRENT)
class Level15Tests extends ManagedDriverUITest {

    @Test
    void correctTest() {
        goTo(url + "level15");
        Level15Page page = new Level15Page(driver);
        page.selectSeats(page.getSeatsToSelect());
        page.clickContinue();
        Assertions.assertTrue(driver.getCurrentUrl().endsWith("level16"));
    }

    @Test
    void noSeatsSelected() {
        goTo(url + "level15");
        Level15Page page = new Level15Page(driver);
        page.clickContinue();
        Assertions.assertTrue(driver.getCurrentUrl().endsWith("level15"));
    }

    @Test
    void firstThreeSeats() {
        goTo(url + "level15");
        Level15Page page = new Level15Page(driver);
        List<String> enabledSeats = page.getAllEnabledSeats().subList(0, 3);
        page.selectSeats(enabledSeats);
        page.clickContinue();
        Assertions.assertTrue(driver.getCurrentUrl().endsWith("level15"));
    }
}
