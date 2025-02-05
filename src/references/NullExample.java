package references;


import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * Null-безопасность и Nullability
 * org.jetbrains.annotations-1.7.0
 */

public class NullExample {

    public static void main(String[] args) {
        new NullExample().run();
    }

    public void run() {

    }

    class Person {

        @NotNull
        final private String id;
        @Nullable
        final private float height;
        @Nullable
        private Integer age;

        public Person(String name, Integer age, float height) {
            this.id = name;
            this.age = age;
            this.height = height;
        }


        public String getId() {
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
