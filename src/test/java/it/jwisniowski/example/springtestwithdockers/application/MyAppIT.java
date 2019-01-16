package it.jwisniowski.example.springtestwithdockers.application;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.ClassRule;
import org.junit.Rule;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.rules.SpringClassRule;
import org.springframework.test.context.junit4.rules.SpringMethodRule;

@ContextConfiguration(classes = MyAppContext.class)
@TestPropertySource(properties = {
    "service1.host=service1baseHost",
    "service1.port=1111",
    "service2.host=service2baseHost",
    "service2.port=2222"
})
public class MyAppIT {
    @ClassRule
    public static final SpringClassRule springClassRule = new SpringClassRule();

    @Rule
    public final SpringMethodRule springMethodRule = new SpringMethodRule();

    @Autowired
    private MyAppConfigurationProperties myAppConfigurationProperties;

    @Test
    public final void configuration_is_applied() {
        assertThat(myAppConfigurationProperties)
            .hasFieldOrPropertyWithValue("service1.host", "service1baseHost")
            .hasFieldOrPropertyWithValue("service1.port", 1111)
            .hasFieldOrPropertyWithValue("service2.host", "service2baseHost")
            .hasFieldOrPropertyWithValue("service2.port", 2222);
    }
}
