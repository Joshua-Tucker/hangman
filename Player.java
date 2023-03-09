import java.util.ArrayList;
import java.util.Scanner;


public class Player {

    ArrayList<String> incorrectGuesses = new ArrayList<>();
    ArrayList<String> allGuesses = new ArrayList<>();

    ArrayList<String> splitHangmanArr = new ArrayList<>();

    public void setSplitUnderscoreArr(ArrayList<String> splitUnderscoreArr) {
        this.splitUnderscoreArr = splitUnderscoreArr;
    }

    ArrayList<String> splitUnderscoreArr = new ArrayList<>();

    String revealedAnswer;

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
        for (String guess : incorrectGuesses) {
            System.out.println(guess);
        }
        ;
    }

    public void guess(String hangmanWord, String underscoreWord) {
        Scanner scanner = new Scanner(System.in);
        String answer = scanner.nextLine().toLowerCase();
        if (hangmanWord.contains(answer)) {
            splitHangmanWord(hangmanWord);
            splitUnderscore(underscoreWord);
            System.out.println("Yeah! That's right!");
            System.out.println(revealAnswer(splitHangmanArr, splitUnderscoreArr, answer));
            showIncorrectGuesses();
        } else {
            addIncorrectGuess(answer);
            System.out.println("Oh no! That's incorrect, you've lost a life");
            showIncorrectGuesses();
        }
    }

    public String revealAnswer(ArrayList<String> splitHangmanArr, ArrayList<String> splitUnderscoreArr,
                             String guess) {
        for (int i = 0; i < splitHangmanArr.size(); i++) {
            ;//loops through hangman arr
            if (splitHangmanArr.get(i).contains(guess)) { //if anything in this array is the same as the guess
                int correctLetterIndex = i; //then let us know where in the array it is
                splitUnderscoreArr.set(correctLetterIndex, guess);
                setSplitUnderscoreArr(splitUnderscoreArr);                //then go grab the same index in underscore array and replace that with the correct letter
                //add correct letter to orginal array
                String joinedUnderscore = String.join("", splitUnderscoreArr);//join the new undewrscore array
                setRevealedAnswer(joinedUnderscore);
            }
        }return getRevealedAnswer();
    }

    public void addSplit(String letters) {
        splitHangmanArr.add(letters);
    }

    public void splitHangmanWord(String hangmanWord) {
        String[] splitWordArray = hangmanWord.split("");
        for (String letter : splitWordArray) {
            addSplit(letter);
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


    //hangman word and underscore word are the same
    //hangman word is visable underscore is not
    //method to say
    // if (guess.contains(answer){

    //hangmanword=> broken into character array (split)

    //for loop over array and get the index number of correct letter
    //e.g hangmanword=dog
    //guess=o, for each to return index 1(o)
    //then replace index of underscore with index1(o)

    //what do i need to add?
    //arraylist of all guesses
    //arraylist of split hangman word
    //varible of new underscoreword with added correct guesses (global and set each time correct)
    //to show new underscore


}

