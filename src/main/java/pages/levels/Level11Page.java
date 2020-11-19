package pages.levels;

import driver.Driver;
import pages.WebPage;

public class Level11Page extends WebPage {

    public Level11Page(Driver driver) {
        super(driver);
    }

    public void makeTheButtonVisibleAndClickIt() {
        makeTheButtonVisible();
        clickTheButton();
    }

    public void makeTheButtonVisible() {
        driver.executeJavascript("document.getElementById(\"hidden\").setAttribute(\"style\", \"\")");
    }

    public void clickTheButton() {
        driver.click("#hidden");
    }
}
