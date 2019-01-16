package it.jwisniowski.example.springtestwithdockers.application.externalservice;

import com.google.common.collect.ImmutableMap;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.MapPropertySource;

public class Service1ContextInitializer
    implements ApplicationContextInitializer<ConfigurableApplicationContext> {
    @Override
    public void initialize(ConfigurableApplicationContext context) {
        context.getEnvironment().getPropertySources().addFirst(
            new MapPropertySource("service1",
                ImmutableMap.<String, Object>builder()
                    .put("test.service1.host", "service1host")
                    .put("test.service1.port", "1234")
                    .build()));
    }
}
