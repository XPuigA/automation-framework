package automation_practice.pages.levels;

import driver.Driver;
import org.openqa.selenium.Cookie;
import pages.WebPage;

public class Level20Page extends WebPage {

    public Level20Page(Driver driver) {
        super(driver);
    }

    public String getValueForCookie() {
        return driver.findElement(".value").getText();
    }

    public void setCookieValue(String value) {
        driver.getWebDriver().manage().addCookie(new Cookie("value", value));
    }

    public void clickContinue() {
        driver.click("#next");
    }
}
