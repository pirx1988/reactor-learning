package rp.sec04.helper;

import lombok.Data;
import lombok.ToString;
import rp.courseutil.Util;

@Data
@ToString
public class Person {
    private String name;
    private int age;

    public Person() {
        this.name = Util.faker().name().firstName();
        this.age = Util.faker().random().nextInt(1, 30);
    }
}
