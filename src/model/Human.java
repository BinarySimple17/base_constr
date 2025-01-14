package model;

public class Human implements Humanoid {
    private String name;
    private int age;
    private Creature type;

    public Human(String name, int age, Creature type) {
        this.name = name;
        this.age =age;
        this.type = type;
    }

    public Creature getType() {
        return type;
    }

    public void setType(Creature type) {
        this.type = type;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    @Override
    public void walk(Direction direction) {

        switch (direction){
            case Direction.LEFT -> {
                System.out.println("walking left "+ Humanoid.WAY_LENGTH +"m");
            }
            case Direction.RIGHT -> {
                System.out.println("walking right "+ Humanoid.WAY_LENGTH +"m");
            }

            default -> {
                System.out.println("Fly");
            }
        }
    }
}
