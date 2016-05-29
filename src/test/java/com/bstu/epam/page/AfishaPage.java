package com.bstu.epam.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

/**
 * Created by Holger on 12.4.16.
 */
public class AfishaPage extends AbstractPage {
    private static final String DEFAULT_URL = "http://www.kinopoisk.ru/afisha/tc/182/";

    @FindBy(css = ".films_metro")
    private List<WebElement> films;

    public AfishaPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    @Override
    public void openPage() {
        driver.navigate().to(DEFAULT_URL);
    }

    public List<WebElement> getFilms() {
        return films;
    }
}
