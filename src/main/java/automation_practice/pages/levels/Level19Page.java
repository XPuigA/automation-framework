package automation_practice.pages.levels;

import driver.Driver;
import pages.WebPage;

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
