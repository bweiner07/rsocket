package com.brad.client.messaging;

import com.brad.client.business.BusinessService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RestController
@RequiredArgsConstructor
public class RSocketMessaging {
    private final BusinessService service;

    @GetMapping("/request")
    public Flux<Minion> request(){
        return service.getRequest()
                .doOnNext(System.out::println);

    }

}
