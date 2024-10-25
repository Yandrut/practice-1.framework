package com.epam.training.student_mykola_koltutskyi.elements;

import com.epam.training.student_mykola_koltutskyi.drivers.DriverWaiter;
import org.openqa.selenium.WebElement;

public class Element {
    protected final WebElement element;

    public Element(WebElement element) {
        this.element = element;
    }

    public String getAttribute(String attribute) {
        return this.element.getAttribute(attribute);
    }

    public String getText() {
        return this.element.getText();
    }

    public WebElement waitForElementToBeVisible() {
        DriverWaiter.waitForElementToBeVisible(this.element);
        return this.element;
    }

    public WebElement waitForElementToBeVisible(WebElement element) {
        DriverWaiter.waitForElementToBeVisible(element);
        return element;
    }
}