import java.util.Scanner;

public class Narrator {


    public static void greeting() {
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
                System.out.println("To start, you have 8 lives, every wrong answer deducts one. Be careful!!");
            } else {
                System.out.println("Okay! Lets begin!");
                System.out.println("To start, you have 8 lives, every wrong answer deducts one. Be careful!!");

            }
        }
    }


    public static void firstRound(){
        System.out.println("Here is your first word...");
        System.out.println("3");
        System.out.println("2");
        System.out.println("1");
    }

    public static void nextRound(String displayedAnswer){
        System.out.println(displayedAnswer);
        System.out.println("What's your next guess?");
    }


}

