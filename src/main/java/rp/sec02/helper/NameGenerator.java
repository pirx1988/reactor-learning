package rp.sec02.helper;

import reactor.core.publisher.Flux;
import rp.courseutil.Util;

import java.util.ArrayList;
import java.util.List;

public class NameGenerator {


    public static List<String> getNames(int count) {
        List<String> list = new ArrayList<>(count);
        for (int i = 0; i < count; i++) {
            list.add(getName());
        }
        return list;
    }

    public static Flux<String> getNamesFlux(int count) {
        return Flux.range(0, count).map(i -> getName());
    }

    private static String getName() {
        System.out.println("Generating name..");
        Util.sleepSeconds(2);
        return Util.faker().name().fullName();
    }
}
