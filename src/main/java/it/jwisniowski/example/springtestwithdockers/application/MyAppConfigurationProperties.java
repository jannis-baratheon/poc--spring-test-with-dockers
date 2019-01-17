package it.jwisniowski.example.springtestwithdockers.application;

import it.jwisniowski.example.springtestwithdockers.application.validation.Hostname;
import it.jwisniowski.example.springtestwithdockers.application.validation.TcpPort;
import javax.validation.Valid;
import org.apache.commons.lang3.builder.MultilineRecursiveToStringStyle;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.validation.annotation.Validated;

@SuppressWarnings("unused")
@ConfigurationProperties
@Validated
public class MyAppConfigurationProperties {

    @Valid
    private ExternalServiceConfigurationProperties service1;

    @Valid
    private ExternalServiceConfigurationProperties service2;

    public ExternalServiceConfigurationProperties getService1() {
        return service1;
    }

    public void setService1(
        ExternalServiceConfigurationProperties service1) {
        this.service1 = service1;
    }

    public ExternalServiceConfigurationProperties getService2() {
        return service2;
    }

    public void setService2(ExternalServiceConfigurationProperties service2) {
        this.service2 = service2;
    }

    public static class ExternalServiceConfigurationProperties {

        @Hostname
        private String host;

        @TcpPort
        private Integer port;

        public String getHost() {
            return host;
        }

        public void setHost(String host) {
            this.host = host;
        }

        public Integer getPort() {
            return port;
        }

        public void setPort(Integer port) {
            this.port = port;
        }
    }

    @Override
    public String toString() {
        return new ReflectionToStringBuilder(
            this, new MultilineRecursiveToStringStyle()).build();
    }
}
