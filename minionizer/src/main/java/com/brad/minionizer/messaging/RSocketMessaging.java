package com.brad.minionizer.messaging;

import com.brad.minionizer.business.Minion;
import com.brad.minionizer.business.MinionBusinessService;
import lombok.RequiredArgsConstructor;
import org.springframework.messaging.handler.annotation.MessageMapping;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@org.springframework.stereotype.Controller
@RequiredArgsConstructor
public class RSocketMessaging {
    private final MinionBusinessService service;
    @MessageMapping("my_request")
    public Flux<Minion> requestResponse(Mono<String> command){
        return command.doOnNext(System.out::println).thenMany(service.getMinions());
    }
}
