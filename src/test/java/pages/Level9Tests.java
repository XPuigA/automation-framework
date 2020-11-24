package pages;

import common.ManagedDriverUITest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;
import pages.levels.Level9Page;

@Execution(ExecutionMode.CONCURRENT)
class Level9Tests extends ManagedDriverUITest {

    @Disabled("Drag and drop does not cause the drop event to be fired")
    @Test
    void correctTest() {
        goTo(url + "level9");
        Level9Page page = new Level9Page(driver);
        page.doDragAndDrop();
        Assertions.assertTrue(driver.getCurrentUrl().endsWith("level10"));
    }
}
