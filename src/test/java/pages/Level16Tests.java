package pages;

import common.ManagedDriverTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pages.levels.Level15Page;
import pages.levels.Level16Page;

import java.util.List;

class Level16Tests extends ManagedDriverTest {

    @Test
    void correctTest() {
        newDriver(url + "level16");
        Level16Page page = new Level16Page(driver);
        page.findPath();
        Assertions.assertTrue(driver.getCurrentUrl().endsWith("level17"));
    }


}
