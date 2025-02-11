package references;

import model.Creature;
import model.Human;

import java.util.Objects;

@SuppressWarnings("WriteOnlyObject")
public class RefTypesExample {


    @SuppressWarnings("FieldCanBeLocal")
    private final int ageMid = 40;

//    почти константа. Ссылочная переменная с модификатором final будет привязана
//    к объекту без возможности её как-либо переопределить или приравнять к null. но изменять объект можно
    private final Human hendrix = new Human("Richard Hendricks", 30, Creature.HUMAN);

    public static void main(String[] args) {
        new RefTypesExample().run();
    }

    public void run() {

//        классы
        showClasses();

    }

    private void showClasses() {

        int ageYoung = 24;

        hendrix.setAge(ageYoung);

        Human human1;

//        try {
//            System.out.println(human1.getName());
//        } catch (Exception e) {
//            System.out.println(e.getMessage());
//        }
//        все свойства и поведение целиком определяется классом
//        Создание объектов
//        Объекты ссылочных типов создаются с помощью ключевого слова new
//        При создании объекта выделяется память в куче, и переменная получает ссылку на эту область памяти.

        human1 = new Human("Jian-Yang", ageYoung, Creature.HUMAN);
        Human human2 = new Human("Dinesh Chugtai", ageMid, Creature.HUMAN);
//        Копирование ссылок
//        При присваивании одной ссылочной переменной другой копируется только ссылка, а не объект:
//        !VAR для локальных переменных!
        var human3 = human1;

//      делаем второй объект
        Human human2Copy = new Human("Dinesh Chugtai", ageMid, Creature.HUMAN);

//      теперь хотим сделать копию объекта, но через конструктор работает криво, потому что перед этим приходится
//      инициализировать всю цепочку объектов из которых состоят поля нужно объекта.
//      для решения есть интерфейс Clonable и метод clone и
//      второй способ - использовать механизм сериализации объектов. Для этого объект необходимо сериализовать
//      в байтовый поток, а затем десериализовать обратно в объект. При десериализации создается новый объект
//      с теми же полями и значениями, что и у исходного объекта. implements Serializable. использование механизма
//      сериализации может быть медленнее и менее эффективным, чем использование метода clone()
        Human human2Clone = null;

        try {
            human2Clone = (Human) human2Copy.clone();
        } catch (CloneNotSupportedException e) {
            System.out.println(e);
        }

//        Изменения через одну ссылку влияют на объект, доступный через другую ссылку.
        human3.setAge(human1.getAge() + 5);

        //Сравнение объектов
        System.out.println(human1 == human3);
        System.out.println(human2 == human2Copy);

        System.out.printf("human2 and human2Copy equality: %b%n", human2.equals(human2Copy));
        System.out.printf("human2 and human2Copy equality: %b%n", Objects.equals(human2, human2Copy));
        System.out.printf("human2Copy and human2Clone equality: %b%n", human2Copy.equals(human2Clone));

//      compare, comparable
        System.out.println(human1.compareTo(human2Clone));

        System.out.println("TO_STRING();");
        String human3String = human3.toString();
        System.out.println(human3String);

//        Java автоматически управляет памятью с помощью сборщика мусора (Garbage Collector, GC). Если на объект больше нет ссылок, он удаляется из памяти.

    }


}
