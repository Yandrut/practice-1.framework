package org.yandrut.utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.yandrut.pages.EmailGeneratorPage;

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