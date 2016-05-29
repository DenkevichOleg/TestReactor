package com.bstu.epam.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by Holger on 11.4.16.
 */
public class FilmPage extends AbstractPage {
    private static final String DEFAULT_URL = "http://www.kinopoisk.ru/film/178579/";

    @FindBy(css = "h1[itemprop='name']")
    private WebElement filmName;


    public FilmPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    @Override
    public void openPage() {
        driver.navigate().to(DEFAULT_URL);
    }

    public String getFilmName() {
        return this.filmName.getText();
    }

}
