package references;

import model.Creature;
import model.CreatureTmp;
import model.Human;

import java.lang.ref.SoftReference;
import java.util.Objects;

public class RefTypesExample {

    @SuppressWarnings("FieldCanBeLocal")
    private final int ageMid = 40;

    public static void main(String[] args) {
        new RefTypesExample().run();
    }

    public void run() {

        showArrays();

        showMainRefTypes();

        showEnum();

        showAutoboxing();

    }

    private void showArrays() {

        int[] numbers = {1, 2, 3};
        String[] names = new String[5];


        System.out.println(numbers);
        System.out.println(names);


    }

    private void showAutoboxing() {

        Integer int01 = 100;
        Integer int02 = 100;

        Integer int11 = Integer.valueOf(100);
        Integer int12 = Integer.valueOf(100);
        //        Integer int13 = new Integer(100);

        Double dbl11 = Double.valueOf(100);
        Double dbl12 = Double.valueOf(100);
        String str11 = String.valueOf('D').intern();
        String str12 = String.valueOf('D').intern();

        String str21 = "D";
        String str22 = "D";
        System.out.println(str11 == str12);
        System.out.println(str21 == str22);

        Integer int21 = 200;
        Integer int22 = 200;

        System.out.println(int01 == int02);
        System.out.println(int21 == int22);
        System.out.println(int21.equals(int22));

        printInt(200);
        printInt(int21);
        int21.intValue();
    }

    private void printInt(int i) {
        System.out.println(i);
    }

    private void printInt(Integer i) {
        System.out.println(i);
    }

    private void showEnum() {

        CreatureTmp creatureTmp01 = new CreatureTmp("HUMAN");
        CreatureTmp creatureTmp02 = new CreatureTmp("HUMAN");
        CreatureTmp creatureTmp03 = new CreatureTmp("human");

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

        human1 = new Human("Jian-Yang", ageYoung, Creature.HUMAN);
        Human human2 = new Human("Dinesh Chugtai", ageMid, Creature.HUMAN);
        Human human2_copy = new Human("Dinesh Chugtai", ageMid, Creature.HUMAN);
        var human3 = human1;

        try {
            System.out.println(human4.getName());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        human3.setAge(human1.getAge() + 5);


        System.out.println(human1);
        System.out.println(human2);
        System.out.println(human3);
        System.out.println(String.format("human2 and human2_copy equality: %b", human2.equals(human2_copy)));
        System.out.println(String.format("human2 and human2_copy equality: %b", Objects.equals(human2, human2_copy)));

        System.out.println("TO_STRING();");
        String human3String = human3.toString();
        System.out.println(human3String);

    }
}
