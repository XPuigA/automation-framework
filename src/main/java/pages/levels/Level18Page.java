package pages.levels;

import driver.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import pages.WebPage;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Level18Page extends WebPage {

    public Level18Page(Driver driver) {
        super(driver);
    }

    public Map<String, Integer> getExpectedProducts() {
        Map<String, Integer> products = new HashMap<>();
        driver.findElements(".shop-list-item").forEach((WebElement e) -> {
            String[] split = e.getText().split(" ");
            products.put(split[0], Integer.valueOf(split[1]));
        });
        return products;
    }

    public void clickContinue() {
        driver.click("#next");
    }

    public void selectQuantitiesForProducts(Map<String, Integer> products) {
        for (WebElement e : driver.findElements(".product")) {
            int wantedQuantity = products.get(e.findElement(By.tagName(("h3"))).getText());
            int currentQuantity = Integer.valueOf(e.findElement(By.cssSelector("input[type=\"text\"]")).getAttribute("value"));

            if (currentQuantity != wantedQuantity) {
                if (currentQuantity < wantedQuantity) {
                    By buttonSelector = By.cssSelector("input[type=\"button\"][value=\"+\"]");
                    while (currentQuantity < wantedQuantity) {
                        driver.click(e.findElement(buttonSelector));
                        currentQuantity = Integer.valueOf(e.findElement(By.cssSelector("input[type=\"text\"]")).getAttribute("value"));
                    }
                } else {
                    By buttonSelector = By.cssSelector("input[type=\"button\"][value=\"-\"]");
                    while (currentQuantity > wantedQuantity) {
                        driver.click(e.findElement(buttonSelector));
                        currentQuantity = Integer.valueOf(e.findElement(By.cssSelector("input[type=\"text\"]")).getAttribute("value"));
                    }
                }
            }
        }
    }
}
