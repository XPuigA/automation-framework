package pages.levels;

import driver.Driver;
import org.openqa.selenium.WebElement;
import pages.WebPage;

import java.util.List;

public class Level5Page extends WebPage {

    public Level5Page(Driver driver) {
        super(driver);
    }

    public void clickRedButtons() {
        List<WebElement> elements = driver.findElements(".button.red");
        for (WebElement element : elements) {
            driver.click(element);
        }
    }

    public void clickOneRedButton() {
        driver.click(".button.red");
    }

    public void clickAllGreenButtons() {
        List<WebElement> elements = driver.findElements(".button.green");
        for (WebElement element : elements) {
            driver.click(element);
        }
    }
}
