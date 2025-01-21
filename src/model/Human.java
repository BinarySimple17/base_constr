package model;

public class Human implements Humanoid {
    private String name;
    private int age;
    private Creature type;

    public Human(String name, int age, Creature type) {
        this.name = name;
        this.age = age;
        this.type = type;
    }

    public Creature getType() {
        return type;
    }

    public void setType(Creature type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public void walk(Direction direction) {

        switch (direction) {
            case Direction.LEFT -> {
                System.out.println("walking left " + Humanoid.WAY_LENGTH + "m");
            }
            case Direction.RIGHT -> {
                System.out.println("walking right " + Humanoid.WAY_LENGTH + "m");
            }

            default -> {
                System.out.println("Fly");
            }
        }
    }

    @Override
    public String toString() {
        return String.format("%s %s %s @0x%010X", type.getReadableText(), name, age, hashCode());
    }
}
