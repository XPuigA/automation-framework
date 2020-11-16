package pages;

import driver.Driver;

public abstract class WebPage {

    protected Driver driver;

    public WebPage(Driver driver) {
        this.driver = driver;
    }
}
