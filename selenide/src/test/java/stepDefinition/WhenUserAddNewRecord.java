package stepDefinition;

import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import model.AngularPage;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertTrue;


public class WhenUserAddNewRecord {


//  . Dot means match any single character.
//  * Star, a repetition modifier, takes a character and tells us how many times it can reappear.
//  + Plus, a repetition modifier, takes a character and tells us that the character can be repeated at least once.
//  \d stands for diGitHub, or [0-9].
//  \w stands for a word character, specifically [A-Za-z0-9_].
//  \s stands for a whitespace character, including tab space or line break.

    AngularPage angularPage = new AngularPage();

    @Given("^user is on the angular page$")
    public void  user_is_on_the_angular_page(){
        angularPage.open();
    }

//  Optional capture group means group itseld will be used as a parameter
//  Optional noncapture ?: means that group won't be used as a parameter
    @When("^user adds new (?:task|item) \"(.*)\"$")
    public void user_adds_new_task(String taskName){
        angularPage.addTask(taskName);
    }

    @When("^user adds new tasks \"(.+)\"$")
    public void user_adds_new_task(List<String> tasks){
        tasks.forEach(this::user_adds_new_task);
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
        data.forEach(this::user_adds_new_task);
    }

    @Then("^all following tasks should appear in the list \"(.+)\"$")
    public void tasksFromCollectionShouldAppearInTODOList(List<String> tasks){
        tasks.forEach(this::itemShouldAppearInTheList);
    }

    @Then("^following task table should appear in the list$")
    public void followingTaskTableShouldAppearInTheList(DataTable dataTable) {
        List<List<String>> actualItems = new ArrayList<>();
        actualItems.add(angularPage.getTasks());
        dataTable.diff(actualItems);
    }
}
