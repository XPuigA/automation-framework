package pages;

import common.ManagedDriverTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pages.levels.Level16Page;
import pages.levels.Level17Page;

class Level17Tests extends ManagedDriverTest {

    @Test
    void correctTest() {
        newDriver(url + "level17");
        Level17Page page = new Level17Page(driver);
        page.clickDirectionsAndContinue();
        Assertions.assertTrue(driver.getCurrentUrl().endsWith("level18"));
    }


}
