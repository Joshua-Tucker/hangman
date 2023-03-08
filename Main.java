
public class Main {
    public static void main(String[] args) {

        String[] wordsList = {"card" , "bottle", "dog", "skateboard", "japan", "keyboard", "hiking" };


        WordLibrary wordLibrary = new WordLibrary(wordsList);
        Narrator narrator = new Narrator();
        Player player = new Player();

        String underscoreRandomWord = wordLibrary.underscoreRandomWord();
        String hangmanWord = wordLibrary.getHangmanWord();


        narrator.greeting();
        narrator.firstRound();
        System.out.println(underscoreRandomWord);
        player.guess(hangmanWord);











    }
}
