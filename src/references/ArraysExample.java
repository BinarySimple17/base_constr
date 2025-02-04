package references;

import model.Creature;
import model.Human;
import model.Humanoid;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
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

//      смотрим в класс, который есть, но его скрывают
        System.out.println("смотрим в класс, который есть, но его скрывают");
        darkSideOfJavaForArrays();

        arrayLength();

        arrayUtils();

    }

    private void arrayUtils() {

        System.out.println("Arrays.toString()");
        int[] nums = {2, 4, 6, 8, 10};
        System.out.println(Arrays.toString(nums));

        Example[] arr = {new Example(1), new Example(2), new Example(3)};
//        вызывается метод valueOf(). если элемент массива не равен null,
//        то у него вызывается toString(). Но т. к. у Example не реализован toString(), то используется реализация
//        из класса Object, доставшаяся ему по наследству
        System.out.println(Arrays.toString(arr));


        System.out.println("Копирование массивов");
//        наивная реализация
//        перебор в цикле
        int[] srcArr = {1, 7, 3, 8, 5, 8,8,8,8,8,8,8};
        int[] destArr = new int[srcArr.length];

// процесс копирования
        for (int i = 0; i < destArr.length; i++) {
            destArr[i] = srcArr[i];
        }

        System.out.println("Arrays.copyOf()");
        int[] destArr2 = Arrays.copyOf(srcArr, srcArr.length + 3);      //новый массив больше старого, будет дополнен
        //согласно спецификации (§10.7) массивы переопределяют метод Object.clone
        System.out.println(Arrays.toString(destArr2));

        System.out.println("Arrays.copyOfRange()");
        int[] destArr3 = Arrays.copyOfRange(srcArr, 1, 3);
        System.out.println(Arrays.toString(destArr3));

        System.out.println("System.arrayCopy()");
        int[] destArr4 = new int[srcArr.length - 1];
//                      Object src, int srcPos, Object dest, int destPos, int length
        System.arraycopy(srcArr, 1, destArr4, 0, destArr4.length);
        System.out.println(Arrays.toString(destArr4));

//        System.arraycopy(), как и методы копирования из Arrays, делают неглубокую копию (shallow copy) объектов, копируя только ссылки
        Example[] examples = {new Example(10), new Example(20), new Example()};
        var examplesCopy = Arrays.copyOf(examples, examples.length);
//        изменяем атрибут последнего объекта в копии массива
        examplesCopy[examples.length - 1].num = 999;
        System.out.println(Arrays.toString(examples));
        System.out.println(Arrays.toString(examplesCopy));
        examplesCopy = Arrays.copyOf(examples, examples.length);        //восстанавливаем копию

        System.out.println("Arrays.fill()");
        nums = new int[4];
        Arrays.fill(nums, 36);
        System.out.println(Arrays.toString(nums));

        String[] stringArr = new String[10];
        Arrays.fill(stringArr, 3, 7, "Ja-a-va");
        System.out.println(Arrays.toString(stringArr));

        System.out.println("Arrays.equals()");
        System.out.println("(examples, examplesCopy:)" + Arrays.equals(examples, examplesCopy));
        System.out.println("examples == examplesCopy:" + (examples == examplesCopy));

//         сортировка и бинарный поиск
        Arrays.sort(srcArr);
        System.out.println(Arrays.binarySearch(srcArr, 8));

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

    private void arrayLength() {
        int[] array = {1, 2, 3, 4, 5, 6};
        System.out.println(array.length);


        System.out.println("Доступные поля класса");

/*        try {
            Field field = array.getClass().getDeclaredField("length");
            field.setAccessible(true);
        } catch (NoSuchFieldException e) {
            System.out.println(e);
        }*/

        for (Field f : array.getClass().getFields()) {                    //public fields
            System.out.println(f);
        }

//        System.out.println(ClassLayout.parseInstance(array));

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
