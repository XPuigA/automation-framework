package pages.levels;

import driver.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import pages.WebPage;

import java.util.HashMap;
import java.util.Map;

public class Level19Page extends WebPage {

    public Level19Page(Driver driver) {
        super(driver);
    }

    public String getCookieValue() {
        return driver.getWebDriver().manage().getCookieNamed("value").getValue();
    }

    public void setTextInInput(String text) {
        driver.clearAndWrite("#input", text);
    }

    public void clickContinue() {
        driver.click("#next");
    }
}
