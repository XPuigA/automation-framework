package pages;

import driver.Driver;

import java.util.logging.Logger;

public abstract class WebPage {

    protected static final Logger LOGGER = Logger.getLogger("MainLogger");

    protected final Driver driver;

    public WebPage(Driver driver) {
        this.driver = driver;
    }
}
