package automation_practice.pages.levels;

import driver.Driver;
import pages.WebPage;

public class Level2Page extends WebPage {

    public Level2Page(Driver driver) {
        super(driver);
    }

    public void fillInputTextbox(String text) {
        driver.clearAndWrite("#input", text);
    }

    public void clickContinueButton() {
        driver.click("#next");
    }
}
