package com.leaning.reactive.reactivelearning;

import org.junit.Test;
import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;

public class FluxAndMonoTest {

    @Test
    public void fluxTest() {
        Flux<String> stringFlux = Flux.just("I", "LOVE", "SPRING-BOOT")
                                   /* .concatWith(Flux.error(new RuntimeException("Error Occured")))*/
                                    .log();
        stringFlux
                .subscribe(System.out::println, (e) -> e.printStackTrace(), () -> System.out.println("On Complete"));
    }

    @Test
    public void fluxTestElements_withoutError() {
        Flux<String> stringFlux = Flux.just("I", "LOVE", "SPRING-REACTOR")
                                    .log();
        StepVerifier
                .create(stringFlux)
                .expectNext("I", "LOVE", "SPRING-REACTOR")
                .verifyComplete();
    }

    @Test
    public void fluxTestElements_withError() {
        Flux<String> stringFlux = Flux.just("I", "LOVE", "SPRING-REACTOR")
                                        .concatWith(Flux.error(new RuntimeException("Error in Processing")))
                                        .log();
        StepVerifier
                .create(stringFlux)
                .expectNext("I", "LOVE", "SPRING-REACTOR")
                .expectError(RuntimeException.class)
                .verify();

    }

    @Test
    public void fluxTestElements_withErrorMessages() {
        Flux<String> stringFlux = Flux.just("I", "LOVE", "SPRING-REACTOR")
                                        .concatWith(Flux.error(new RuntimeException("Test Error Message")))
                                        .log();
        StepVerifier
                .create(stringFlux)
                .expectNext("I", "LOVE", "SPRING-REACTOR")
                .expectErrorMessage("Test Error Message")
                .verify();
    }


}
