package com.brad.client.messaging;

import lombok.RequiredArgsConstructor;
import org.springframework.messaging.rsocket.RSocketRequester;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequiredArgsConstructor
public class RSocketMessaging {
    private final RSocketRequester  requester;

    @GetMapping("/request")
    public Mono<String> request(){
        return requester.route("my_request")
                .data("Howdy")
                .retrieveMono(String.class);
    }
}
