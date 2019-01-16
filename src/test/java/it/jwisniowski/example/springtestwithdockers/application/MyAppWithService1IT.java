package it.jwisniowski.example.springtestwithdockers.application;

import static org.assertj.core.api.Assertions.assertThat;

import it.jwisniowski.example.springtestwithdockers.application.externalservice.Service1ContextInitializer;
import org.junit.ClassRule;
import org.junit.Rule;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.ContextHierarchy;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.rules.SpringClassRule;
import org.springframework.test.context.junit4.rules.SpringMethodRule;

@ContextHierarchy({
    @ContextConfiguration(initializers = Service1ContextInitializer.class),
    @ContextConfiguration(classes = MyAppContext.class)
})
@TestPropertySource(properties = {
    "service1.host=${test.service1.host}",
    "service1.port=${test.service1.port}"
})
public class MyAppWithService1IT {

    @ClassRule
    public static final SpringClassRule springClassRule = new SpringClassRule();

    @Rule
    public final SpringMethodRule springMethodRule = new SpringMethodRule();

    @Autowired
    private MyAppConfigurationProperties myAppConfigurationProperties;

    @Test
    public final void Service1ContextInitializer_is_applied() {
        assertThat(myAppConfigurationProperties)
            .hasFieldOrPropertyWithValue("service1.host", "service1host")
            .hasFieldOrPropertyWithValue("service1.port", 1234);
    }
}
