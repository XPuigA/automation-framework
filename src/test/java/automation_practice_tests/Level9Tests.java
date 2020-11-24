package automation_practice_tests;

import automation_practice.pages.levels.Level3Page;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;
import automation_practice.pages.levels.Level9Page;

@Execution(ExecutionMode.CONCURRENT)
class Level9Tests extends AutomationPracticeTest {

    Level9Page page;

    @BeforeEach
    void setUp() {
        goTo(url + "level9");
        page = new Level9Page(driver);
    }

    @Disabled("Drag and drop does not cause the drop event to be fired")
    @Test
    void correctTest() {
        page.doDragAndDrop();
        Assertions.assertTrue(driver.getCurrentUrl().endsWith("level10"));
    }
}
