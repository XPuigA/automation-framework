package automation_practice.pages.levels;

import driver.Driver;
import pages.WebPage;

public class Level12Page extends WebPage {

    public Level12Page(Driver driver) {
        super(driver);
    }

    public int getNumberOfButtons() {
        return driver.findElements("#buttons .button").size();
    }

    public void clickAllButtonsInOrder() {
        for (int i = 1; i <= getNumberOfButtons(); ++i) {
            clickButtonAtPosition(i);
        }
    }

    public void clickButtonAtPosition(int position) {
        driver.click("[data-button=\"button_" + position + "_in_level_12\"]");
    }
}
