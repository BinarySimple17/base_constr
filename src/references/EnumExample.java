package references;

import model.*;

import java.util.Arrays;

public class EnumExample {

    private static final String HUMAN_TYPE = "human";

    public static void main(String[] args) {
        new EnumExample().run();
    }

    public void run() {

        //зачем это надо - таких инстанций может быть хоть миллион
        CreatureTmp creatureTmp01 = new CreatureTmp("HUMAN");
        ExampleBrokenHuman ex01 = new ExampleBrokenHuman(creatureTmp01, Direction.LEFT);

        CreatureTmp creatureTmp03 = new CreatureTmp(HUMAN_TYPE);
//       если "значение" перечисления приходит откуда-то в виде строки, например, в JSON
//       при этом Gson или JACKSON, например, такие случаи парсят самостоятельно, если в типе поля указан enum
        Direction dirFromString = Direction.RIGHT; //пусть будет по умолчанию такое, чтобы не null.
        for (Direction d : Direction.values()) {
            if (d.name().equals("LEFT")) {
                dirFromString = Direction.LEFT;
            }
        }
        ExampleBrokenHuman ex02 = new ExampleBrokenHuman(creatureTmp03, dirFromString);

//        Если, например, Direction это "чужой" класс и он лежит в зоне ответственности другой команды, используется
//        многими другими сервисами и мы не можем менять его поведение по своему усмотрению,
//        (например, метод getColor нам нужен в одном виде, а другим в другом), то унаследоваться от enum нельзя.
//        java.lang.Enum объявлен как final
//        то можно сделать свою обертку вокруг enum и самостоятельно приводить enum к обертке.
        ExampleBrokenHumanExternal ex03 = new ExampleBrokenHumanExternal(creatureTmp03, Direction.LEFT);
        System.out.println(ex03.getD().getColor() + "our color" + "\033[0m");

        switch (ex02.getType().getReadableText()) {
            case "HUMAN" -> System.out.println("HUMAN");
            case "REPTILIAN" -> System.out.println("REPTILIAN");
            default -> System.out.println(creatureTmp03.getReadableText());
        }

        System.out.println(ex01.getType().toString().equals(ex02.getType().toString()));

        System.out.println(ex01.getD() == ex02.getD());
        System.out.println(ex01.getD() == Direction.LEFT);

//        Методы enum
//        Перечисления в Java имеют несколько встроенных методов:
//        values(): Возвращает массив всех констант перечисления.
//        valueOf(String name): Возвращает константу перечисления по её имени.
//        ordinal(): Возвращает порядковый номер константы (начиная с 0).
//        Class.getEnumConstants()
        System.out.println(Arrays.toString(Creature.values()));
        System.out.println(Creature.valueOf("REPTILIAN"));
        System.out.println(Creature.REPTILIAN.ordinal());
        System.out.println(Arrays.toString(Creature.class.getEnumConstants()));

//        Перечисления часто используются в операторе switch, так как они обеспечивают безопасность типов.
//        Перечисления могут реализовывать интерфейсы, что позволяет добавлять дополнительное поведение к константам.
        Creature reptile = Creature.REPTILIAN;
        switch (reptile) {
            case REPTILIAN -> System.out.println(reptile.getReadableText());
            case HUMAN -> System.out.println(reptile.ordinal());
        }

        if (creatureTmp01.toString().equals("HUMAN")) {
            System.out.println("True");
        } else System.out.println("False");

        for (Creature c : Creature.values()) {
            System.out.printf("model.Creature %s is called %s%n", c.name(), c.getReadableText());
        }

        reptile.setExposed(true);
    }

    class ExampleBrokenHuman {
        private CreatureTmp type;
        private Direction d;

        public ExampleBrokenHuman(CreatureTmp type, Direction d) {
            this.type = type;
            this.d = d;
        }

        public CreatureTmp getType() {
            return type;
        }

        public Direction getD() {
            return d;
        }
    }

    class ExampleBrokenHumanExternal {
        final private DirectionAdv d;
        private CreatureTmp type;

        public ExampleBrokenHumanExternal(CreatureTmp type, Direction d) {
            this.type = type;
            this.d = new DirectionAdv(d);
        }

        public CreatureTmp getType() {
            return type;
        }

        public DirectionAdv getD() {
            return d;
        }
    }
}
