package rp.stepVerifier;

import com.github.javafaker.Space;
import org.junit.jupiter.api.Test;
import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;
import rp.courseutil.Util;
import rp.stepVerifier.entities.SpaceShip;

import java.time.Duration;
import java.util.List;

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
        ).delayElements(Duration.ofSeconds(1));
    }

    private Flux<SpaceShip> fluxWithErrors() {
        return Flux.just(
                new SpaceShip("Hawk", 10),
                new SpaceShip("Eagle", 5),
                new SpaceShip("Round", 10),
                new SpaceShip("Swan", 22),
                new SpaceShip("Eagle", 25),
                new SpaceShip("Pyramid", 23),
                new SpaceShip("Pirx", 11),
                new SpaceShip("Luska", 12)
        ).delayElements(Duration.ofSeconds(1)).map(ship -> {
            if (ship.getName().equals("Round")) {
                throw new RuntimeException(String.format("The ship is round!!! %s", ship));

            }
            return ship;
        });
    }

    @Test
    void testTheFluxWithStepVerifier() {
        List<SpaceShip> lastShips = List.of(
                new SpaceShip("Swan", 22),
                new SpaceShip("Eagle", 25),
                new SpaceShip("Pyramid", 23),
                new SpaceShip("Pirx", 11),
                new SpaceShip("Luska", 12)
        );
        Flux<SpaceShip> flux = flux();
        flux().subscribe(Util.subscriber("test "));
        StepVerifier.create(flux)
                .expectNext(new SpaceShip("Hawk", 10))
                .expectNext(new SpaceShip("Eagle", 5))
                .expectNext(new SpaceShip("Round", 10))
//                .expectNext(new SpaceShip("Swan", 22))
//                .expectNext(new SpaceShip("Eagle", 25))
//                .expectNext(new SpaceShip("Pyramid", 23))
//                .expectNext(new SpaceShip("Pirx", 11))
//                .expectNext(new SpaceShip("Luska", 12))
//                .expectNextCount(5)
//                .expectNextMatches(ship -> ship.getCrew() > 1)
//                .expectNextMatches(ship -> ship.getCrew() > 1)
//                .expectNextMatches(ship -> ship.getCrew() > 1)
//                .expectNextMatches(ship -> ship.getCrew() > 1)
//                .expectNextMatches(ship -> ship.getCrew() > 1)
//                .expectNextCount(12) // expect 6 pieces of data
                .expectNextSequence(lastShips)
                .expectComplete()// then expect complete
//                .verifyLater() // non blocking verification
                .verify(); // verify starts assertions

        System.out.println("Test end");
    }

    @Test
    void testTheFluxWitErrorAndWithStepVerifier() {
        Flux<SpaceShip> flux = fluxWithErrors();
        flux().subscribe(Util.subscriber("test "));
        StepVerifier.create(flux)
                .expectNext(new SpaceShip("Hawk", 10))
//                .expectNext(new SpaceShip("Eagle", 5))
                .expectError()
                .verify(); // verify starts assertions

        System.out.println("Test end");
    }

}