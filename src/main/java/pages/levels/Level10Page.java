package pages.levels;

import driver.Driver;
import org.openqa.selenium.WebElement;
import pages.WebPage;

import java.time.LocalDate;
import java.util.List;

public class Level10Page extends WebPage {

    public Level10Page(Driver driver) {
        super(driver);
    }

    public LocalDate getDateInPage() {
        String text = driver.findElement("#app div p:nth-child(2n)").getText();
        String[] split = text.split("-");
        return LocalDate.of(Integer.valueOf(split[0]), Integer.valueOf(split[1]), Integer.valueOf(split[2]));
    }

    public void setDateInInput(LocalDate date) {
        String year = String.valueOf(date.getYear());
        String day = String.valueOf(date.getDayOfMonth());
        openCalendar();
        driver.click(".day__month_btn.up");
        driver.waitForElement(".month");
        driver.click(".month__year_btn.up");
        driver.waitForElement(".year");
        List<WebElement> yearElements = driver.findElements(".year");
        for (WebElement yearElement : yearElements) {
            if (yearElement.getText().equals(year)) {
                driver.click(yearElement);
                break;
            }
        }
        driver.waitForElement(".month");
        List<WebElement> monthElements = driver.findElements(".month");
        driver.click(monthElements.get(date.getMonthValue() - 1));

        driver.waitForElement(".day");
        List<WebElement> dayElements = driver.findElements(".day");
        for (WebElement dayElement : dayElements) {
            if (dayElement.getText().equals(day)) {
                driver.click(dayElement);
                break;
            }
        }
    }

    private void openCalendar() {
        driver.click(".vdp-datepicker input");
    }
}
