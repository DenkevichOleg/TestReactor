package com.bstu.epam.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by Holger on 12.4.16.
 */
public class MonitorPage extends AbstractPage {
    private static final String URL = "http://www.kinopoisk.ru/s/top/";

    @FindBy(id = "div_lss")
    private WebElement monitor;

    public MonitorPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    public void openPage() {
        driver.navigate().to(URL);
    }

    public WebElement getMonitor() {
        return monitor;
    }
}
