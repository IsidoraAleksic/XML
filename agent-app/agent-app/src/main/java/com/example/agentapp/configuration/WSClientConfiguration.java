package com.example.agentapp.configuration;

import com.example.agentapp.ws.WSClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

@Configuration
public class WSClientConfiguration {

    @Value("${producer.default-uri}")
    private String PRODUCER_URI;

    @Bean
    public Jaxb2Marshaller marshaller() {
        Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
        // this package must match the package in the <generatePackage> specified in pom.xml
        marshaller.setContextPath("schema.wsdl");
        return marshaller;
    }

    @Bean
    public WSClient agentWsClient(Jaxb2Marshaller marshaller) {
        WSClient client = new WSClient();
        client.setDefaultUri(PRODUCER_URI);
        client.setMarshaller(marshaller);
        client.setUnmarshaller(marshaller);
        return client;
    }

}
