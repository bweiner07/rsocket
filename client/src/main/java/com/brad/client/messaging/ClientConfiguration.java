package com.brad.client.messaging;

import io.rsocket.RSocket;
import io.rsocket.core.RSocketClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.rsocket.RSocketRequester;

@Configuration
public class ClientConfiguration {

    @Bean
    public RSocketRequester rSocket(){
        return RSocketRequester.builder().tcp("localhost", 7070);
    }
}
