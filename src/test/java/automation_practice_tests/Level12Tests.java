package automation_practice_tests;

import automation_practice.pages.levels.Level3Page;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;
import automation_practice.pages.levels.Level12Page;

@Execution(ExecutionMode.CONCURRENT)
class Level12Tests extends AutomationPracticeTest {

    Level12Page page;

    @BeforeEach
    void setUp() {
        goTo(url + "level12");
        page = new Level12Page(driver);
    }

    @Test
    void correctTest() {
        page.clickAllButtonsInOrder();
        Assertions.assertTrue(driver.getCurrentUrl().endsWith("level13"));
    }

    @Test
    void clickOnly4Buttons () {
        page.clickButtonAtPosition(1);
        page.clickButtonAtPosition(2);
        page.clickButtonAtPosition(4);
        page.clickButtonAtPosition(5);
        Assertions.assertTrue(driver.getCurrentUrl().endsWith("level12"));
    }
}
