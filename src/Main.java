import java.sql.Timestamp;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        WordGenerator wg = new WordGenerator(6);

        Scanner scanner = new Scanner(System.in);
        String response = "";

        while (!response.equalsIgnoreCase("q")) {
            System.out.println("When you are ready, type 's' and then type the sentence shown; or 'q' to quit.");

            response = scanner.nextLine();

            if (response.equalsIgnoreCase("q")) {
                System.out.println("Thanks for playing!");
                break;
            } else if (response.equalsIgnoreCase("s")){
                //Generate a scramble of words for the user to type
                String[] generatedWords = wg.generateNewWords();

                for (String word : generatedWords)
                    System.out.print(word + " ");

                System.out.println("");

                //Generate the start time for typing
                Timestamp startTime = new Timestamp(System.currentTimeMillis());

                //Get the typed words from the user
                String typedWords = scanner.nextLine();

                //Generate the stop time for typing
                Timestamp stopTime = new Timestamp(System.currentTimeMillis());

                //Calculations are done, show the results
                long timePassed = stopTime.getTime() - startTime.getTime();
                double secondsPassed = timePassed / 1000.0;

                wg.checkResults(typedWords, secondsPassed);
            }

        }
    }
}