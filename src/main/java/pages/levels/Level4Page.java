package pages.levels;

import driver.Driver;
import org.openqa.selenium.WebElement;
import pages.WebPage;

import java.util.List;

public class Level4Page extends WebPage {

    public Level4Page(Driver driver) {
        super(driver);
    }

    public void clickContinueButton() {
        driver.click("#next");
    }

    public void clickAllButtons() {
        List<WebElement> elements = driver.findElements(".button");
        for (WebElement element : elements) {
            driver.click(element);
        }
    }

    public void clickButtonInIndex(int i) {
        driver.click(driver.findElements(".button").get(i));
    }
}
