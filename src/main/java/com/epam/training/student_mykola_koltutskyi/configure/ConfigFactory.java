package com.epam.training.student_mykola_koltutskyi.configure;

import org.aeonbits.owner.ConfigCache;

public final class ConfigFactory {

    private ConfigFactory(){}


    public static ConfigureFramework getConfig() {
        return ConfigCache.getOrCreate(ConfigureFramework.class);
    }
}