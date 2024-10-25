package com.epam.training.student_mykola_koltutskyi.elements;

import com.epam.training.student_mykola_koltutskyi.drivers.DriverProvider;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class Button extends Element {

    public Button(WebElement element) {
        super(element);
    }

    public void waitAndClick() {
        waitForElementToBeVisible(element).click();
    }

    public void actionClick() {
        new Actions(DriverProvider.getDriver()).moveToElement(element)
                .click()
                .build()
                .perform();
    }

    public void javaScriptClick() {
        JavascriptExecutor js = (JavascriptExecutor) DriverProvider.getDriver();
        js.executeScript("arguments[0].click();", this.element);
    }
}