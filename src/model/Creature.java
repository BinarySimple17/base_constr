package model;

public enum Creature {

//Перечисление с конструктором и полем
    HUMAN("Ordinary Human"),
    REPTILIAN("Reptilian from Mars");

    private final String text;

    Creature(final String text) {
        this.text = text;
    }

    public String getReadableText(){
        return text;
    }

    @Override
    public String toString() {
        return text;
    }
}
