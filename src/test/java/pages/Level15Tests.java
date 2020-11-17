package pages;

import common.ManagedDriverTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pages.levels.Level14Page;
import pages.levels.Level15Page;

import java.util.List;

class Level15Tests extends ManagedDriverTest {

    @Test
    void correctTest() {
        newDriver(url + "level15");
        Level15Page page = new Level15Page(driver);
        page.selectSeats(page.getSeatsToSelect());
        page.clickContinue();
        Assertions.assertTrue(driver.getCurrentUrl().endsWith("level16"));
    }

    @Test
    void noSeatsSelected() {
        newDriver(url + "level15");
        Level15Page page = new Level15Page(driver);
        page.clickContinue();
        Assertions.assertTrue(driver.getCurrentUrl().endsWith("level15"));
    }

    @Test
    void firstThreeSeats() {
        newDriver(url + "level15");
        Level15Page page = new Level15Page(driver);
        List<String> enabledSeats = page.getAllEnabledSeats().subList(0, 3);
        page.selectSeats(enabledSeats);
        page.clickContinue();
        Assertions.assertTrue(driver.getCurrentUrl().endsWith("level15"));
    }
}
