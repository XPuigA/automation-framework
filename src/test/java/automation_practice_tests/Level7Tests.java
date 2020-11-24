package automation_practice_tests;

import automation_practice.pages.levels.Level3Page;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;
import automation_practice.pages.levels.Level7Page;

@Execution(ExecutionMode.CONCURRENT)
class Level7Tests extends AutomationPracticeTest {

    Level7Page page;

    @BeforeEach
    void setUp() {
        goTo(url + "level7");
        page = new Level7Page(driver);
    }

    @Test
    void correctTest() {
        page.acceptDialog();
    }

    @Test
    void cancelDialogTest() {
        page.cancelDialog();
        Assertions.assertTrue(driver.getCurrentUrl().endsWith("level7"));
    }


}
