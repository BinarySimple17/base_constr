package model;

public enum Creature implements Colorable {

    //Перечисления могут реализовывать интерфейсы, что позволяет добавлять дополнительное поведение к константам.
    //Перечисление с конструктором и полем
    HUMAN("Ordinary Human") {
        @Override
        public String getColor() {
            return "\033[0;37m";                //white
        }
    },
    REPTILIAN("Reptilian from Mars") {
        @Override
        public String getColor() {
            return "\033[0;32m";                //green
        }
    };

    private final String text;

    Creature(final String text) {
        this.text = text;
    }

    public String getReadableText() {
        return getColor() + text + "\033[0m";           //+reset
    }

    @Override
    public String toString() {
        return text;
    }

    public abstract String getColor();
}
