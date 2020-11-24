package pages;

import common.ManagedDriverUITest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;
import pages.levels.Level17Page;

@Execution(ExecutionMode.CONCURRENT)
class Level17Tests extends ManagedDriverUITest {

    @Test
    void correctTest() {
        goTo(url + "level17");
        Level17Page page = new Level17Page(driver);
        page.clickDirectionsAndContinue();
        Assertions.assertTrue(driver.getCurrentUrl().endsWith("level18"));
    }


}
