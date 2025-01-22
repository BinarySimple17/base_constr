package typing;

import java.io.Serializable;

public class Typing {
    public static void main(String[] args) {
        new Typing().run();
    }

    public void run() {
        showInstanceOf();
        showGetClass();
    }

    private void showInstanceOf() {
//        instanceof НЕ гарантирует, что проверяемый объект принадлежит к нужному классу.
//        Он проверяет лишь то, что нужный класс есть в иерархии проверяемого объекта.
//        Т.е. sthObj instanceof Object будет true для любого объекта, вне зависимости от его настоящего типа.
        Object i = Integer.valueOf(123);

        System.out.println(i instanceof Integer);
        System.out.println(i instanceof Number);
        System.out.println(i instanceof Serializable);

/*        switch (i){
            case instanceof Integer -> System.out.println("Integer")
            case instanceof String -> System.out.println("String")
        }*/

        if (i instanceof Integer) {
            System.out.println("Integer");
        } else if (i instanceof String) {
            System.out.println("String");
        }

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

        //switch может работать с примитивными типами (int, char, byte и т.д.), их обертками (Integer, Character, Byte и т.д.), а также с String и enum.
        //Integer.class и String.class — это объекты типа Class
        var className = i.getClass().getSimpleName();

        switch (className) {
            case "Integer" -> System.out.println("Integer");
            case "String" -> System.out.println("String");
            default -> System.out.println("Unknown");
        }
    }
}
