package references;

import model.Creature;
import model.CreatureTmp;
import model.Direction;

import java.util.Arrays;

public class EnumExample {

    private static final String HUMAN_TYPE = "human";

    public static void main(String[] args) {
        new EnumExample().run();
    }

    public void run() {

        //зачем это надо - таких инстанций может быть хоть миллион
        CreatureTmp creatureTmp01 = new CreatureTmp("HUMAN");
        Example ex01 = new Example(creatureTmp01, Direction.LEFT);

        CreatureTmp creatureTmp03 = new CreatureTmp(HUMAN_TYPE);
        Example ex02 = new Example(creatureTmp03, Direction.LEFT);

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

    class Example {
        private CreatureTmp type;
        private Direction d;

        public Example(CreatureTmp type, Direction d) {
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
}
