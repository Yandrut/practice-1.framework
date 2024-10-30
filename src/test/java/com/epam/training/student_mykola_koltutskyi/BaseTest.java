package com.epam.training.student_mykola_koltutskyi;

import com.epam.training.student_mykola_koltutskyi.utils.TestListener;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import com.epam.training.student_mykola_koltutskyi.drivers.DriverProvider;
import org.junit.jupiter.api.extension.ExtendWith;

@ExtendWith(TestListener.class)
public class BaseTest {

    @BeforeEach
    void openBrowser() {
        DriverProvider.initializeDriver();
        var driver = DriverProvider.getDriver();
    }

    @AfterEach
    void quitBrowser() {
        DriverProvider.quit();
    }
}