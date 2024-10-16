package com.epam.training.student_mykola_koltutskyi.converters;

import lombok.SneakyThrows;
import org.aeonbits.owner.Converter;
import java.lang.reflect.Method;
import java.net.URL;

public class StringToUrlConverter implements Converter<URL> {

    @SneakyThrows
    @Override
    public URL convert(Method method, String url) {
        return new URL(url);
    }
}
