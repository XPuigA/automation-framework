package pages;

import common.ManagedDriverUITest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;
import pages.levels.MainPage;

import java.util.Arrays;
import java.util.List;

@Execution(ExecutionMode.CONCURRENT)
class MainPageTests extends ManagedDriverUITest {

    @Test
    @DisplayName("Check the interactable elements from the page are present")
    void testPageComposition() {
        newDriver(url);

        MainPage mainPage = new MainPage(driver);
        List<String> expectedOptions = Arrays.asList("Selenium", "Watir", "WebdriverIO", "CypressIO");
        Assertions.assertEquals(expectedOptions, mainPage.getExampleTabTitles());

        Assertions.assertTrue(mainPage.toastMessageIsPresentAndVisible(), "Toast message is present");

        Assertions.assertTrue(mainPage.startButtonIsPresentAndVisible(), "Start button is present");
    }

    @Test
    @DisplayName("Check the start button works")
    void testStartButtonWorks() {
        newDriver(url);

        MainPage mainPage = new MainPage(driver);
        mainPage.clickStartButton();
        Assertions.assertTrue(driver.getCurrentUrl().endsWith("level2"));
    }

    @Test
    @DisplayName("Check the close toast button works")
    void testCloseToastWorks() {
        newDriver(url);

        MainPage mainPage = new MainPage(driver);
        Assertions.assertTrue(mainPage.toastMessageIsPresentAndVisible(), "Toast message is present");
        mainPage.clickCloseToast();
        Assertions.assertFalse(mainPage.toastMessageIsPresentAndVisible(), "Toast message is not present");
    }
}
