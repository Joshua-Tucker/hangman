import java.util.Arrays;

public class WordLibrary {


    String[] words;
    String hangmanWord;

    public String getHangmanWord() {
        return hangmanWord;
    }

    public void setHangmanWord(String hangmanWord) {
        this.hangmanWord=hangmanWord;
    }

    public WordLibrary(String[] words) {
        this.words = words;
    }

    @Override
    public String toString() {
        return Arrays.toString(words);
    }

    public String underscoreRandomWord() {
        setHangmanWord(words[(int) (Math.random() * words.length)]);
        String underscoreWord = hangmanWord.replaceAll("[a-zA-Z]", "_");
        return underscoreWord;
    }


}



