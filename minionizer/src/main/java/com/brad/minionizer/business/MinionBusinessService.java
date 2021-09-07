package com.brad.minionizer.business;

import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

import java.util.List;
import java.util.Random;

@Service
public class MinionBusinessService {

    public Flux<Minion> getMinions(){
        List<Minion> minions = List.of(Minion.builder().name("Bob").favoriteFood("Apple").build(),
                Minion.builder().name("Stuart").favoriteFood("Banana").build(),
                Minion.builder().name("Kevin").favoriteFood("Pineapple").build(),
                Minion.builder().name("Carl").favoriteFood("Carrot").build(),
                Minion.builder().name("Phil").favoriteFood("Squash").build());

        Random random = new Random();
        return Flux.fromIterable(minions).map(min -> random.nextInt()).filter(num -> num % 2 == 0).map(num -> minions.get(random.nextInt(minions.size())));
    }
}
