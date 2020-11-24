package automation_practice_tests;

import automation_practice.pages.levels.Level2Page;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;
import automation_practice.pages.levels.Level3Page;

@Execution(ExecutionMode.CONCURRENT)
class Level3Tests extends AutomationPracticeTest {

    Level3Page page;

    @BeforeEach
    void setUp() {
        goTo(url + "level3");
        page = new Level3Page(driver);
    }

    @Test
    void correctTest() {
        page.fillInputTextbox(page.getGeneratedToken());
        page.clickContinueButton();
        Assertions.assertTrue(driver.getCurrentUrl().endsWith("level4"));
    }

    @Test
    void emptyInputTest() {
        page.clickContinueButton();
        Assertions.assertTrue(driver.getCurrentUrl().endsWith("level3"));
    }

    @Test
    void wrongInputTest() {
        page.fillInputTextbox("whatever");
        page.clickContinueButton();
        Assertions.assertTrue(driver.getCurrentUrl().endsWith("level3"));
    }
}
