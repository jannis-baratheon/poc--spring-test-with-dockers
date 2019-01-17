package it.jwisniowski.example.springtestwithdockers.application.externalservice;

import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;

public class ParentContextNeedsToBeActiveContextInitializer
    implements ApplicationContextInitializer<ConfigurableApplicationContext> {
    @Override
    public void initialize(ConfigurableApplicationContext context) {
        if (!((ConfigurableApplicationContext)context.getParent()).isActive()) {
            throw new RuntimeException("PARENT NOT STARTED");
        }
    }
}
