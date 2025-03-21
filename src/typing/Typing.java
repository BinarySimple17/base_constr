package typing;

import model.Creature;
import model.Human;
import model.Humanoid;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

@SuppressWarnings("ConstantValue")
public class Typing {
    public static void main(String[] args) {
        new Typing().run();
    }

    public void run() {
        showInstanceOf();
        showGetClass();
        advancedTyping();
    }

    private void showInstanceOf() {
//        instanceof НЕ гарантирует, что проверяемый объект принадлежит к нужному классу.
//        Он проверяет лишь то, что нужный класс есть в иерархии проверяемого объекта.
//        Т.е. sthObj instanceof Object будет true для любого объекта, вне зависимости от его настоящего типа.


        System.out.println("Оператор instanceof");
        Object object = new Human(null, 0, Creature.REPTILIAN);

        System.out.println(object instanceof Human); // 'true',
        System.out.println(object instanceof Object); // 'true', так как 'object' наследник 'Object'
        System.out.println(object instanceof Math); // 'false', так как 'object' не принадлежит классу 'Math'
        System.out.println(object instanceof Humanoid); // 'true'

        Object i = Integer.valueOf(123);

        System.out.println(i instanceof Integer);
        System.out.println(i instanceof Number);
        System.out.println(i instanceof Serializable);

        if (i instanceof Integer) {
            System.out.println("Integer");
        } else if (i instanceof String) {
            System.out.println("String");
        }

//        switch может работать с примитивными типами (int, char, byte и т.д.), их обертками (Integer, Character, Byte и т.д.), а также с String и enum.
//        Integer.class и String.class — это объекты типа Class
//        но начиная с JDK 17+ работает (как превью):
        String name = switch (i) {
            case Integer ii -> ii.getClass().getSimpleName();
            case String str -> str.getClass().getSimpleName();
            default -> "unknown";
        };

        System.out.println(name);

    }

    private void showGetClass() {
//        Метод getClass() возвращает объект типа Class, соответствующий классу, которому принадлежит изначальный объект.
//        Class — класс, описывающий класс (тип данных) как сущность. Через него можно получить доступ к информации о названии,
//        полях, методах и другим данным о классе, которому принадлежит объект.

        Object i = Integer.valueOf(123);

//        Объект класса Class можно получить двумя способами: первый — через метод getClass() у объекта
        System.out.println(i.getClass());

//        Но кроме этого у каждого класса есть литерал класса, который предоставляет объект класса Class
        System.out.println(Integer.class);

        System.out.println(i.getClass().equals(Integer.class));

        var className = i.getClass().getSimpleName();

        switch (className) {
            case "Integer" -> System.out.println("Integer");
            case "String" -> System.out.println("String");
            default -> System.out.println("Unknown");
        }
    }

    private void advancedTyping() {
//      первоначальная полная запись
        Map<Integer, Map<String, String>> m = new HashMap<Integer, Map<String, String>>();

//      потом ее сократили до автоматического определения "объекта"
        Map<Integer, Map<String, String>> m2 = new HashMap<>();

//      потом появились лямбда-выражения, в которых компилятор сам определял тип переменной на основании интерфейса функции
//      в сами лямбды мы не полезем, здесь они как иллюстрация эволюции расширенной типизации.
        IExample iExample = ch -> {
            System.out.println(ch);
            return (int) ch;
        };
        IExample iExample2 = ch -> (int) ch;


//      потом появился var - указание компилятору на то, что надо самому определить тип переменной на основании правой части.
        var m3 = new HashMap<>();
        var m4 = new HashMap<Integer, Map<String, String>>();

//        VAR
        var i = Integer.valueOf("123");
        var j = 123;
        System.out.println(j);
    }

    @FunctionalInterface
    interface IExample {
        int apply(char c);
    }
}
