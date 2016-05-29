package com.bstu.epam;

import com.bstu.epam.step.Steps;
import com.bstu.epam.util.ImageUtils;
import com.bstu.epam.util.StringUtils;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * Created by Holger on 11.4.16.
 */
public class AppTest {
    private static final String SEARCH_FILM = "Роковое число 23";
    private static final String USER = "Holger";
    private static final String PASSWORD = "nbfvfnnafkmrjh";
    private static final Integer WAIT_LOGOUT_ONLY_MINUTE = 610000;

    private Steps steps;

    @BeforeMethod(description = "Init browser")
    public void setUp() {
        steps = new Steps();
        steps.initBrowser();
    }

    @Test(description = "1. login")
    public void login() {
        steps.login(USER, PASSWORD);
        Assert.assertEquals(steps.getUsername().equals(USER), true);
    }

    @Test(description = "2. logout")
    public void logout() {
        steps.login(USER, PASSWORD);
        Assert.assertEquals(steps.logout(), true);
    }

   /* @Test(description = "3. search film by name")
    public void searchFilm() {
        Assert.assertEquals(steps.getNameSearchFilm(SEARCH_FILM), SEARCH_FILM);
    }

    @Test(description = "4. save statistics")
    public void save() {
        steps.login(USER, PASSWORD);
        Assert.assertEquals(steps.downloadStatisticsUsers(), true);
    }

    @Test(description = "5. add film  to the recent films")
    public void getLastFilm() {
        steps.login(USER, PASSWORD);
        Assert.assertEquals(StringUtils.entry(steps.getNameLastFilm(), steps.getNameSearchFilm(SEARCH_FILM)), true);
    }

    @Test(description = "6. check online user and checked logout user")
    public void checkOnline() {
        steps.login(USER, PASSWORD);
        Assert.assertEquals(steps.checkOnline(), true);
        steps.logout();
        steps.wait(WAIT_LOGOUT_ONLY_MINUTE);
        Assert.assertEquals(steps.checkOnline(), false);
    }

    @Test(description = "7. afisha")
    public void visibleAfisha() {
        Assert.assertEquals(steps.checkAfisha(), true);
    }

    @Test(description = "8. get random film")
    public void getRandomFilm() {
        boolean actual = steps.getRandomFilmName().equals(steps.getRandomFilmName());
        Assert.assertEquals(actual, false);
    }

    @Test(description = "9. check visible popular trailer")
    public void runPopularTrailer() {

        String beforeImage = System.getProperty("user.home") + "/before.png";
        String afterImage = System.getProperty("user.home") + "/after.png";

        steps.checkTrailer(beforeImage, afterImage);

        Assert.assertEquals(ImageUtils.compareMd5ByImage(beforeImage, afterImage), false);
    }

    @Test(description = "10. real search monitor")
    public void checkMonitor() {
        String beforeImage = System.getProperty("user.home") + "/before.png";
        String afterImage = System.getProperty("user.home") + "/after.png";

        steps.screenMonitor(beforeImage);
        steps.screenMonitor(afterImage);

        Assert.assertEquals(ImageUtils.compareMd5ByImage(beforeImage, afterImage), false);
    }
*/
    @AfterMethod(description = "Stop Browser")
    public void stopBrowser() {
        steps.closeDriver();
    }
}
