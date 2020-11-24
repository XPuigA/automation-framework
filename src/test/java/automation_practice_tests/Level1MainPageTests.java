package automation_practice_tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;
import automation_practice.pages.levels.Level1MainPage;

import java.util.Arrays;
import java.util.List;

@Execution(ExecutionMode.CONCURRENT)
class Level1MainPageTests extends AutomationPracticeTest {

    Level1MainPage page;

    @BeforeEach
    void setUp() {
        goTo(url);
        page = new Level1MainPage(driver);
    }

    @Test
    @DisplayName("Check the interactable elements from the page are present")
    void testPageComposition() {
        List<String> expectedOptions = Arrays.asList("Selenium", "Watir", "WebdriverIO", "CypressIO");
        Assertions.assertEquals(expectedOptions, page.getExampleTabTitles());
        Assertions.assertTrue(page.toastMessageIsPresentAndVisible(), "Toast message is present");
        Assertions.assertTrue(page.startButtonIsPresentAndVisible(), "Start button is present");
    }

    @Test
    @DisplayName("Check the start button works")
    void testStartButtonWorks() {
        page.clickStartButton();
        Assertions.assertTrue(driver.getCurrentUrl().endsWith("level2"));
    }

    @Test
    @DisplayName("Check the close toast button works")
    void testCloseToastWorks() {
        Assertions.assertTrue(page.toastMessageIsPresentAndVisible(), "Toast message is present");
        page.clickCloseToast();
        Assertions.assertFalse(page.toastMessageIsPresentAndVisible(), "Toast message is not present");
    }
}
