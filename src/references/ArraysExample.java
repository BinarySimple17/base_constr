package references;

import model.Creature;
import model.Human;
import model.Humanoid;

import java.util.Arrays;

public class ArraysExample {

    public static void main(String[] args) {
        new ArraysExample().run();
    }

    /**
     * Объект без класса, но наследник Object
     * int[] array; — общепринятый Java-стиль
     * int [] array;
     * int array[];
     * int array [];
     */
    public void run() {


        int[] ints = new int[1000];         //выделяется память под хранение 1000 интов
        String[] names = new String[5];     // выделяется память под хранение 5 ссылок на строку

        int[] numbers = {1, 2, 3};          //быстрая инициализация. Длина массива, объявленного таким образом, зависит от количества перечисленных элементов

        System.out.println("Инициализация");
        Humanoid[][] humanoids = new Humanoid[3][4];    //0..2 0..3
        System.out.println(Arrays.toString(humanoids));
        humanoids[1][2] = new Human("Russ Hanneman", 40, Creature.HUMAN);       //инициализация по индексу
        humanoids[0][3] = new Human("Laurie Bream", 40, Creature.REPTILIAN);    //инициализация по индексу
        System.out.println(Arrays.toString(humanoids));

//        foreach
        for (Humanoid[] hLine : humanoids) {
            for (Humanoid h : hLine) {
                System.out.println(h);
            }
        }

        System.out.println(numbers);
        System.out.println(names);
    }

    class Example {
        int num;

        public Example(int num) {
            this.num = num;
        }

        public Example() {
            this.num = 777;
        }

    }


}
