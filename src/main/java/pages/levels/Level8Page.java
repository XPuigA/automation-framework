package pages.levels;

import driver.Driver;
import pages.WebPage;

public class Level8Page extends WebPage {

    public Level8Page(Driver driver) {
        super(driver);
    }

    public void writeInDialog(String text) {
        driver.writeInAlert(text);
    }

    public void acceptDialog() {
        driver.acceptAlert();
    }

    public void cancelDialog() {
        driver.dismissAlert();
    }
}
