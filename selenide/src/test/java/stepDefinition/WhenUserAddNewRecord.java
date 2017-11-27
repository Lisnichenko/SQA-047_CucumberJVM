package stepDefinition;

import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import model.AngularPage;

import java.util.List;

import static org.junit.Assert.assertTrue;


public class WhenUserAddNewRecord {

    AngularPage angularPage = new AngularPage();

    @Given("^user is on the angular page$")
    public void  user_is_on_the_angular_page(){
        angularPage.open();
    }

    @When("^user add new task \"(.*)\"$")
    public void user_add_new_task(String taskName){
        angularPage.addTask(taskName);
    }

    @Then("^\"(.*)\" should appear in the list")
    public void itemShouldAppearInTheList(String taskName) {
        assertTrue(angularPage.isItemPresentInList(taskName));
    }

    @Then("^tasks should appear in the list")
    public void tasksShouldAppearInTheList(DataTable dataTable) {
        dataTable.asList(String.class).forEach(this::itemShouldAppearInTheList);
    }

    @And("^remove \"(.*)\"$")
    public void removeApple(String taskName){
      angularPage.removeTask(taskName);
    }

    @When("^user adds new task$")
    public void user_adds_new_task(DataTable dataTable) {
        List<String> data = dataTable.asList(String.class);
        data.forEach(this::user_add_new_task);
    }
}
