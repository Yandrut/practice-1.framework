package org.yandrut.service;

import lombok.Builder;
import lombok.Getter;
import org.yandrut.enums.BrowserType;
import org.yandrut.enums.MobilePlatformType;

@Builder
@Getter
public class DriverData {
    private BrowserType browserType;
    private MobilePlatformType platformType;
}
