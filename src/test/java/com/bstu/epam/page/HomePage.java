package com.bstu.epam.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by Holger on 11.4.16.
 */
public class HomePage extends AbstractPage {
    private static final String HOME_URL = "http://joyreactor.cc";

    @FindBy(id = "search_input")
    private WebElement searchInput;

    @FindBy(css = ".trailerGag")
    private WebElement firstPopularTrailer;

    @FindBy(xpath ="//a[contains(text(),'Вход')]")
    private WebElement login;

    @FindBy(id = "logout")
    private WebElement logout;

    @FindBy(id = "settings")
    private WebElement userName;

    @FindBy(css = "#last_film li a")
    private WebElement lastElement;

    public HomePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    public WebElement getFirstPopularTrailer() {
        return firstPopularTrailer;
    }

    @Override
    public void openPage() {
        driver.navigate().to(HOME_URL);
    }

    public SearchPage searchFilms(String search) {
        searchInput.sendKeys(search);
        searchInput.submit();
        return new SearchPage(driver);
    }

    public WebElement getLogout() {
        return logout;
    }

    public WebElement getLogin() {
        return login;
    }

    public WebElement getUserName() {
        return userName;
    }

    public WebElement getLastElement() {
        return lastElement;
    }
}
