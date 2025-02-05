package model;

import java.util.Objects;

public class Human implements Humanoid, Comparable {

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
//        В Java есть класс Objects, который предоставляет метод toString().
//        Полезен для обработки null-значений.
//        Objects.toString(name, "null")

//    IDE (IntelliJ IDEA, Eclipse) и библиотеки (Lombok) могут автоматически генерировать метод toString().
        StringBuilder sb = new StringBuilder();
        sb.append(type.getReadableText());
        sb.append(" ");
        sb.append(name);
        sb.append(" ");
        sb.append(age);
        return sb.toString();
    }

    @Override
    public boolean equals(Object obj) {
//        Проверка ссылок
        if (this == obj) {
            return true;
        }
//        Проверка null и классов
//        instanceof или getClass()? нужно определиться со стратегией при проектировании классов.
//        генерация IDE?
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }

//        Приведение типов и сравнение атрибутов
        Human person = (Human) obj;
        return age == person.age && Objects.equals(name, person.name);
    }

    @Override
    public int hashCode() {
//        Всегда переопределяйте hashCode(), если переопределяете equals().
//        Используйте все значимые поля для вычисления хэш-кода.
//        Избегайте сложных вычислений в hashCode()
//        в Equals я использовал только name и age. type пусть будет не значимым.
        return Objects.hash(name, age);
    }

    @Override
    public int compareTo(Object o) {
        return 0;
    }
}