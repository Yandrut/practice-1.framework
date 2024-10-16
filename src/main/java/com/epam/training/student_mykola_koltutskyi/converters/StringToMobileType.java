package com.epam.training.student_mykola_koltutskyi.converters;

import org.aeonbits.owner.Converter;
import com.epam.training.student_mykola_koltutskyi.enums.MobilePlatformType;
import java.lang.reflect.Method;

public class StringToMobileType implements Converter<MobilePlatformType> {

    @Override
    public MobilePlatformType convert(Method method, String mobilePlatformType) {
        return mobilePlatformType.equals("ANDROID")?
                MobilePlatformType.ANDROID :
                MobilePlatformType.IOS;
    }
}