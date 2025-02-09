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
    private boolean exposed;

    Creature(final String text) {
        this.text = text;
    }

    @Override
    public String resetColor() {
        return "\033[0m";
    }

    public String getReadableText() {
        return getColor() + text + resetColor();           //+reset
    }

    @Override
    public String toString() {
        return text;
    }

    @Override
    public abstract String getColor();

    public boolean isExposed() {
        return exposed;
    }

    public void setExposed(boolean exposed) {
        this.exposed = exposed;
    }
}
