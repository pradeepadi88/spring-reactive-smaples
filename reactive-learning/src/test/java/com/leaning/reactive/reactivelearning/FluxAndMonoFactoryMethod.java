package com.leaning.reactive.reactivelearning;

import org.junit.Test;
import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;

import java.util.Arrays;
import java.util.List;

public class FluxAndMonoFactoryMethod {

    @Test
    public void createFluxFromList() {
        List<String> stringList = Arrays.asList("I", "Love", "Spring-Reactive");
        Flux<String> stringFlux = Flux.fromIterable(stringList);

        StepVerifier
                .create(stringFlux.log())
                .expectNext("I", "Love", "Spring-Reactive")
                .verifyComplete();
    }

    @Test
    public void createFluxFromArray(){
        String[] strings = new String[]{"I", "LOVE", "SPRING-REACTIVE"};
        Flux<String> stringFlux = Flux.fromArray(strings);

        StepVerifier
                .create(stringFlux.log())
                .expectNext("I", "LOVE", "SPRING-REACTIVE")
                .verifyComplete();
    }

    @Test
    public void createFluxFromStream() {
        List<String> stringList = Arrays.asList("I", "Love", "Spring-Reactive");

    }
}
