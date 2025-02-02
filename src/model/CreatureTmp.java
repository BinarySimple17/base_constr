package model;

public class CreatureTmp {

    private final String text;

    public CreatureTmp(String text) {
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
