package com.farjad.fleet;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;

@SpringBootApplication
public class FleetApplication {

    public static void main(String[] args) {
        SpringApplication.run (FleetApplication.class , args);
    }


}
