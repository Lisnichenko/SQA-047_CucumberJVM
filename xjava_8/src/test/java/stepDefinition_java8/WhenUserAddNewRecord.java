package stepDefinition_java8;

import cucumber.api.DataTable;
import cucumber.api.java8.En;
import model.AngularPage;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertTrue;


public class WhenUserAddNewRecord implements En {

    AngularPage angularPage = new AngularPage();

    public WhenUserAddNewRecord() {
        Given("^user is on the angular page$", () -> {
            angularPage.open();
        });

        When("^user adds new (?:task|item) \"(.*)\"$", this::user_adds_new_task);

//        When("^user adds new tasks \"(.+)\"$", (List<String> tasks) -> {
//            tasks.forEach(this::user_adds_new_task);});

        Then("^\"(.*)\" should appear in the list", (String taskName) -> {
            assertTrue(angularPage.isItemPresentInList(taskName));
        });

        Then("^tasks should appear in the list", (DataTable dataTable) -> {
            dataTable.asList(String.class).forEach(this::itemShouldAppearInTheList);
        });

        And("^remove \"(.*)\"$", (String taskName) -> {
            angularPage.removeTask(taskName);
        });

        When("^user adds new task$", (DataTable dataTable) ->{
            dataTable.asList(String.class).forEach(this::user_adds_new_task);
        });

//        Then("^all following tasks should appear in the list \"(.+)\"$", (List <String> tasks) -> {
//            tasks.forEach(this::itemShouldAppearInTheList);
//        });

        Then("^following task table should appear in the list$", (DataTable dataTable) ->{
            List<List<String>> actualItems = new ArrayList<>();
            actualItems.add(angularPage.getTasks());
            dataTable.diff(actualItems);
        });
    }

    private void user_adds_new_task(String taskName) {
        angularPage.addTask(taskName);
    }
    public void itemShouldAppearInTheList(String taskName) {
        assertTrue(angularPage.isItemPresentInList(taskName));
    }
}
