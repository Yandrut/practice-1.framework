package com.epam.training.student_mykola_koltutskyi.utils;

import lombok.Builder;
import lombok.Getter;
import com.epam.training.student_mykola_koltutskyi.enums.BrowserType;
import com.epam.training.student_mykola_koltutskyi.enums.MobilePlatformType;

@Builder
@Getter
public class DriverData {
    private BrowserType browserType;
    private MobilePlatformType platformType;
}
