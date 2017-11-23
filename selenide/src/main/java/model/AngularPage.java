package model;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import org.openqa.selenium.NoSuchElementException;

import static com.codeborne.selenide.Selenide.$;

public class AngularPage {

    public AngularPage open() {
        Selenide.open("http://todomvc.com/examples/angularjs/#/");
        return this;
    }

    public AngularPage addTask(String taskName) {
        $("#new-todo").setValue(taskName).pressEnter();
        return this;
    }

    public boolean isItemPresentInList(String taskName) {
        return !findTaskInList(taskName).isEmpty();
    }

    private ElementsCollection findTaskInList(String taskName) {
        return $("#todo-list").$$x("//*[text()='" + taskName + "']");
    }

    public AngularPage removeTask(String taskName) {
        if (isItemPresentInList(taskName)) {
            findTaskInList(taskName).get(0).hover()
                    .$x("./following-sibling::button").click();
        } else {
            throw new NoSuchElementException("No task found in list");
        }
        return this;
    }
}
