package model;

public class CreatureTmp implements Colorable {

    private final String text;

    public CreatureTmp(String text) {
        this.text = text;
    }

    public String getReadableText() {
        return getColor() + text + "\033[0m";
    }

    @Override
    public String toString() {
        return text;
    }

    @Override
    public String getColor() {
        return switch (text) {
            case "HUMAN" -> "\033[0;37m";
            case "REPTILIAN" -> "\033[0;32m";
            default -> "\033[0m";
        };
    }
}
