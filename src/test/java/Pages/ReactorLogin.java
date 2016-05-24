package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

/**
 * Created by А д м и н on 23.05.2016.
 */
public class ReactorLogin extends AbstractPage {
    public ReactorLogin(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    @Override
    public void openPage(String URL) {
        driver.navigate().to(URL);
    }

    public void enter(String elementId, String visibleText) {
        driver.findElement(By.id(elementId)).clear();
        driver.findElement(By.id(elementId)).sendKeys(visibleText);
    }

    public void choose(String elementid, String visibletext) {
        Select dropdown = new Select(driver.findElement(By.id(elementid)));
        dropdown.selectByVisibleText(visibletext);
    }

    public void clickLink(String linkText) {
        driver.findElement(By.linkText(linkText)).click();
    }

    public void clickButtonLogin(String cssSelector) {
        driver.findElement(By.cssSelector(cssSelector)).click();
    }

    public boolean TakeRezult(String id, String equals) {
        return driver.findElement(By.id(id)).getText().equals(equals);
    }
}