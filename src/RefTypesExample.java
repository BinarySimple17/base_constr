import model.Creature;
import model.CreatureTmp;
import model.Human;

public class RefTypesExample {

    @SuppressWarnings("FieldCanBeLocal")
    private final int ageMid = 40;

    public void run() {

        showMainRefTypes();

        showEnum();

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
    }
}
