
public class Main {
    public static void main(String[] args) {

        String[] wordsList = {"card", "bottle", "dog", "skateboard", "japan", "keyboard", "hiking"};


        WordLibrary wordLibrary = new WordLibrary(wordsList);
        String underscoreWord = wordLibrary.underscoreRandomWord();
        String hangmanWord = wordLibrary.getHangmanWord();

        Player player = new Player(8, underscoreWord);



        Narrator.greeting();
        Narrator.firstRound();
        System.out.println(underscoreWord);
        player.guess(hangmanWord, underscoreWord);
        player.displayLives();
        while (!player.getRevealedAnswer().equals(hangmanWord)) {
            Narrator.nextRound(player.getRevealedAnswer());
            player.nextGuess(hangmanWord);
            player.displayLives();
            if (player.getLivesRemaining() == 0) {
                System.out.println("Oh no, you ran out of lives! I'm sorry but the game is over");
                break; // exit the loop if the player has run out of lives
            }
            if (player.getRevealedAnswer().equals(hangmanWord)) {
                System.out.println("Congratulations!! That's it, you've won the game with " + player.getLivesRemaining() + " lives left!");
            }

        }
    }

}






