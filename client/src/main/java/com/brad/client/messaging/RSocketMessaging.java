package com.brad.client.messaging;

import com.brad.client.business.BusinessService;
import io.rsocket.util.DefaultPayload;
import lombok.RequiredArgsConstructor;
import org.springframework.messaging.Message;
import org.springframework.messaging.rsocket.RSocketRequester;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

import java.util.Map;

@RestController
@RequiredArgsConstructor
public class RSocketMessaging {
    private final BusinessService service;

    @GetMapping("/request")
    public Flux<Minion> request(){
        return service.getRequest();

    }



    private Minion map(Map<String,Object> minion){
        return Minion.builder().name((String)minion.get("name")).favoriteFood((String)minion.get("favoriteFood")).build();
    }
}
