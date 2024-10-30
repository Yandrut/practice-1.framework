package com.epam.training.student_mykola_koltutskyi.configure;

import org.aeonbits.owner.Config;
import com.epam.training.student_mykola_koltutskyi.converters.StringToBrowserType;
import com.epam.training.student_mykola_koltutskyi.converters.StringToMobileType;
import com.epam.training.student_mykola_koltutskyi.converters.StringToUrlConverter;
import com.epam.training.student_mykola_koltutskyi.enums.MobilePlatformType;
import java.net.URL;
import com.epam.training.student_mykola_koltutskyi.enums.BrowserType;

@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources(
        { "system:properties",
        "system:env",
        "file:${user.dir}/src/main/resources/config.properties"
        })
public interface ConfigureFramework extends Config {
    @DefaultValue("CHROME")
    @ConverterClass(StringToBrowserType.class)
    BrowserType browser();

    @ConverterClass(StringToMobileType.class)
    MobilePlatformType platformType();

    @ConverterClass(StringToUrlConverter.class)
    URL localAppiumServerURL();
}