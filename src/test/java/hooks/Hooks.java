package hooks;


import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.openqa.selenium.WebDriver;
import webDriver.WebDriverFactory;

public class Hooks {

    @Before
    public void setUp() throws Exception {
        System.setProperty("webdriver.chrome.driver","C:\\drivers\\chromedriver.exe");
        WebDriver driver = WebDriverFactory.getDriver();
        driver.manage().window().maximize();
    }

    @After
    public void tearDown() throws Exception {
        WebDriverFactory.getDriver().close();
    }
}
