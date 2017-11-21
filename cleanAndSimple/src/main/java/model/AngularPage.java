package model;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AngularPage extends BasePage {

    @FindBy(id="new-todo")
    WebElement todoInput;
    @FindBy(css="#todo-list")
    WebElement todoList;

    public AngularPage(WebDriver driver) {
        super(driver);
    }

    public AngularPage open() {
        driver.get("http://todomvc.com/examples/angularjs/#/");
        return this;
    }

    public void addTask(String taskName) {
        todoInput.sendKeys(taskName);
        todoInput.sendKeys(Keys.ENTER);
    }

    public boolean isItemPresentInList(String taskName) {
       return todoList.findElements(By.xpath("//*[text()='"+taskName+"']")).isEmpty();
    }
}
