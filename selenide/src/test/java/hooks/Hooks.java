package hooks;


import com.codeborne.selenide.Configuration;
import cucumber.api.java.Before;

public class Hooks {

    @Before ("@web")
    public void setUp() throws Exception {
        System.setProperty("webdriver.chrome.driver","C:\\drivers\\chromedriver.exe");
        Configuration.timeout=5000L;
        Configuration.browser="chrome";
        Configuration.headless=false;
    }
}
