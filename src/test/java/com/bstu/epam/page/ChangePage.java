package com.bstu.epam.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by Holger on 12.4.16.
 */
public class ChangePage extends AbstractPage {
    private static final String CHANGE_URL = "http://www.kinopoisk.ru/chance/";

    @FindBy(id = "search")
    private WebElement bSearch;

    public ChangePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    @Override
    public void openPage() {
        driver.navigate().to(CHANGE_URL);
    }

    public WebElement getRandomFilm() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        bSearch.click();
        return driver.findElement(By.cssSelector(".randomMovieItems .filmName a"));
    }

}
