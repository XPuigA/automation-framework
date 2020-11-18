package pages;

import common.ManagedDriverTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pages.levels.Level17Page;
import pages.levels.Level18Page;

class Level18Tests extends ManagedDriverTest {

    @Test
    void correctTest() {
        newDriver(url + "level18");
        Level18Page page = new Level18Page(driver);
        page.selectQuantitiesForProducts(page.getExpectedProducts());
        page.clickContinue();
        Assertions.assertTrue(driver.getCurrentUrl().endsWith("level19"));
    }

    @Test
    void wrongQuantities() {
        newDriver(url + "level18");
        Level18Page page = new Level18Page(driver);
        page.clickContinue();
        Assertions.assertTrue(driver.getCurrentUrl().endsWith("level18"));
    }

}
