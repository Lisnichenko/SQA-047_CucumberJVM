package stepDefinition;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import model.AngularPage;

import static org.junit.Assert.assertTrue;


public class WhenUserAddNewRecord {

    AngularPage angularPage = new AngularPage();

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
        assertTrue(angularPage.isItemPresentInList(taskName));
    }

    @And("^remove (.*)$")
    public void removeApple(String taskName){
      angularPage.removeTask(taskName);
    }
}
