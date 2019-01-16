package it.jwisniowski.example.springtestwithdockers.application;

public class MyAppBean {

    private final MyAppConfigurationProperties configurationProperties;

    public MyAppBean(MyAppConfigurationProperties configurationProperties) {
        this.configurationProperties = configurationProperties;
    }

    public MyAppConfigurationProperties getConfigurationProperties() {
        return configurationProperties;
    }
}
