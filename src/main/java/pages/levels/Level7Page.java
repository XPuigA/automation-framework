package pages.levels;

import driver.Driver;
import pages.WebPage;

public class Level7Page extends WebPage {

    public Level7Page(Driver driver) {
        super(driver);
    }

    public void acceptDialog() {
        driver.acceptAlert();
    }

    public void cancelDialog() {
        driver.dismissAlert();
    }
}
