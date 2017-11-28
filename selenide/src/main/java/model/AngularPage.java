package model;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.NoSuchElementException;

import java.util.List;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$x;
import static java.util.stream.Collectors.toList;

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

    public List<String> getTasks(){
       return  $$x("//*[@class='view']/label").stream()
                .map(SelenideElement::getText).collect(toList());
    }
}
