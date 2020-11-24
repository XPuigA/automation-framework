package automation_practice_tests;

import automation_practice.pages.levels.Level3Page;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;
import automation_practice.pages.levels.Level15Page;

import java.util.List;

@Execution(ExecutionMode.CONCURRENT)
class Level15Tests extends AutomationPracticeTest {

    Level15Page page;

    @BeforeEach
    void setUp() {
        goTo(url + "level15");
        page = new Level15Page(driver);
    }

    @Test
    void correctTest() {
        page.selectSeats(page.getSeatsToSelect());
        page.clickContinue();
        Assertions.assertTrue(driver.getCurrentUrl().endsWith("level16"));
    }

    @Test
    void noSeatsSelected() {
        page.clickContinue();
        Assertions.assertTrue(driver.getCurrentUrl().endsWith("level15"));
    }

    @Test
    void firstThreeSeats() {
        List<String> enabledSeats = page.getAllEnabledSeats().subList(0, 3);
        page.selectSeats(enabledSeats);
        page.clickContinue();
        Assertions.assertTrue(driver.getCurrentUrl().endsWith("level15"));
    }
}
