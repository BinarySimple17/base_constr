package methods;

import java.util.HashMap;
import java.util.Objects;

public class Hashcode {
    public static void main(String[] args) {
        new Hashcode().run();
    }

    public void run() {

        HashMap map = new HashMap<>();

        map.put(new Example(1, 1), "one");

//        1. equals есть, hashCode нет
//        2. hashCode есть, equals нет
        String name = (String) map.get(new Example(1, 1));

        System.out.println(name);

        Example ex = new Example(2,2);

//        есть способ получить стандартный хешкод, если переопределили метод
        System.out.println(ex.hashCode());
        System.out.println(System.identityHashCode(ex));


    }

    final class Example {
        private int x, y;

        public Example(int x, int y) {
            this.x = x;
            this.y = y;
        }

/*        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Example example)) return false;
            return x == example.x && y == example.y;
        }*/

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }

        public int getX() {
            return x;
        }

        public void setX(int x) {
            this.x = x;
        }

        public int getY() {
            return y;
        }

        public void setY(int y) {
            this.y = y;
        }
    }
}
