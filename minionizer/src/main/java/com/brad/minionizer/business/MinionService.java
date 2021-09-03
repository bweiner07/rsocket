package com.brad.minionizer.business;

import lombok.RequiredArgsConstructor;
import org.springframework.data.mongodb.core.ReactiveMongoTemplate;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class MinionService {

    private final ReactiveMongoTemplate mongo;

    public Mono<Minion> save(Minion minion){
        return mongo.save(minion);
    }

    public Mono<Minion> find(String name){
        return mongo.findById(name, Minion.class);
    }

    public Flux<Minion> findAll(){
        return mongo.findAll(Minion.class);
    }


}
