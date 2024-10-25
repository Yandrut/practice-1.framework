package com.epam.training.student_mykola_koltutskyi.elements;

import com.epam.training.student_mykola_koltutskyi.drivers.DriverProvider;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class InputText extends Element {

    public InputText(WebElement element) {
        super(element);
    }

    public void sendKeys(String ... keySequence) {
        this.element.sendKeys(keySequence);
    }

    public void clear() {
        this.element.clear();
    }

    public void sendKeysAction(String... keySequence) {
        Actions action = new Actions(DriverProvider.getDriver());
        action.sendKeys(this.element, keySequence).build().perform();
    }
}