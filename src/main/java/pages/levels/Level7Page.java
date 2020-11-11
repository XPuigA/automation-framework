package pages.levels;

import driver.Driver;
import org.openqa.selenium.WebElement;
import pages.WebPage;

public class Level7Page extends WebPage {

    public Level7Page(Driver driver) {
        super(driver);
    }

    public void acceptDialog() {
        driver.getWebDriver().switchTo().alert().accept();
    }

    public void cancelDialog() {
        driver.getWebDriver().switchTo().alert().dismiss();
    }
}
