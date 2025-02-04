package methods;

import model.Creature;
import model.Human;

import java.lang.reflect.Array;
import java.util.Arrays;

public class ToString {
    public static void main(String[] args) {
        new ToString().run();
    }

    public void run() {
        Human[] humans = new Human[]{ new Human("name1",0, Creature.REPTILIAN),
                                      new Human("name2",1, Creature.REPTILIAN),
                                      new Human("name3",2, Creature.HUMAN),
                                      new Human("name4",3, Creature.HUMAN)
        };

        System.out.println(Arrays.toString(humans));
    }

}
