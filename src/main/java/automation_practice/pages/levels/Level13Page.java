package automation_practice.pages.levels;

import driver.Driver;
import pages.WebPage;

public class Level13Page extends WebPage {

    public Level13Page(Driver driver) {
        super(driver);
    }

    public void waitForLoaderAndClickContinue() {
        driver.waitForLoaderToDissapear();
        driver.click("#next");
    }
}
