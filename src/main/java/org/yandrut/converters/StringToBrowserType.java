package org.yandrut.converters;

import org.aeonbits.owner.Converter;
import org.yandrut.enums.BrowserType;

import java.lang.reflect.Method;
import java.util.Map;

public class StringToBrowserType implements Converter <BrowserType> {

    @Override
    public BrowserType convert(Method method, String nameOfTheBrowser) {
        Map<String, BrowserType> browserTypes = Map.
                of("CHROME", BrowserType.CHROME,
                "FIREFOX", BrowserType.FIREFOX,
                "EDGE", BrowserType.EDGE);
        return browserTypes.getOrDefault(nameOfTheBrowser, BrowserType.CHROME);
    }
}
