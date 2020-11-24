package automation_practice_tests;

import org.junit.Before;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;
import automation_practice.pages.levels.Level2Page;

@Execution(ExecutionMode.CONCURRENT)
class Level2Tests extends AutomationPracticeTest {

    private Level2Page page;

    @BeforeEach
    void setUp() {
        goTo(url + "level2");
        page = new Level2Page(driver);
    }

    @Test
    void correctTest() {
        page.fillInputTextbox("automation");
        page.clickContinueButton();
        Assertions.assertTrue(driver.getCurrentUrl().endsWith("level3"));
    }

    @Test
    void emptyInputTest() {
        page.clickContinueButton();
        Assertions.assertTrue(driver.getCurrentUrl().endsWith("level2"));
    }

    @Test
    void wrongInputTest() {
        page.fillInputTextbox("whatever");
        page.clickContinueButton();
        Assertions.assertTrue(driver.getCurrentUrl().endsWith("level2"));
    }
}
