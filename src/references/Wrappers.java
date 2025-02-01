package references;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * В Java у каждого примитивного типа есть соответствующий "объектный" тип. Например, для int существует пара
 * в виде Integer. Последний представлен классом и называется классом-оберткой.
 */

public class Wrappers {
    public static void main(String[] args) {
        new Wrappers().run();
    }

    public void run() {


// Примитивный тип
// Можно так
        var value = 42; // int
// Или так
        int value2 = 42; // int

// Ссылочный тип
// Можно так
        Integer value3 = 42; // Integer
        Integer value4 = Integer.valueOf(42); // Integer
        var value5 = Integer.valueOf(42); // Integer

        showAutoboxing();

    }


    private void showAutoboxing() {

        int j = 1;
        Integer i = Integer.valueOf(5);

//        List<int> listP= new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);

//        Autoboxing
        i++;
//        int tmpI = i.intValue();
//        tmpI++;
//        i = Integer.valueOf(tmpI);

//        boxing + unboxing
        printInt(200);
        printInt(i);

//        кеш, пул стрингов, интернирование .intern(), equals/==
//        Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
//        System.gc();

        Scanner sc = new Scanner(System.in);
        sc.nextInt();

        Integer[] integerArray = new Integer[1000_000];
        int p = 0;
        Long memBegin = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
        for (int k = 0; k < 1000_000; k++) {
            p++;
/*            if (p>129) {
                p = 0;
            }*/
            integerArray[k] = p;
        }
        Long memEnd = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
        System.out.println(memEnd - memBegin);


        sc.nextInt();

        memBegin = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
        int[] intArray = new int[1000_000];

        memEnd = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
        System.out.println(memEnd - memBegin);


//        Long memBegin = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
        Integer int01 = 100;
//        Long memEnd = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
//        System.out.println(memEnd - memBegin);
        Integer int02 = 100;

        Integer int11 = Integer.valueOf(100);
        Integer int12 = Integer.valueOf(100);
//                Integer int13 = new Integer(100);

        Double dbl11 = Double.valueOf(100);
        Double dbl12 = Double.valueOf(100);
        String str11 = String.valueOf('D');
        String str12 = String.valueOf('D');

        String str21 = "D";
        String str22 = "D";
        System.out.println(str11 == str12); //? +интернирование
        System.out.println(str21 == str22); //?

        Integer int21 = 200;
        Integer int22 = 200;

        System.out.println(int01 == int02); //?
        System.out.println(int21 == int22); //?!
        System.out.println(int21.equals(int22));
    }

    private void printInt(int i) {
        System.out.println("int: " + i);
    }

    private void printInt(Integer i) {
        System.out.println("Integer: " + i);
    }
}
