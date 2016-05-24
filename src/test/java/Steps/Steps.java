package Steps;

import Pages.ReactorLogin;
import Pages.ReactorLogout;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class Steps {
    private WebDriver driver;

    public void initBrowser() {
        driver = new FirefoxDriver();
        driver.manage().timeouts().pageLoadTimeout(150, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(150, TimeUnit.SECONDS);
    }

    public boolean login() {
        ReactorLogin reactorLogin = new ReactorLogin(driver);
        reactorLogin.openPage("http://joyreactor.cc/");
        reactorLogin.clickLink("Вход");
        reactorLogin.enter("signin_username", "Holger");
        reactorLogin.enter("signin_password", "nbfvfnnafkmrjh");
        reactorLogin.clickButtonLogin("form.sfSignin > input[type=\"submit\"]");
        return reactorLogin.TakeRezult("settings", "Holger");
    }

    public boolean logout() {
        ReactorLogout reactorLogout = new ReactorLogout(driver);
        reactorLogout.openPage("http://joyreactor.cc/");
        reactorLogout.clickLink("Вход");
        reactorLogout.enter("signin_username", "Holger");
        reactorLogout.enter("signin_password", "nbfvfnnafkmrjh");
        reactorLogout.clickButtonLogin("form.sfSignin > input[type=\"submit\"]");
        reactorLogout.clickButtonLogout("logout");
        return reactorLogout.TakeRezult("Вход");
    }


}
