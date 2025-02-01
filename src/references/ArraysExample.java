package references;

import model.Creature;
import model.Human;
import model.Humanoid;
import org.openjdk.jol.info.ClassLayout;

import javax.print.attribute.Attribute;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Arrays;

public class ArraysExample {


//    https://topjava.ru/blog/rukovodstvo-po-massivam-v-java-ch3

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

        System.out.println(numbers);
        System.out.println(names);

//      смотрим в класс, который есть, но его скрывают
        System.out.println("смотрим в класс, который есть, но его скрывают");
        darkSideOfJavaForArrays();

        arrayLength();

    }

    private void darkSideOfJavaForArrays() {
        int[] array = {1, 2, 3, 4, 5, 6};
        System.out.println("Тип массива - " + array.getClass());
        System.out.println("Суперкласс типа массива - " + array.getClass().getSuperclass());

        System.out.println("Доступные методы:");
        for (Method m : array.getClass().getMethods()) {                //возвращает только public-методы
            System.out.println(m.getName());
        }

        System.out.println("--------------");
        Object obj;
        obj = array;                //каст к Object ошибок не вызывает
        System.out.println(obj);
        obj.toString();

//      Объекты с заголовком, но без выделенной памяти по сам массив
        String[] array1 = {};
        char[] array2 = new char[0];
//        null это не то - указатель не будет указывать никуда
        int[] arrayNull = null;
        arrayNull = array;
        System.out.println(array);
        System.out.println(arrayNull);
    }

    private void arrayLength(){
        int[] array = {1, 2, 3, 4, 5, 6};
        System.out.println(array.length);


        System.out.println("Доступные поля класса");

/*        try {
            Field field = array.getClass().getDeclaredField("length");
            field.setAccessible(true);
        } catch (NoSuchFieldException e) {
            System.out.println(e);
        }*/

        for (Field f :array.getClass().getFields()){                    //public fields
            System.out.println(f);
        }

//        System.out.println(ClassLayout.parseInstance(array));

    }

}
