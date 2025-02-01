package references;

import model.Creature;
import model.CreatureTmp;
import model.Human;
import typing.Typing;

import java.util.Arrays;
import java.util.Objects;

public class RefTypesExample {

    private static final String HUMAN_TYPE = "human";

    @SuppressWarnings("FieldCanBeLocal")
    private final int ageMid = 40;

    public static void main(String[] args) {
        new RefTypesExample().run();
    }

    public void run() {

//        обертки
        new Wrappers().run();
//        классы
        showMainRefTypes();
//        проверка типов
        new Typing().run();
//        массивы
        new ArraysExample().run();
//        перечисления
        showEnum();

    }


    private void showEnum() {

        //зачем это надо - таких инстанций может быть хоть миллион
        CreatureTmp creatureTmp01 = new CreatureTmp("HUMAN");
        CreatureTmp creatureTmp02 = new CreatureTmp("HUMAN");
        CreatureTmp creatureTmp03 = new CreatureTmp(HUMAN_TYPE);

        System.out.println(creatureTmp01 == creatureTmp02);

        switch (creatureTmp03.getReadableText()) {
            case "HUMAN" -> System.out.println("HUMAN");
            case "REPTILIAN" -> System.out.println("REPTILIAN");
            default -> System.out.println(creatureTmp03.getReadableText());
        }

//        Методы enum
//        Перечисления в Java имеют несколько встроенных методов:
//        values(): Возвращает массив всех констант перечисления.
//        valueOf(String name): Возвращает константу перечисления по её имени.
//        ordinal(): Возвращает порядковый номер константы (начиная с 0).
        System.out.println(Arrays.toString(Creature.values()));
        System.out.println(Creature.valueOf("REPTILIAN"));
        System.out.println(Creature.REPTILIAN.ordinal());

//        Перечисления часто используются в операторе switch, так как они обеспечивают безопасность типов.
//        Перечисления могут реализовывать интерфейсы, что позволяет добавлять дополнительное поведение к константам.
        Creature reptile = Creature.REPTILIAN;
        switch (reptile) {
            case REPTILIAN -> System.out.println(reptile.getReadableText());
            case HUMAN -> System.out.println(reptile.ordinal());
        }

        if (creatureTmp01.equals("HUMAN")) {
            System.out.println("True");
        } else System.out.println("False");

        if (creatureTmp01.equals(creatureTmp02)) {
            System.out.println("True");
        } else System.out.println("False");

        for (Creature c : Creature.values()) {
            System.out.printf("model.Creature %s is called %s%n", c, c.getReadableText());
        }

    }

    private void showMainRefTypes() {

        Human human4 = null;

        int ageYoung = 24;

        Human human1;

//        Создание объектов
//        Объекты ссылочных типов создаются с помощью ключевого слова new
//        При создании объекта выделяется память в куче, и переменная получает ссылку на эту область памяти.

        human1 = new Human("Jian-Yang", ageYoung, Creature.HUMAN);
        Human human2 = new Human("Dinesh Chugtai", ageMid, Creature.HUMAN);
//        Копирование ссылок
//        При присваивании одной ссылочной переменной другой копируется только ссылка, а не объект:
        Human human2_copy = new Human("Dinesh Chugtai", ageMid, Creature.HUMAN);
        var human3 = human1;

        try {
            System.out.println(human4.getName());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

//        Изменения через одну ссылку влияют на объект, доступный через другую ссылку.
        human3.setAge(human1.getAge() + 5);


        // метод toString()
        System.out.println(human1);
        System.out.println(human2);
        System.out.println(human3);
        System.out.println(String.format("human2 and human2_copy equality: %b", human2.equals(human2_copy)));
        System.out.println(String.format("human2 and human2_copy equality: %b", Objects.equals(human2, human2_copy)));

        System.out.println("TO_STRING();");
        String human3String = human3.toString();
        System.out.println(human3String);

//        Java автоматически управляет памятью с помощью сборщика мусора (Garbage Collector, GC). Если на объект больше нет ссылок, он удаляется из памяти.

    }
}
