package pages;

import driver.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.stream.Collectors;

public class MainPage extends WebPage {

    public MainPage(Driver driver) {
        super(driver);
    }

    public List<String> getExampleTabTitles() {
        List<WebElement> elements = getExampleTabElements();
        return elements.stream().map((WebElement elem) -> elem.getAttribute("data-tab")).collect(Collectors.toList());
    }

    public List<WebElement> getExampleTabElements() {
        return driver.findElements(".code_example .tab");
    }

    public boolean toastMessageIsPresentAndVisible() {
        return driver.elementExists(".toast-box.visible") && driver.findElement(".toast-box.visible").isDisplayed();
    }

    public boolean startButtonIsPresentAndVisible() {
        return driver.elementExists("#start_button") && driver.findElement("#start_button").isDisplayed();
    }

    public void clickStartButton() {
        driver.click("#start_button");
    }

    public void clickCloseToast() {
        WebElement element = driver.findElement(".toast-box.visible");
        driver.click(element.findElement(By.cssSelector(".close.icon")));
        driver.waitForElementToDissapear(element);
    }
}
