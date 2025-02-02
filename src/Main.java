import primitive.Primitives;
import references.ArraysExample;
import references.EnumExample;
import references.RefTypesExample;
import references.Wrappers;
import statements.StatementsExample;

public class Main {

    final float ALMOST_TEN = 9.9999999f;

    public static void main(String[] args) {

        System.out.println("Примитивные типы");                             //+
        Primitives primitives = new Primitives();
        primitives.run();

        System.out.println("Ссылочные типы");                               //+
        new RefTypesExample().run();

        System.out.println("Операторы");
        new StatementsExample().run();

        System.out.println("обертки");                                      //+
        new Wrappers().run();

        System.out.println("массивы");                                      //+
        new ArraysExample().run();

        System.out.println("перечисления");                                 //+
        new EnumExample().run();

        System.out.println("toString()");

        System.out.println("equals()");

        System.out.println("hashcode");

    }


}