package references;


/**
 * Null-безопасность и Nullability
 */

public class NullExample {

    public static void main(String[] args) {
        new NullExample().run();
    }

    public void run() {

    }

    class Person {


        final private String id;

        final private float height;
        //        @Nullable
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
