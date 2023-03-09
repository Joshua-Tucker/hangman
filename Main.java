
public class Main {
    public static void main(String[] args) {

        String[] wordsList = {"card" , "bottle", "dog", "skateboard", "japan", "keyboard", "hiking" };


        WordLibrary wordLibrary = new WordLibrary(wordsList);
        Player player = new Player();

        String underscoreWord = wordLibrary.underscoreRandomWord();
        String hangmanWord = wordLibrary.getHangmanWord();


        Narrator.greeting();
        Narrator.firstRound();
        System.out.println(underscoreWord);
        player.guess(hangmanWord, underscoreWord);











    }
}
