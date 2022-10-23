import java.sql.Timestamp;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String response = "";

        while (!response.equalsIgnoreCase("q")) {
            System.out.println("When you are ready, type 'start' and then type the sentence shown; or 'q' to quit.");

            response = scanner.nextLine();

            if (response.equalsIgnoreCase("q")) {
                System.out.println("Thanks for playing!");
                break;
            } else if (response.equalsIgnoreCase("start")){
                //Generate a scramble of words for the user to type
                //TODO: Fix to generate random words from an object
                System.out.println("this is a full sentence");

                //Generate the start time for typing
                Timestamp startTime = new Timestamp(System.currentTimeMillis());

                //Get the typed words from the user
                String typedWords = scanner.nextLine();

                //Generate the stop time for typing
                Timestamp stopTime = new Timestamp(System.currentTimeMillis());

                //Calculations are done, show the results
                long timePassed = stopTime.getTime() - startTime.getTime();
                double secondsPassed = timePassed / 1000.0;

                System.out.println(secondsPassed);
            }

        }
    }
}