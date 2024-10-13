package org.yandrut.config;

import org.aeonbits.owner.Config;
import org.yandrut.converters.StringToBrowserType;
import org.yandrut.enums.BrowserType;

@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources(
        { "system:properties",
        "system:env",
        "file:${user.dir}/src/test/resources/config.properties"
        })
public interface ConfigureFramework extends Config {
    @DefaultValue("CHROME")
    @ConverterClass(StringToBrowserType.class)
    BrowserType browser();
}