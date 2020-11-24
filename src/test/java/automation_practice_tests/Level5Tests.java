package automation_practice_tests;

import automation_practice.pages.levels.Level3Page;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;
import automation_practice.pages.levels.Level5Page;

@Execution(ExecutionMode.CONCURRENT)
class Level5Tests extends AutomationPracticeTest {

    Level5Page page;

    @BeforeEach
    void setUp() {
        goTo(url + "level5");
        page = new Level5Page(driver);
    }

    @Test
    void correctTest() {
        page.clickRedButtons();
        Assertions.assertTrue(driver.getCurrentUrl().endsWith("level6"));
    }

    @Test
    void oneButtonClickedTest() {
        page.clickOneRedButton();
        Assertions.assertTrue(driver.getCurrentUrl().endsWith("level5"));
    }

    @Test
    void allButtonsRedTest() {
        page.clickAllGreenButtons();
        Assertions.assertTrue(driver.getCurrentUrl().endsWith("level5"));
    }
}
