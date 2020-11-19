package pages;

import common.ManagedDriverUITest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;
import org.openqa.selenium.ElementNotInteractableException;
import pages.levels.Level11Page;

@Execution(ExecutionMode.CONCURRENT)
class Level11Tests extends ManagedDriverUITest {

    @Test
    void correctTest() {
        newDriver(url + "level11");
        Level11Page page = new Level11Page(driver);
        page.makeTheButtonVisibleAndClickIt();
        Assertions.assertTrue(driver.getCurrentUrl().endsWith("level12"));
    }

    @Test
    void clickTheButtonWithoutItBeingVisible() {
        newDriver(url + "level11");
        Level11Page page = new Level11Page(driver);
        Assertions.assertThrows(ElementNotInteractableException.class, page::clickTheButton);
        Assertions.assertTrue(driver.getCurrentUrl().endsWith("level11"));
    }
}
