package com.bstu.epam.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by Holger on 11.4.16.
 */
public class LoginPage extends AbstractPage {
    private static final String DEFAULT_URL = "http://joyreactor.cc/login";

    @FindBy(id = "signin_username")
    private WebElement inputUsername;

    @FindBy(id = "signin_password")
    private WebElement inputPassword;



    public LoginPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    @Override
    public void openPage() {
        driver.navigate().to(DEFAULT_URL);
    }

    public void login(String username, String password) {
        inputUsername.sendKeys(username);
        inputPassword.sendKeys(password);
        inputPassword.submit();
        //HomePage homePage = new HomePage(driver);
        //homePage.openPage();
        //return homePage;
    }


}
