package it.jwisniowski.example.springtestwithdockers.application;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties
public class MyAppContext {

    @Bean
    public MyAppConfigurationProperties myAppConfigurationProperties() {
        return new MyAppConfigurationProperties();
    }

    @Bean
    public MyAppBean
    myAppBean(MyAppConfigurationProperties configurationProperties) {
        return new MyAppBean(configurationProperties);
    }
}
