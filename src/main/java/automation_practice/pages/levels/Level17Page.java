package automation_practice.pages.levels;

import driver.Driver;
import pages.WebPage;

public class Level17Page extends WebPage {

    public Level17Page(Driver driver) {
        super(driver);
    }


    public void clickDirectionsAndContinue() {
        while(!isContinuePresent()) {
            clickDirection(getNextDirection());
        }
        clickContinue();
    }

    public String getNextDirection() {
        return driver.findElement(".direction b").getText();
    }

    public void clickDirection(String direction) {
        driver.click(".button[data-direction=\"" + direction + "\"]");
        driver.waitForLoaderToDissapear();
    }

    public boolean isContinuePresent() {
        return driver.elementExists("#next");
    }

    public void clickContinue() {
        driver.click("#next");
    }
}
