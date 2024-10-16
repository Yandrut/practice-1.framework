package com.epam.training.student_mykola_koltutskyi.utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.epam.training.student_mykola_koltutskyi.pages.EmailGeneratorPage;

public class EmailGenerator {
    private final String generatedEmail;
    private static final Logger log = LogManager.getLogger(EmailGenerator.class);

    public EmailGenerator(EmailGeneratorPage page) {
        generatedEmail = page.getGeneratedEmail();
        log.info("Email Generated{}", generatedEmail);
    }

    public String getGeneratedEmail() {
        return generatedEmail;
    }
}