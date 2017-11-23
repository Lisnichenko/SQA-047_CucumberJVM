package model;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class AngularPage extends BasePage {

    @FindBy(id = "new-todo")
    WebElement todoInput;
    @FindBy(css = "#todo-list")
    WebElement todoList;

    public AngularPage(WebDriver driver) {
        super(driver);
    }

    public AngularPage open() {
        driver.get("http://todomvc.com/examples/angularjs/#/");
        return this;
    }

    public AngularPage addTask(String taskName) {
        todoInput.sendKeys(taskName);
        todoInput.sendKeys(Keys.ENTER);
        return this;
    }

    public boolean isItemPresentInList(String taskName) {
        return !findTaskInList(taskName).isEmpty();
    }

    private List<WebElement> findTaskInList(String taskName) {
        return todoList.findElements(By.xpath("//*[text()='" + taskName + "']"));
    }

    public AngularPage removeTask(String taskName) {
        if (isItemPresentInList(taskName)) {
            new Actions(driver).moveToElement(findTaskInList(taskName).get(0)).build().perform();
            findTaskInList(taskName).get(0).findElement(By.xpath("./following-sibling::button")).click();
        } else {throw new NoSuchElementException("No task found in list");}
        return this;
    }
}
