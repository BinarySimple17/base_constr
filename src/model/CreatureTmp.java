package model;

public class CreatureTmp implements Colorable, ICreature {

    private final Integer type;

    public CreatureTmp(int type) {
        this.type = type;
    }

    public String getReadableText() {
        return switch (type) {
            case 1 -> getColor() + "HUMAN" + resetColor();
            case 2 -> getColor() + "REPTILIAN" + resetColor();
            default -> getColor() + "ERROR" + resetColor();
        };
    }

    @Override
    public String toString() {
        return switch (type) {
            case 1 -> "HUMAN";
            case 2 -> "REPTILIAN";
            default -> "ERROR";
        };
    }

    @Override
    public String getColor() {
        return switch (type) {
            case 1 -> "\033[0;37m";
            case 2 -> "\033[0;32m";
            default -> "\033[0m";
        };
    }

    @Override
    public String resetColor() {
        return "\033[0m";
    }
}
