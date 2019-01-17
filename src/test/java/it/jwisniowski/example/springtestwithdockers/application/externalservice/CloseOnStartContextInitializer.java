package it.jwisniowski.example.springtestwithdockers.application.externalservice;

import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ApplicationListener;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.GenericApplicationListenerAdapter;

public class CloseOnStartContextInitializer
    implements ApplicationContextInitializer<ConfigurableApplicationContext> {

    @SuppressWarnings("Convert2Lambda")
    @Override
    public void initialize(ConfigurableApplicationContext context) {
        context.addApplicationListener(
            new GenericApplicationListenerAdapter(new ApplicationListener<ContextRefreshedEvent>() {
                @Override
                public void onApplicationEvent(ContextRefreshedEvent event) {
                    context.close();
                }
            }));
    }
}
