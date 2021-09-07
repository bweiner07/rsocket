package com.brad.client.business;


import com.brad.client.messaging.Minion;
import lombok.RequiredArgsConstructor;
import org.springframework.messaging.rsocket.RSocketRequester;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;

import java.util.List;
import java.util.Random;

@Component
@RequiredArgsConstructor
public class BusinessService {

    private final RSocketRequester requester;

    public Flux<Minion> getRequest() {
        List<String> commands = List.of("Yell", "Interrogate", "Jump", "Fetch Banana");
        Random randomNumber = new Random();

        return getDataStream(commands.get(randomNumber.nextInt(commands.size())));
    }

    public Flux<Minion> getDataStream(String command) {
        return requester.route("my_request")
                .data(command)
                .retrieveFlux(Minion.class);
    }
}
