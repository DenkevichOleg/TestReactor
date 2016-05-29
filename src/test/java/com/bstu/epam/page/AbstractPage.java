package com.bstu.epam.page;

import org.openqa.selenium.WebDriver;

/**
 * Created by Holger on 11.4.16.
 */
public abstract class AbstractPage {
    protected WebDriver driver;

    public abstract void openPage();

    public AbstractPage(WebDriver driver) {
        this.driver = driver;
    }
}
