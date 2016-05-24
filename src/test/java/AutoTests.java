import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import Steps.Steps;

public class AutoTests {
    private Steps steps;

    @BeforeMethod(description = "Init Browser")
    public void setUp() {
        steps = new Steps();
        steps.initBrowser();
    }

    @Test(description = "Test signed in reactor")
    public void login() {
        Assert.assertTrue(steps.login());
    }

    @Test(description = "Test signed out reactor")
    public void logout() {
        Assert.assertTrue(steps.logout());
    }
}
