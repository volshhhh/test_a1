package com.example.unauthorizeddeliveries.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "app.files")
public class AppConfig {
    private String logins;
    private String postings;

    public String getLogins() {
        return logins;
    }

    public void setLogins(String logins) {
        this.logins = logins;
    }

    public String getPostings() {
        return postings;
    }

    public void setPostings(String postings) {
        this.postings = postings;
    }
}