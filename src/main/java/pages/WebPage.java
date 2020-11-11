package pages;

import driver.Driver;

public abstract class WebPage {

    protected Driver driver;

    protected WebPage(Driver driver) {
        this.driver = driver;
    }
}
