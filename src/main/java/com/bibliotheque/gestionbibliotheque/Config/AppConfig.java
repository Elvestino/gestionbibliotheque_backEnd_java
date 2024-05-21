package com.bibliotheque.gestionbibliotheque.Config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Value("${app.url}")
    private String appUrl;

    public String getAppUrl() {
        return appUrl;
    }
}
