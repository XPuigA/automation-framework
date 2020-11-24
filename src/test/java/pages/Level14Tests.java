package pages;

import common.ManagedDriverUITest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;
import pages.levels.Level14Page;

@Execution(ExecutionMode.CONCURRENT)
class Level14Tests extends ManagedDriverUITest {

    @Test
    void correctTest() {
        goTo(url + "level14");
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
        goTo(url + "level14");
        Level14Page page = new Level14Page(driver);
        page.clickContinue();
        Assertions.assertTrue(driver.getCurrentUrl().endsWith("level14"));
    }

    @Test
    void wrongText() {
        goTo(url + "level14");
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
