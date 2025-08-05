import java.util.*;

public class NumberGuessingGameTask1 {
    public static void main(String[] args) {
        // NUMBER GUESSING GAME
         System.out.println("WELCOME TO NUMBER GUESSING GAME :) ");
        Scanner sc = new Scanner(System.in);
        Random random = new Random();
        int totalWins = 0;
        String playAgain;

        do {
            int hidden_number = random.nextInt(100) + 1;
            int attempts = 0;
            int maximum_attempts = 6;

            System.out.println("Guess one number between 1 to 100. Be Careful ! You have only " + maximum_attempts + " attempts!");

            while (attempts < maximum_attempts) {
                System.out.print("Enter your number : ");
                int numGuess = sc.nextInt();
                attempts++;

                if (numGuess == hidden_number) {
                    System.out.println(" Correct! :) \n You guessed it in " + attempts + " attempts.");
                    totalWins++;
                    break;
                } else if (numGuess < hidden_number) {
                    System.out.println("Too low! :( ");
                } else {
                    System.out.println("Too high! :(  ");
                }
            }

            if (attempts == maximum_attempts) {
                System.out.println("YOU LOSE \n Out of attempts The number was: " + hidden_number + " \n Better Luck Next Time ");
            }

             sc.nextLine(); // consume leftover newline
            System.out.print("Do you want to play Number Guessing Game again? (yes/no): ");
            playAgain = sc.nextLine();

        } while (playAgain.equalsIgnoreCase("yes"));

        System.out.println("Thanks for playing! Your final score is: " + totalWins);
        sc.close();
    }
}
