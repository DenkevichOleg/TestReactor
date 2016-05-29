package com.bstu.epam.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

/**
 * Created by Holger on 12.4.16.
 */
public class UserPage extends AbstractPage {
    public static String DEFAULT_USER_PAGE = "http://www.kinopoisk.ru/user/3584902/";

    @FindBy(css = ".last_info .onlineButton")
    private List<WebElement> lastInfo;

    @FindBy(css = ".menuButton3")
    private WebElement statisticsUrl;

    @FindBy(css = ".excel a")
    private WebElement downloadStatistics;

    public UserPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    @Override
    public void openPage() {
        driver.navigate().to(DEFAULT_USER_PAGE);
    }

    public void openPage(String userUrl) {
        driver.navigate().to(userUrl);
    }

    public List<WebElement> getLastInfo() {
        return lastInfo;
    }

    public WebElement getStatisticsUrl() {
        return statisticsUrl;
    }

    public WebElement getDownloadStatistics() {
        return downloadStatistics;
    }
}
