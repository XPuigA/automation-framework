package automation_practice_tests;

import automation_practice.pages.levels.Level3Page;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;
import automation_practice.pages.levels.Level8Page;

@Execution(ExecutionMode.CONCURRENT)
class Level8Tests extends AutomationPracticeTest {

    Level8Page page;

    @BeforeEach
    void setUp() {
        goTo(url + "level8");
        page = new Level8Page(driver);
    }

    @Test
    void correctTest() {
        page.writeInDialog("automation-rocks");
        page.acceptDialog();
        Assertions.assertTrue(driver.getCurrentUrl().endsWith("level9"));
    }

    @Test
    void cancelDialogTest() {
        page.cancelDialog();
        Assertions.assertTrue(driver.getCurrentUrl().endsWith("level8"));
    }

    @Test
    void wrongInputTest() {
        page.writeInDialog("random-text");
        page.acceptDialog();
        Assertions.assertTrue(driver.getCurrentUrl().endsWith("level8"));
    }


}
