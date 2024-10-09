package org.yandrut.Utils;

import org.yandrut.pages.EmailGeneratorPage;

public class EmailGenerator {
    private final String generatedEmail;

    public EmailGenerator(EmailGeneratorPage page) {
        generatedEmail = page.getGeneratedEmail();
    }

    public String getGeneratedEmail() {
        return generatedEmail;
    }
}