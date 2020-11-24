package automation_practice_tests;

import automation_practice.pages.levels.Level3Page;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;
import automation_practice.pages.levels.Level4Page;

@Execution(ExecutionMode.CONCURRENT)
class Level4Tests extends AutomationPracticeTest {

    Level4Page page;

    @BeforeEach
    void setUp() {
        goTo(url + "level4");
        page = new Level4Page(driver);
    }

    @Test
    void correctTest() {
        page.clickAllButtons();
        Assertions.assertTrue(driver.getCurrentUrl().endsWith("level5"));
    }

    @Test
    void oneButtonClickedTest() {
        page.clickButtonInIndex(3);
        Assertions.assertTrue(driver.getCurrentUrl().endsWith("level4"));
    }
}
