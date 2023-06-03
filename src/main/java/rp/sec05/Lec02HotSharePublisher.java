package rp.sec05;

import reactor.core.publisher.Flux;
import rp.courseutil.Util;

import java.time.Duration;
import java.util.stream.Stream;

public class Lec02HotSharePublisher {

    public static void main(String[] args) {
        Flux<String> movieStream = Flux.fromStream(Lec02HotSharePublisher::getMovie)
                .delayElements(Duration.ofSeconds(2)).share(); // share convert cold publisher to hot one
        movieStream.subscribe(Util.subscriber("Natalia"));

        Util.sleepSeconds(8);

        movieStream.subscribe(Util.subscriber("Krzysztof"));

        Util.sleepSeconds(60);

    }

    // netflix
    private static Stream<String> getMovie() {
        System.out.println("Got the movie streaming request");
        return Stream.of(

                "Scene 1",
                "Scene 2",
                "Scene 3",
                "Scene 4",
                "Scene 5",
                "Scene 6",
                "Scene 7"
        );
    }
}
