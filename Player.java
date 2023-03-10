import java.util.ArrayList;
import java.util.Scanner;


public class Player{

    public ArrayList<String> incorrectGuesses = new ArrayList<>();
    public ArrayList<String> allGuesses = new ArrayList<>();

    public ArrayList<String> counterGuess = new ArrayList<>();

    public ArrayList<String> splitHangmanArr = new ArrayList<>();
    public ArrayList<String> splitUnderscoreArr = new ArrayList<>();

    public String revealedAnswer;

    public int livesRemaining;

    public Player(int livesRemaining, String revealedAnswer) {
        this.livesRemaining = livesRemaining;
        this.revealedAnswer= revealedAnswer;
    }


    public int getLivesRemaining() {
        return livesRemaining;
    }

    public void setLivesRemaining(int livesRemaining) {
        this.livesRemaining = livesRemaining;
    }

    public void guess(String hangmanWord, String underscoreWord) {
        Scanner scanner = new Scanner(System.in);
        String answer = scanner.nextLine().toLowerCase();
        splitHangmanWord(hangmanWord);
        splitUnderscore(underscoreWord);
        String[] splitCheck = answer.split("");

        if (splitCheck.length > 1) {
            checkRevealMultiple(splitCheck);
            addAllGuess(answer);


        } else if (hangmanWord.contains(answer)) {
            correctFirstGuess(answer);
            addAllGuess(answer);


        } else if (!(answer.chars().allMatch(Character::isLetter))) {
            System.out.println("Sorry! I don't recognise that, try another letter.");
            addAllGuess(answer);


        } else if (allGuesses.contains(answer)) {
            System.out.println("You've already used that one! Try a different letter!!");

        } else {
            addAllGuess(answer);
            wrongGuess(answer);
            removeLife();
        }
    }



    public void removeLife() {
        setLivesRemaining(getLivesRemaining() - 1);
    }

    public void displayLives() {
        System.out.println("You have " + getLivesRemaining() + " lives remaining!");

    }


    public void nextGuess(String hangmanWord) {
        Scanner scanner = new Scanner(System.in);
        String answer = scanner.nextLine().toLowerCase();
        String[] splitCheck = answer.split("");

        if (splitCheck.length > 1) {
            checkRevealMultiple(splitCheck);
            addAllGuess(answer);

        } else if (hangmanWord.contains(answer) && (!(allGuesses.contains(answer)))) {
            correctFirstGuess(answer);

        } else if (allGuesses.contains(answer)) {
            System.out.println("You've already used that one! Try a different letter!!");

        } else if (!(answer.chars().allMatch(Character::isLetter))) {
            System.out.println("Sorry! I don't recognise that, try another letter.");
        } else {
            wrongGuess(answer);
            removeLife();
        }
    }

    public String revealAnswer
            (ArrayList<String> splitHangmanArr, ArrayList<String> splitUnderscoreArr, String answer) {
        for (int i = 0; i < splitHangmanArr.size(); i++) {
            if (splitHangmanArr.get(i).contains(answer)) {
                splitUnderscoreArr.set(i, answer);
                setSplitUnderscoreArr(splitUnderscoreArr);
                String joinedUnderscore = String.join("", splitUnderscoreArr);
                setRevealedAnswer(joinedUnderscore);
            }
        }
        return getRevealedAnswer();
    }


    public void checkRevealMultiple(String[] splitCheck) {
        for (String letter : splitCheck) {
            if (!(splitHangmanArr.contains(letter))) {
                System.out.println("Sorry! One of those letters were wrong, (" + letter + ") was incorrect so you've lost a life:");
            }
            correctGuess(letter);
            counterCorrectGuess(letter);
        }
        System.out.println("Whoa you got " + counterGuess + " all right!");
        counterGuess.clear();
    }


    public void counterCorrectGuess(String letter) {
        counterGuess.add(letter);
    }

    public void correctFirstGuess(String answer) {
        System.out.println("Yeah! That's right!");
        revealAnswer(splitHangmanArr, splitUnderscoreArr, answer);
        isEmpty();
    }

    public void correctGuess(String answer) {
        revealAnswer(splitHangmanArr, splitUnderscoreArr, answer);
        isEmpty();
    }


    public void wrongGuess(String answer) {
        addIncorrectGuess(answer);
        System.out.println("Oh no! That's incorrect, you've lost a life");
        showIncorrectGuesses();
    }


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


    public void isEmpty() {
        if (incorrectGuesses.size() < 0) {
            showIncorrectGuesses();
        }
    }

}







