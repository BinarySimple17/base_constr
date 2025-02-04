package methods;

import model.Creature;
import model.Direction;
import model.Human;

public class Equals {

    public static void main(String[] args) {
        new Equals().run();
    }

    public void run() {

        String str01 = new String("str");
        String str02 = new String("str");

        System.out.println(str01 == str02);
        System.out.println(str01.equals(str02));

        Human[] humans = new Human[]{new Human("name1", 0, Creature.REPTILIAN),
                new Human("name2", 1, Creature.REPTILIAN),
                new Human("name3", 2, Creature.HUMAN),
                new Human("name4", 3, Creature.HUMAN),
                new Human("name4", 4, Creature.HUMAN),
                new Human("name4", 4, Creature.REPTILIAN),
                new Human("name4", 4, Creature.REPTILIAN),
                new Human("name5", 3, Creature.HUMAN)
        };

        IPathWalked ex = new PathWalked(32, Direction.LEFT, 123);
        IPathWalked ex2 = new PathWalked2(32, Direction.LEFT, 123, "John Smith");

        System.out.println(ex.equals(ex2));
    }

    interface IPathWalked {
        void walk(int d);

        int getDistance();
    }

    class PathWalked implements IPathWalked {
        int distance;
        Direction direction;
        Integer id;

        public PathWalked(int distance, Direction direction, Integer id) {
            this.distance = distance;
            this.direction = direction;
            this.id = id;
        }

        @Override
        public void walk(int d) {
            distance += d;
        }

        @Override
        public int getDistance() {
            return distance;
        }

    }

    class PathWalked2 extends PathWalked {

        String name;

        public PathWalked2(int distance, Direction direction, Integer id, String name) {
            super(distance, direction, id);
            this.name = name;
        }

    }
}
