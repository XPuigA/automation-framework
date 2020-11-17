package pages;

import common.ManagedDriverTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pages.levels.Level13Page;
import pages.levels.Level14Page;

class Level14Tests extends ManagedDriverTest {

    @Test
    void correctTest() {
        newDriver(url + "level14");
        Level14Page page = new Level14Page(driver);
        page.setText(page.getExpectedText());
        page.setPassword(page.getExpectedPassword());
        page.setCheckbox(page.getExpectedCheckbox());
        page.setRadio(page.getExpectedRadio());
        page.clickContinue();
        Assertions.assertTrue(driver.getCurrentUrl().endsWith("level15"));
    }

    @Test
    void emptyFields() {
        newDriver(url + "level14");
        Level14Page page = new Level14Page(driver);
        page.clickContinue();
        Assertions.assertTrue(driver.getCurrentUrl().endsWith("level14"));
    }

    @Test
    void wrongText() {
        newDriver(url + "level14");
        Level14Page page = new Level14Page(driver);
        page.setText("RANDOM_TEXT");
        page.setPassword(page.getExpectedPassword());
        page.setCheckbox(page.getExpectedCheckbox());
        page.setRadio(page.getExpectedRadio());
        page.clickContinue();
        Assertions.assertTrue(driver.getCurrentUrl().endsWith("level14"));
    }

    @Test
    void wrongPassword() {
        newDriver(url + "level14");
        Level14Page page = new Level14Page(driver);
        page.setText(page.getExpectedText());
        page.setPassword("RANDOM_PASSWORD");
        page.setCheckbox(page.getExpectedCheckbox());
        page.setRadio(page.getExpectedRadio());
        page.clickContinue();
        Assertions.assertTrue(driver.getCurrentUrl().endsWith("level14"));
    }

    @Test
    void missingRadio() {
        newDriver(url + "level14");
        Level14Page page = new Level14Page(driver);
        page.setText(page.getExpectedText());
        page.setPassword(page.getExpectedPassword());
        page.setCheckbox(page.getExpectedCheckbox());
        page.clickContinue();
        Assertions.assertTrue(driver.getCurrentUrl().endsWith("level14"));
    }
}
