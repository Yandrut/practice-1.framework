package com.epam.training.student_mykola_koltutskyi.elements;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebElement;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
public class ElementList {
    private final List<Button> elementList;

    public ElementList(List<WebElement> listOfWebElements) {
        this.elementList = listOfWebElements.stream()
                .map(Button::new)
                .collect(Collectors.toList());
    }

    public void selectFromList(String elementText) {
        elementList.stream()
                .filter((element) -> element.getText().equals(elementText))
                .findAny()
                .ifPresent(Button::waitAndClick);
        log.info("Choosing an option: {}", elementText);
    }
}