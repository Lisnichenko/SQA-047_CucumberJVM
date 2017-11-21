package stepDefinition;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import model.AngularPage;
import webDriver.WebDriverFactory;

import static org.junit.Assert.assertFalse;


public class WhenUserAddNewRecord {

    AngularPage angularPage = new AngularPage(WebDriverFactory.getDriver());

    @Given("^user is on the angular page$")
    public void  user_is_on_the_angular_page(){
        angularPage.open();
    }

    @When("^user add new task (.*)$")
    public void user_add_new_task(String taskName){
        angularPage.addTask(taskName);
    }

    @Then("^(.*) should appear in the list")
    public void appleShouldAppearInTheList(String taskName) {
        assertFalse(angularPage.isItemPresentInList(taskName));
    }
}
