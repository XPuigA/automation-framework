package automation_practice_tests;

import automation_practice.pages.levels.Level3Page;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;
import automation_practice.pages.levels.Level18Page;

@Execution(ExecutionMode.CONCURRENT)
class Level18Tests extends AutomationPracticeTest {

    Level18Page page;

    @BeforeEach
    void setUp() {
        goTo(url + "level18");
        page = new Level18Page(driver);
    }

    @Test
    void correctTest() {
        page.selectQuantitiesForProducts(page.getExpectedProducts());
        page.clickContinue();
        Assertions.assertTrue(driver.getCurrentUrl().endsWith("level19"));
    }

    @Test
    void wrongQuantities() {
        page.clickContinue();
        Assertions.assertTrue(driver.getCurrentUrl().endsWith("level18"));
    }

}
