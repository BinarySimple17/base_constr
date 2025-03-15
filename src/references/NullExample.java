package references;


import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Optional;

/**
 * Null-безопасность и Nullability
 * org.jetbrains.annotations-1.7.0
 * NullPointerException
 */

public class NullExample {

    public static void main(String[] args) {
        new NullExample().run();
    }

    public void run() {

        Person person = new Person("ID73648723", null, 0);
        int age = 0;

//        безопасный код может корректно обработать null
        System.out.println(person.getAge());

//        NullPointerException
        try {
            age = person.getAge();
        } catch (NullPointerException e) {
            System.err.println(e);
        }

        if (person.getAge() != null) {
            age = person.getAge();
        }

        Integer newAge;
        Optional<Integer> optionalAge = Optional.ofNullable(person.getAge());
        newAge = optionalAge.map(a -> a.intValue()).orElse(-1);
        System.out.println(newAge);

    }

    class Person {

        @NotNull
        final private String id;


        private Integer age;

        final private float height;

        public Person(@NotNull String id, Integer age, float height) {
            this.id = id;
            this.age = age;
            this.height = height;
        }


        public @NotNull String getId() {
            return id;
        }

        public float getHeight() {
            return height;
        }


        public Integer getAge() {
            return age;
        }

        public void setAge(Integer age) {
            this.age = age;
        }
    }
}
