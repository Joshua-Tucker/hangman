import java.util.ArrayList;
import java.util.Scanner;

public class Player {

ArrayList<String> guesses = new ArrayList<>();

    public void addGuess(String guess){
        guesses.add(guess);
    }

    public void showIncorrectGuesses() {
        System.out.println("Your incorrect guesses so far...");
        for (String guess: guesses) {System.out.println(guess);};

    }
    public void guess(String guess) {
        Scanner scanner = new Scanner(System.in);
        String answer = scanner.nextLine().toLowerCase();
        if(guess.contains(answer)){
            addGuess(answer);
            System.out.println("Yeah! That's right!");
            showIncorrectGuesses();
        }else{
            addGuess(answer);
            System.out.println("Oh no! That's incorrect, you've lost a life");
            showIncorrectGuesses();

        }


    }
}
