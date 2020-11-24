package pages;

import common.ManagedDriverUITest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;
import pages.levels.Level10Page;

import java.time.LocalDate;

@Execution(ExecutionMode.CONCURRENT)
class Level10Tests extends ManagedDriverUITest {

    @Test
    void correctTest() {
        goTo(url + "level10");
        Level10Page page = new Level10Page(driver);
        LocalDate date = page.getDateInPage();
        page.setDateInInput(date);
        Assertions.assertTrue(driver.getCurrentUrl().endsWith("level11"));
    }

    @Test
    void incorrectTest() {
        goTo(url + "level10");
        Level10Page page = new Level10Page(driver);
        page.setDateInInput(LocalDate.now());
        Assertions.assertTrue(driver.getCurrentUrl().endsWith("level10"));
    }
}
