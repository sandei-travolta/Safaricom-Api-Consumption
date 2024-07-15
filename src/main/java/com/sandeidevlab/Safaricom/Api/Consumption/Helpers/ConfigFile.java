package com.sandeidevlab.Safaricom.Api.Consumption.Helpers;

import io.github.cdimascio.dotenv.Dotenv;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConfigFile {
    @Bean
    public Dotenv dotenv(){
        return Dotenv.configure().load();
    }
}
