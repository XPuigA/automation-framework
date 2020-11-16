package pages.levels;

import driver.Driver;
import pages.WebPage;

public class Level9Page extends WebPage {

    public Level9Page(Driver driver) {
        super(driver);
    }

    public void doDragAndDrop() {
        driver.dragAndDrop("#source .list-group-item", "#destination");
    }
}
