package automation_practice_tests;

import automation_practice.pages.levels.Level3Page;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;
import automation_practice.pages.levels.Level13Page;

@Execution(ExecutionMode.CONCURRENT)
class Level13Tests extends AutomationPracticeTest {

    Level13Page page;

    @BeforeEach
    void setUp() {
        goTo(url + "level13");
        page = new Level13Page(driver);
    }

    @Test
    void correctTest() {
        page.waitForLoaderAndClickContinue();
        Assertions.assertTrue(driver.getCurrentUrl().endsWith("level14"));
    }
}
