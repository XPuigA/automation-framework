package automation_practice_tests;

import automation_practice.pages.levels.Level3Page;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;
import automation_practice.pages.levels.Level10Page;

import java.time.LocalDate;

@Execution(ExecutionMode.CONCURRENT)
class Level10Tests extends AutomationPracticeTest {

    Level10Page page;

    @BeforeEach
    void setUp() {
        goTo(url + "level10");
        page = new Level10Page(driver);
    }

    @Test
    void correctTest() {
        LocalDate date = page.getDateInPage();
        page.setDateInInput(date);
        Assertions.assertTrue(driver.getCurrentUrl().endsWith("level11"));
    }

    @Test
    void incorrectTest() {
        page.setDateInInput(LocalDate.now());
        Assertions.assertTrue(driver.getCurrentUrl().endsWith("level10"));
    }
}
