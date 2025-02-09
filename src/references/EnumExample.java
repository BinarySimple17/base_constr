package references;

import model.Creature;
import model.CreatureAdv;
import model.CreatureTmp;
import model.ICreature;

import java.util.Arrays;

import static model.Creature.HUMAN;
import static model.Creature.REPTILIAN;

public class EnumExample {

    private static final String HUMAN_TYPE = "human";
    private static final int HUMAN_INT_TYPE = 10;

    public static void main(String[] args) {
        new EnumExample().run();
    }

    public void run() {

//        зачем это надо
        ExampleDamagedHuman ex00 = new ExampleDamagedHuman(1);
        ExampleDamagedHuman ex001 = new ExampleDamagedHuman(ExampleDamagedHuman.HUMAN);
        ExampleDamagedHuman ex002 = new ExampleDamagedHuman(HUMAN_INT_TYPE);
        ExampleDamagedHuman ex003 = new ExampleDamagedHuman(-456156549);
//       чтобы уследить за всеми классами, которые используют тип ч/р делаем интерфейс
        ExampleDamagedHuman ex004 = new ExampleDamagedHuman(ICreature.HUMAN);
        ExampleDamagedHuman ex005 = new ExampleDamagedHuman(-45615);

//
        CreatureTmp creatureTmp01 = new CreatureTmp(2);
        CreatureTmp creatureTmp03 = new CreatureTmp(HUMAN_INT_TYPE);

        ExampleBrokenHuman ex01 = new ExampleBrokenHuman(creatureTmp01);
        ExampleBrokenHuman ex02 = new ExampleBrokenHuman(creatureTmp03);

        ExampleHuman ex99 = new ExampleHuman(REPTILIAN);
        ExampleHuman ex98 = new ExampleHuman(HUMAN);


//      разница в сравнении типов
        System.out.println(ex01.getType().equals(ex02.getType()));
        System.out.println(ex99.getType() == ex98.getType());
        System.out.println(ex99.getType() == REPTILIAN);

//        Методы enum
//        Перечисления в Java имеют несколько встроенных методов:
//        values(): Возвращает массив всех констант перечисления.
//        valueOf(String name): Возвращает константу перечисления по её имени.
//        ordinal(): Возвращает порядковый номер константы (начиная с 0).
        System.out.println(Arrays.toString(Creature.values()));
        System.out.println(Creature.valueOf("REPTILIAN"));
        System.out.println(REPTILIAN.ordinal());

//        Перечисления часто используются в операторе switch, так как они обеспечивают безопасность типов.
//        Перечисления могут реализовывать интерфейсы, что позволяет добавлять дополнительное поведение к константам.
        Creature reptile = REPTILIAN;
        switch (reptile) {
            case REPTILIAN -> System.out.println(reptile.getReadableText());
            case HUMAN -> System.out.println(reptile.ordinal());
        }

        for (Creature c : Creature.values()) {
            System.out.printf("model.Creature %s is called %s%n", c.name(), c.getReadableText());
        }

        reptile.setExposed(true);

//       если "значение" перечисления приходит откуда-то в виде строки, например, в JSON
//       при этом Gson или JACKSON, например, такие случаи парсят самостоятельно, если в типе поля указан enum
        Creature creatureFromString = HUMAN; //пусть будет по умолчанию такое, чтобы не null.
        for (Creature d : Creature.values()) {
            if (d.name().equals("REPTILIAN")) {
                creatureFromString = REPTILIAN;
            }
        }

        try {
            creatureFromString = Creature.valueOf("REPTILIAN");
        } catch (IllegalArgumentException e ){
            System.out.println(e);
        }

//        Если, например, Creature это "чужой" класс и он лежит в зоне ответственности другой команды, используется
//        многими другими сервисами и мы не можем менять его поведение по своему усмотрению,
//        (например, метод getColor нам нужен в одном виде, а другим в другом или нужен новый метод), то унаследоваться от enum нельзя.
//        java.lang.Enum объявлен как final
//        можно сделать свою обертку вокруг enum и самостоятельно приводить enum к обертке.
        ExampleHumanExternal ex03external = new ExampleHumanExternal(REPTILIAN);
        ex03external.getType().sayHello();

    }



    class ExampleDamagedHuman {
        public static int HUMAN = 1;
        public static int REPTILIAN = 2;

        final int type;

        public ExampleDamagedHuman(int type) {
            if (type != HUMAN && type != REPTILIAN) {
                this.type = type;
            } else {
                this.type = -1;
            }
        }

        public int getType() {
            return type;
        }

    }

    class ExampleBrokenHuman {
        final private CreatureTmp type;

        public ExampleBrokenHuman(CreatureTmp type) {
            this.type = type;
        }

        public CreatureTmp getType() {
            return type;
        }
    }

    class ExampleHuman {
        final private Creature type;

        public ExampleHuman(Creature type) {
            this.type = type;
        }

        public Creature getType() {
            return type;
        }
    }

    class ExampleHumanExternal {
        final private CreatureAdv type;

        public ExampleHumanExternal(Creature type) {
            this.type = new CreatureAdv(type);
        }

        public CreatureAdv getType() {
            return type;
        }
    }
}
