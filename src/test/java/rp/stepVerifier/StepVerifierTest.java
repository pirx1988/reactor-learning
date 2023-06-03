package rp.stepVerifier;

import org.junit.jupiter.api.Test;
import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;
import rp.courseutil.Util;
import rp.stepVerifier.entities.SpaceShip;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;

class StepVerifierTest {

    private Flux<SpaceShip> flux() {
        return Flux.just(
                new SpaceShip("Hawk", 10),
                new SpaceShip("Eagle", 5),
                new SpaceShip("Round", 10),
                new SpaceShip("Swan", 22),
                new SpaceShip("Eagle", 25),
                new SpaceShip("Pyramid", 23),
                new SpaceShip("Pirx", 11),
                new SpaceShip("Luska", 12)
        ).delayElements(Duration.ofSeconds(2));
    }

    @Test
    void testTheFluxWithStepVerifier() {
        Flux<SpaceShip> flux = flux();
        flux().subscribe(Util.subscriber("test "));
        StepVerifier.create(flux)
                .expectNextCount(8)
                .expectComplete()
                .verify();

        System.out.println("Test end");
    }

}