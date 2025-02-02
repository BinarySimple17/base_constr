package references;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * В Java у каждого примитивного типа есть соответствующий "объектный" тип. Например, для int существует пара
 * в виде Integer. Последний представлен классом и называется классом-оберткой.
 */

@SuppressWarnings({"WrapperTypeMayBePrimitive", "UnnecessaryBoxing", "StringEquality", "NumberEquality", "ConstantValue", "MismatchedQueryAndUpdateOfCollection", "SameParameterValue"})
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
// куча методов
/*        String txt = "Ссылочный тип";
        value5 = Integer.parseInt("456789");
        value5 = Integer.valueOf("4444");*/


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

        Double dbl11 = Double.valueOf(100);
        Double dbl12 = Double.valueOf(100);
//        две строки из символа
        String str11 = String.valueOf('D');
        String str12 = String.valueOf('D');
//      две строки из литерала
        String str21 = "D";
        String str22 = "D";
        System.out.println(str21 == str22); //?
        System.out.println(str11 == str12); //? +интернирование


        Integer int01 = 100;            //неявный вызов valueOf
        Integer int02 = 100;
        Integer int11 = Integer.valueOf(100);
        Integer int21 = 200;
        Integer int22 = 200;

        System.out.println(int21 == int22); //?
        System.out.println(int21.equals(int22));
        System.out.println(int21.intValue() == int22.intValue());

        System.out.println(int01.intValue() == int02.intValue());
        System.out.println(int01 == int02); //?
    }

    private void printInt(int i) {
        System.out.println("int: " + i);
    }

    private void printInt(Integer i) {
        System.out.println("Integer: " + i);
    }
}
