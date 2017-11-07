package model;

import org.openqa.selenium.WebDriver;

public class AngularPage {

    public AngularPage open(WebDriver driver) {
        driver.get("http://todomvc.com/examples/angularjs/#/");
        return this;
    }
}
