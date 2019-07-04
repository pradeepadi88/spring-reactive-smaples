package com.leaning.reactive.reactivelearning;

import org.junit.Test;
import reactor.core.publisher.Flux;

public class FluxAndMonoTest {

    @Test
    public void fluxTest() {
        Flux<String> stringFlux = Flux.just("I", "LOVE", "SPRING-BOOT")
                                    .concatWith(Flux.error(new RuntimeException("Error Occured")));
        stringFlux
                .subscribe(System.out::println, (e) -> e.printStackTrace());
    }
}
[d2'sq']