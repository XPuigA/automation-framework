package automation_practice_tests;

import automation_practice.pages.levels.Level3Page;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;
import automation_practice.pages.levels.Level6Page;

@Execution(ExecutionMode.CONCURRENT)
class Level6Tests extends AutomationPracticeTest {

    Level6Page page;

    @BeforeEach
    void setUp() {
        goTo(url + "level6");
        page = new Level6Page(driver);
    }

    @Test
    void correctTest() {
        page.findAndClickYesButton();
        Assertions.assertTrue(driver.getCurrentUrl().endsWith("level7"));
    }

    @Test
    void clickNoButtonHasNoEffect() {
        page.findAndClickNoButton();
        Assertions.assertTrue(driver.getCurrentUrl().endsWith("level6"));
    }
}
