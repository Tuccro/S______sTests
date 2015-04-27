import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        String[] array = {"five", "fivetwo", "fourfive", "fourfivetwo", "one", "onefiveone", "two", "twofivefourone"};

        List<Word> wordList = new ArrayList<>(array.length);

        for (String word : array) {
            wordList.add(new Word(word, word.length()));
        }

        // Sort words List by length
        Collections.sort(wordList, (Word w1, Word w2) -> w2.getLength() - w1.getLength());

        // Search for and delete words. Start with the longest
        for (Word sought : wordList) {
            wordList.stream()
                    .filter(word -> !sought.equals(word))
                    .filter(word -> word.getText().contains(sought.getText()))
                    .forEach(word -> word.setText(word.getText()
                            .replaceAll(sought.getText(), "")));
        }

        int emptyWordMaxLength = 0;
        for (Word word : wordList) {
            // Search max empty word length
            if (word.getText().equals("") && word.getLength() > emptyWordMaxLength) {
                emptyWordMaxLength = word.getLength();
            }
        }

        System.out.println(emptyWordMaxLength);
    }

}
