package model;

public enum Creature {

//Перечисление с конструктором и полем
    HUMAN("Normal model.Human"),
    REPTILIAN("Reptilian");

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
