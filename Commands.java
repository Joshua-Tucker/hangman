import java.util.ArrayList;

public class Commands {
    public ArrayList<String> incorrectGuesses = new ArrayList<>();
    public ArrayList<String> allGuesses = new ArrayList<>();

    public ArrayList<String> counterGuess = new ArrayList<>();

    public ArrayList<String> splitHangmanArr = new ArrayList<>();
    public ArrayList<String> splitUnderscoreArr = new ArrayList<>();

    String revealedAnswer;

    public void setSplitUnderscoreArr(ArrayList<String> splitUnderscoreArr) {
        this.splitUnderscoreArr = splitUnderscoreArr;
    }


    public String getRevealedAnswer() {
        return revealedAnswer;
    }

    public void setRevealedAnswer(String revealedAnswer) {
        this.revealedAnswer = revealedAnswer;
    }

    public void addIncorrectGuess(String guess) {
        incorrectGuesses.add(guess);
    }


    public void showIncorrectGuesses() {
        System.out.println("Your incorrect guesses so far...");
        System.out.println(incorrectGuesses);
    }

    public void addAllGuess(String guess) {
        allGuesses.add(guess);
    }

    public void addSplitHangman(String letters) {
        splitHangmanArr.add(letters);
    }

    public void splitHangmanWord(String hangmanWord) {
        String[] splitWordArray = hangmanWord.split("");
        for (String letter : splitWordArray) {
            addSplitHangman(letter);
        }
    }


    public void addSplitUnderscore(String underscores) {
        splitUnderscoreArr.add(underscores);
    }


    public void splitUnderscore(String underscoreWord) {
        String[] splitWordArray = underscoreWord.split("");
        for (String letter : splitWordArray) {
            addSplitUnderscore(letter);
        }
    }

    public void isRepeat(String answer){
        for (String letter:allGuesses) {
            if(letter.contains(answer)){
                System.out.println("You've already used that one! Try a different letter!!");
            }
        }
    }

    public void isEmpty(){
        if (incorrectGuesses.size() < 0) {
            showIncorrectGuesses();
        }
    }

}
