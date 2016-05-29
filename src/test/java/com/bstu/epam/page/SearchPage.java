package com.bstu.epam.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Holger on 11.4.16.
 */
public class SearchPage extends AbstractPage {

    @FindBy(css = ".most_wanted .info p a")
    private WebElement aFirstFilm;

    public SearchPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    @Override
    public void openPage() {}

    public FilmPage getFirstFilm() {
        aFirstFilm.click();
        return new FilmPage(driver);
    }
}
