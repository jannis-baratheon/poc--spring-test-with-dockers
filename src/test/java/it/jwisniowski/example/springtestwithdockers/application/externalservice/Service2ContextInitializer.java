package it.jwisniowski.example.springtestwithdockers.application.externalservice;

import com.google.common.collect.ImmutableMap;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.MapPropertySource;

public class Service2ContextInitializer
    implements ApplicationContextInitializer<ConfigurableApplicationContext> {
    @Override
    public void initialize(ConfigurableApplicationContext context) {
        context.getEnvironment().getPropertySources().addFirst(
            new MapPropertySource("service2",
                ImmutableMap.<String, Object>builder()
                    .put("test.service2.host", "service2host")
                    .put("test.service2.port", "4321")
                    .build()));
    }
}
