package automation_practice_tests;

import automation_practice.pages.levels.Level3Page;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;
import automation_practice.pages.levels.Level19Page;

@Execution(ExecutionMode.CONCURRENT)
class Level19Tests extends AutomationPracticeTest {

    Level19Page page;

    @BeforeEach
    void setUp() {
        goTo(url + "level19");
        page = new Level19Page(driver);
    }

    @Test
    void correctTest() {
        page.setTextInInput(page.getCookieValue());
        page.clickContinue();
        Assertions.assertTrue(driver.getCurrentUrl().endsWith("level20"));
    }

    @Test
    void emptyText() {
        page.clickContinue();
        Assertions.assertTrue(driver.getCurrentUrl().endsWith("level19"));
    }

    @Test
    void wrongValue() {
        page.setTextInInput("AAAAAA");
        page.clickContinue();
        Assertions.assertTrue(driver.getCurrentUrl().endsWith("level19"));
    }

}
