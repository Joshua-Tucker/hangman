import java.util.Scanner;

public class Narrator {


    public void greeting() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Hi there! Would you like to play Hangman?");
        System.out.println("Enter Yes or No");
        String answer = scanner.nextLine().toLowerCase();
        if (answer.contains("yes")) {
            System.out.println("Great! Let's begin!");
        } else {
            System.out.println("Okay:( Do you need some time?");
            System.out.println("Enter Yes or No");
            String answerNo = scanner.nextLine().toLowerCase();
            if (answerNo.contains("yes")) {
                System.out.println("...");
                System.out.println("...");
                System.out.println("...");
                System.out.println("...");
                System.out.println("...");
                System.out.println("...");
                System.out.println("Okay! Lets begin!");
            } else {
                System.out.println("Okay! Lets begin!");
            }
        }
    }


    public void firstRound(){
        System.out.println("Here is your first word...");
        System.out.println("3");
        System.out.println("2");
        System.out.println("1");
    }


}
