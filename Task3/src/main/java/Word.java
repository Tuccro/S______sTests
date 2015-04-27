
public class Word {

    private String text;
    private int length;

    public Word(String text, int length) {
        this.text = text;
        this.length = length;
    }


    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }
}
