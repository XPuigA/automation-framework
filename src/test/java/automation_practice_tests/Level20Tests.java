package automation_practice_tests;

import automation_practice.pages.levels.Level3Page;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;
import automation_practice.pages.levels.Level20Page;

@Execution(ExecutionMode.CONCURRENT)
class Level20Tests extends AutomationPracticeTest {

    Level20Page page;

    @BeforeEach
    void setUp() {
        goTo(url + "level20");
        page = new Level20Page(driver);
    }

    @Test
    void correctTest() {
        page.setCookieValue(page.getValueForCookie());
        page.clickContinue();
        Assertions.assertTrue(driver.getCurrentUrl().endsWith("end"));
    }

    @Test
    void noChange() {
        page.clickContinue();
        Assertions.assertTrue(driver.getCurrentUrl().endsWith("level20"));
    }

    @Test
    void emptyCookie() {
        page.setCookieValue("");
        page.clickContinue();
        Assertions.assertTrue(driver.getCurrentUrl().endsWith("level20"));
    }

    @Test
    void wrongValue() {
        page.setCookieValue("AAAAAA");
        page.clickContinue();
        Assertions.assertTrue(driver.getCurrentUrl().endsWith("level20"));
    }

}
