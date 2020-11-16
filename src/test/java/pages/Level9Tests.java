package pages;

import common.ManagedDriverTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import pages.levels.Level8Page;
import pages.levels.Level9Page;

class Level9Tests extends ManagedDriverTest {

    @Disabled("Drag and drop does not cause the drop event to be fired")
    @Test
    void correctTest() {
        newDriver(url + "level9");
        Level9Page page = new Level9Page(driver);
        page.doDragAndDrop();
        Assertions.assertTrue(driver.getCurrentUrl().endsWith("level10"));
    }
}
