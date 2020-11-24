package automation_practice.pages.levels;

import driver.Driver;
import org.openqa.selenium.WebElement;
import pages.WebPage;

import java.util.List;
import java.util.stream.Collectors;

public class Level15Page extends WebPage {

    public Level15Page(Driver driver) {
        super(driver);
    }

    public List<String> getSeatsToSelect() {
        return driver.findElements(".seat_to_select").stream().map(WebElement::getText).collect(Collectors.toList());
    }

    public void selectSeats(List<String> seats) {
        for (String seat : seats) {
            driver.click(".seat[value=\"" + seat + "\"]");
        }
    }

    public void clickContinue() {
        driver.click("#next");
    }

    public List<String> getAllEnabledSeats() {
        return driver.findElements(".seat[enabled]").stream().map((WebElement elem) -> elem.getAttribute("value")).collect(Collectors.toList());
    }
}
