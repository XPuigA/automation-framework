package automation_practice_tests;

import automation_practice.pages.levels.Level3Page;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;
import automation_practice.pages.levels.Level17Page;

@Execution(ExecutionMode.CONCURRENT)
class Level17Tests extends AutomationPracticeTest {

    Level17Page page;

    @BeforeEach
    void setUp() {
        goTo(url + "level17");
        page = new Level17Page(driver);
    }

    @Test
    void correctTest() {
        page.clickDirectionsAndContinue();
        Assertions.assertTrue(driver.getCurrentUrl().endsWith("level18"));
    }


}
