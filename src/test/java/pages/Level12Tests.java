package pages;

import common.ManagedDriverTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.ElementNotInteractableException;
import pages.levels.Level11Page;
import pages.levels.Level12Page;

class Level12Tests extends ManagedDriverTest {

    @Test
    void correctTest() {
        newDriver(url + "level12");
        Level12Page page = new Level12Page(driver);
        page.clickAllButtonsInOrder();
        Assertions.assertTrue(driver.getCurrentUrl().endsWith("level13"));
    }

    @Test
    void clickOnly4Buttons () {
        newDriver(url + "level12");
        Level12Page page = new Level12Page(driver);
        page.clickButtonAtPosition(1);
        page.clickButtonAtPosition(2);
        page.clickButtonAtPosition(4);
        page.clickButtonAtPosition(5);
        Assertions.assertTrue(driver.getCurrentUrl().endsWith("level12"));
    }
}
