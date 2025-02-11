import methods.Equals;
import methods.Hashcode;
import methods.ToString;
import model.Creature;
import model.Human;
import primitive.Primitives;
import references.*;
import statements.StatementsExample;

public class Main {

    final float ALMOST_TEN = 9.9999999f;

    public static void main(String[] args) {

        System.out.println("Примитивные типы");                             //+
        Primitives primitives = new Primitives();
        primitives.run();

        System.out.println("Ссылочные типы");                               //+
        new RefTypesExample().run();

        System.out.println("null");                                        //+
        new NullExample().run();

        System.out.println("Операторы");                                    //+
        new StatementsExample().run();

        System.out.println("обертки");                                      //+
        new Wrappers().run();

        System.out.println("массивы");                                      //+
        new ArraysExample().run();

        System.out.println("перечисления");                                 //+
        new EnumExample().run();

        System.out.println("Optional");                                     //+*
        new OptionalExample().run();

        System.out.println("Cloneable");                                    //+
        new RefTypesExample().cloneable(new Human("Original 1", 123, Creature.REPTILIAN));

        System.out.println("toString()");                                   //+
        new ToString().run();

        System.out.println("equals()");                                    //+
        new Equals().run();

        System.out.println("hashcode()");                                  //+
        new Hashcode().run();


    }


}