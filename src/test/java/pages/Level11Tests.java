package pages;

import common.ManagedDriverTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.ElementNotInteractableException;
import pages.levels.Level10Page;
import pages.levels.Level11Page;

import java.time.LocalDate;

class Level11Tests extends ManagedDriverTest {

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
