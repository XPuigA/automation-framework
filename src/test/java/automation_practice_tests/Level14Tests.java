package automation_practice_tests;

import automation_practice.pages.levels.Level3Page;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;
import automation_practice.pages.levels.Level14Page;

@Execution(ExecutionMode.CONCURRENT)
class Level14Tests extends AutomationPracticeTest {

    Level14Page page;

    @BeforeEach
    void setUp() {
        goTo(url + "level14");
        page = new Level14Page(driver);
    }

    @Test
    void correctTest() {
        page.setText(page.getExpectedText());
        page.setPassword(page.getExpectedPassword());
        page.setCheckbox(page.getExpectedCheckbox());
        page.setRadio(page.getExpectedRadio());
        page.clickContinue();
        Assertions.assertTrue(driver.getCurrentUrl().endsWith("level15"));
    }

    @Test
    void emptyFields() {
        page.clickContinue();
        Assertions.assertTrue(driver.getCurrentUrl().endsWith("level14"));
    }

    @Test
    void wrongText() {
        page.setText("RANDOM_TEXT");
        page.setPassword(page.getExpectedPassword());
        page.setCheckbox(page.getExpectedCheckbox());
        page.setRadio(page.getExpectedRadio());
        page.clickContinue();
        Assertions.assertTrue(driver.getCurrentUrl().endsWith("level14"));
    }

    @Test
    void wrongPassword() {
        page.setText(page.getExpectedText());
        page.setPassword("RANDOM_PASSWORD");
        page.setCheckbox(page.getExpectedCheckbox());
        page.setRadio(page.getExpectedRadio());
        page.clickContinue();
        Assertions.assertTrue(driver.getCurrentUrl().endsWith("level14"));
    }

    @Test
    void missingRadio() {
        page.setText(page.getExpectedText());
        page.setPassword(page.getExpectedPassword());
        page.setCheckbox(page.getExpectedCheckbox());
        page.clickContinue();
        Assertions.assertTrue(driver.getCurrentUrl().endsWith("level14"));
    }
}
