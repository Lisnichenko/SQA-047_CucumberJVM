package hooks;


import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.openqa.selenium.WebDriver;
import webDriver.WebDriverFactory;

import java.util.concurrent.TimeUnit;

public class Hooks {

    @Before
    public void setUp() throws Exception {
        WebDriver driver = WebDriverFactory.getDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5L, TimeUnit.SECONDS);
    }

    @After
    public void tearDown() throws Exception {
        WebDriverFactory.getDriver().quit();
    }
}
