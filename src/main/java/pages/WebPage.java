package pages;

import driver.Driver;

public abstract class WebPage {

    Driver driver;

    protected WebPage(Driver driver) {
        this.driver = driver;
    }
}
