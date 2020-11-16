package pages;

import common.ManagedDriverTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import pages.levels.Level10Page;
import pages.levels.Level9Page;

import java.time.Duration;
import java.time.LocalDate;
import java.time.Period;
import java.time.temporal.TemporalAmount;

class Level10Tests extends ManagedDriverTest {

    @Test
    void correctTest() {
        newDriver(url + "level10");
        Level10Page page = new Level10Page(driver);
        LocalDate date = page.getDateInPage();
        page.setDateInInput(date);
        Assertions.assertTrue(driver.getCurrentUrl().endsWith("level11"));
    }

    @Test
    void incorrectTest() {
        newDriver(url + "level10");
        Level10Page page = new Level10Page(driver);
        page.setDateInInput(LocalDate.now().minus(Period.ofYears(4)));
        Assertions.assertTrue(driver.getCurrentUrl().endsWith("level10"));
    }
}
