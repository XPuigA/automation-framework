package automation_practice.pages.levels;

import driver.Driver;
import pages.WebPage;

public class Level3Page extends WebPage {

    public Level3Page(Driver driver) {
        super(driver);
    }

    public String getGeneratedToken() {
        return driver.findElement(".custom_dummy_label").getText();
    }

    public void fillInputTextbox(String text) {
        driver.clearAndWrite("#input", text);
    }

    public void clickContinueButton() {
        driver.click("#next");
    }
}
