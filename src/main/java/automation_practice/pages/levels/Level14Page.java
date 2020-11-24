package automation_practice.pages.levels;

import driver.Driver;
import org.openqa.selenium.WebElement;
import pages.WebPage;

public class Level14Page extends WebPage {

    public Level14Page(Driver driver) {
        super(driver);
    }

    public void setText(String text) {
        WebElement input = driver.findElement("#input1");
        driver.clearAndWrite(input, text);
        driver.write(input, "\t"); // Blur
        driver.waitForLoaderToDissapear();
    }

    public String getExpectedText() {
        return driver.findElement("#input1_value").getText();
    }

    public void setPassword(String password) {
        WebElement input = driver.findElement("#input2");
        driver.clearAndWrite(input, password);
        driver.write(input, "\t"); // Blur
        driver.waitForLoaderToDissapear();
    }

    public String getExpectedPassword() {
        return driver.findElement("#input2_value").getText();
    }

    public void setCheckbox(boolean value) {
        if (value) {
            driver.click("#input3");
            driver.waitForLoaderToDissapear();
        }
    }

    public boolean getExpectedCheckbox() {
        return Boolean.parseBoolean(driver.findElement("#input3_value").getText());
    }

    public void setRadio(String value) {
        driver.click("[name=\"input4\"][value=\"" + value + "\"]");
        driver.waitForLoaderToDissapear();
    }

    public String getExpectedRadio() {
        return driver.findElement("#input4_value").getText();
    }

    public void clickContinue() {
        driver.waitForLoaderToDissapear();
        driver.click("#next");
    }
}
