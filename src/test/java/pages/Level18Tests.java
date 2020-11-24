package pages;

import common.ManagedDriverUITest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;
import pages.levels.Level18Page;

@Execution(ExecutionMode.CONCURRENT)
class Level18Tests extends ManagedDriverUITest {

    @Test
    void correctTest() {
        goTo(url + "level18");
        Level18Page page = new Level18Page(driver);
        page.selectQuantitiesForProducts(page.getExpectedProducts());
        page.clickContinue();
        Assertions.assertTrue(driver.getCurrentUrl().endsWith("level19"));
    }

    @Test
    void wrongQuantities() {
        goTo(url + "level18");
        Level18Page page = new Level18Page(driver);
        page.clickContinue();
        Assertions.assertTrue(driver.getCurrentUrl().endsWith("level18"));
    }

}
