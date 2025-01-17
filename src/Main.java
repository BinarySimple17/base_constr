import primitive.Primitives;
import references.RefTypesExample;
import statements.StatementsExample;

public class Main {

    final static boolean MY_FALSE = false;    //константа

    public static void main(String[] args) {

        //Примитивные типы
        new Primitives().primitiveTypes();

        //Ссылочные типы
        new RefTypesExample().run();

        new StatementsExample().run();
    }


}