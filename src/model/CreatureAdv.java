package model;

public class CreatureAdv {
    private final Creature type;

    public CreatureAdv(Creature type) {
        this.type = type;
    }

    public void sayHello() {
        System.out.println(type.getColor() + "Hello" + type.resetColor());
    }
}
