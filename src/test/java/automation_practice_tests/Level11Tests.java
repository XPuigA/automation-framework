package automation_practice_tests;

import automation_practice.pages.levels.Level3Page;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;
import org.openqa.selenium.ElementNotInteractableException;
import automation_practice.pages.levels.Level11Page;

@Execution(ExecutionMode.CONCURRENT)
class Level11Tests extends AutomationPracticeTest {

    Level11Page page;

    @BeforeEach
    void setUp() {
        goTo(url + "level11");
        page = new Level11Page(driver);
    }

    @Test
    void correctTest() {
        page.makeTheButtonVisibleAndClickIt();
        Assertions.assertTrue(driver.getCurrentUrl().endsWith("level12"));
    }

    @Test
    void clickTheButtonWithoutItBeingVisible() {
        Assertions.assertThrows(ElementNotInteractableException.class, page::clickTheButton);
        Assertions.assertTrue(driver.getCurrentUrl().endsWith("level11"));
    }
}
