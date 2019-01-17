package it.jwisniowski.example.springtestwithdockers.application;

import static org.assertj.core.api.Assertions.assertThat;

import it.jwisniowski.example.springtestwithdockers.application.externalservice.ParentContextNeedsToBeActiveContextInitializer;
import it.jwisniowski.example.springtestwithdockers.application.externalservice.Service2ContextInitializer;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.ContextHierarchy;
import org.springframework.test.context.TestPropertySource;

@ContextHierarchy({
    @ContextConfiguration(initializers = Service2ContextInitializer.class),
    // force context reload
    @ContextConfiguration(classes = {
        MyAppContext.class,
        ParentContextNeedsToBeActiveContextInitializer.class
    })
})
@TestPropertySource(properties = {
    "service2.host=${test.service2.host}",
    "service2.port=${test.service2.port}"
})
public class MyAppWithService1AndService2ITImpl extends MyAppWithService1IT {

    @Autowired
    private MyAppConfigurationProperties myAppConfigurationProperties;

    @Test
    public final void Service2ContextInitializer_is_applied() {
        assertThat(myAppConfigurationProperties)
            .hasFieldOrPropertyWithValue("service2.host", "service2host")
            .hasFieldOrPropertyWithValue("service2.port", 4321);
    }
}
