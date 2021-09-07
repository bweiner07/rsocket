package com.brad.client.messaging;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.rsocket.RSocketRequester;

@Configuration
public class ClientConfiguration {

    @Bean
    public RSocketRequester rSocket(RSocketRequester.Builder builder){
        return builder.tcp("localhost", 7070);
    }
}
