package automation_practice_tests;

import automation_practice.pages.levels.Level3Page;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;
import automation_practice.pages.levels.Level16Page;

@Execution(ExecutionMode.CONCURRENT)
class Level16Tests extends AutomationPracticeTest {

    Level16Page page;

    @BeforeEach
    void setUp() {
        goTo(url + "level16");
        page = new Level16Page(driver);
    }

    @Test
    void correctTest() {
        page.findPath();
        Assertions.assertTrue(driver.getCurrentUrl().endsWith("level17"));
    }


}
