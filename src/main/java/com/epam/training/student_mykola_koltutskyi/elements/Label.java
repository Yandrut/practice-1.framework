package com.epam.training.student_mykola_koltutskyi.elements;

import org.openqa.selenium.WebElement;

public class Label extends Element {

    public Label(WebElement webElement) {
        super(webElement);
    }

    public String getTextContent() {
        return this.element.getAttribute("textContent");
    }
}