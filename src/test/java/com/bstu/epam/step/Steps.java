package com.bstu.epam.step;

import com.bstu.epam.page.*;
import com.bstu.epam.util.ImageUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

/**
 * Created by Holger on 11.4.16.
 */
public class Steps {
    private static final String USER_PREFIX = "Профиль: ";
    private static final String LOGOUT_URL = "http://joyreactor.cc/logout/";
    private static final Integer WAIT_SAVE_FILE = 50000;
    private static final Integer WATCH_TRAILER = 10000;

    protected WebDriver driver;

    public void initBrowser() {

        FirefoxProfile profile = new FirefoxProfile();
        //download file to Desktop
        profile.setPreference("browser.download.folderList", 0);
        profile.setPreference("browser.helperApps.neverAsk.saveToDisk", "application/excel, application/vnd.ms-excel, application/x-excel, application/x-msexcel");
        //no proxy
        profile.setPreference("network.proxy.type", 0);
        driver = new FirefoxDriver(profile);
        driver.manage().timeouts().pageLoadTimeout(300, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
    }

    public void closeDriver() {
        driver.quit();
    }

    public String getNameSearchFilm(String filmName) {
        HomePage homePage = new HomePage(driver);
        homePage.openPage();
        SearchPage searchPage = homePage.searchFilms(filmName);
        return searchPage.getFirstFilm().getFilmName();
    }

    public void login(String username, String password) {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.openPage();
        loginPage.login(username, password);
    }

    public boolean logout() {
        HomePage homePage = new HomePage(driver);
        homePage.openPage();
        homePage.getLogout().click();
        return homePage.getLogin().isDisplayed();
    }

    public WebElement getFirstPopularTrailer() {
        HomePage homePage = new HomePage(driver);
        homePage.openPage();
        return homePage.getFirstPopularTrailer();
    }

    public String getUsername() {
        HomePage homePage = new HomePage(driver);
        homePage.openPage();
        return homePage.getUserName().getText();
    }

    public String getRandomFilmName() {
        ChangePage changePage = new ChangePage(driver);
        changePage.openPage();
        WebElement film = changePage.getRandomFilm();
        return film.getText();
    }

    public String getNameLastFilm() {
        HomePage homePage = new HomePage(driver);
        return homePage.getLastElement().getAttribute("title");
    }

    public boolean checkOnline() {
        UserPage userPage = new UserPage(driver);
        userPage.openPage();
        return userPage.getLastInfo().size() > 0;
    }

    public boolean checkAfisha() {
        AfishaPage afishaPage = new AfishaPage(driver);
        afishaPage.openPage();
        return afishaPage.getFilms().size() > 1;
    }

    public boolean downloadStatisticsUsers() {
        UserPage userPage = new UserPage(driver);
        userPage.openPage();
        userPage.getStatisticsUrl().click();
        userPage.getDownloadStatistics().click();
        wait(WAIT_SAVE_FILE);
        return true;
    }

    public void screenMonitor(String imageName) {
        MonitorPage monitorPage = new MonitorPage(driver);
        monitorPage.openPage();
        wait(WAIT_SAVE_FILE);
        wait(WAIT_SAVE_FILE);
        getScreenshotWebElement(monitorPage.getMonitor(), imageName);
    }

    public void getScreenshotTrailer(WebElement element, String imageName) {
        wait(WATCH_TRAILER);
        getScreenshotWebElement(element, imageName);
    }

    public void wait(Integer time) {
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void checkTrailer(String beforeImage, String afterImage) {
        WebElement firstTrailer = getFirstPopularTrailer();
        getScreenshotTrailer(firstTrailer, beforeImage);
        firstTrailer.click();
        getScreenshotTrailer(firstTrailer, afterImage);
    }

    public void getScreenshotWebElement(WebElement element, String imageName) {
        try {
            ImageUtils.screen(driver, element, imageName);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
