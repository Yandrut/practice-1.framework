package org.yandrut.config;

import org.aeonbits.owner.Config;
import org.yandrut.converters.StringToBrowserType;
import org.yandrut.converters.StringToMobileType;
import org.yandrut.converters.StringToUrlConverter;
import org.yandrut.enums.MobilePlatformType;
import java.net.URL;
import org.yandrut.enums.BrowserType;

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