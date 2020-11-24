package automation_practice.pages.levels;

import driver.Driver;
import org.openqa.selenium.WebElement;
import pages.WebPage;

public class Level6Page extends WebPage {

    public Level6Page(Driver driver) {
        super(driver);
    }

    public void findAndClickYesButton() {
        while(!isYesButtonInSlide()) {
            clickNextSlideButton();
        }
        clickButtonInSlide();
    }

    public void findAndClickNoButton() {
        while(isYesButtonInSlide()) {
            clickNextSlideButton();
        }
        clickButtonInSlide();
    }

    public void clickNextSlideButton() {
        driver.click(".slide_right");
    }

    public void clickPreviousSlideButton() {
        driver.click(".slide_left");
    }

    private WebElement getButtonInSlide() {
        return driver.findElement(".slide.active .button");
    }

    public boolean isYesButtonInSlide() {
        return  getButtonInSlide().getText().equals("YES");
    }

    public void clickButtonInSlide() {
        driver.click(getButtonInSlide());
    }
}
