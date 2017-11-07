package stepDefinition;

import cucumber.api.java.en.Given;
import model.AngularPage;
import webDriver.WebDriverFactory;

public class WhenUserAddNewRecord {

    AngularPage angularPage = new AngularPage();

    @Given("user is on the angular page$")
    public void  user_is_on_the_anDrgular_page(){
        angularPage.open(WebDriverFactory.getDriver());
    }
}
