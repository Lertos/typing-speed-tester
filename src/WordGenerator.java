import java.util.Random;

public class WordGenerator {

    //Only supplying a few words as this isn't a key practice concept; I'd probably read from a file that lists each word on a line
    private final String[] possibleWords = {"prove", "ankle", "sector", "mistreat", "creation", "right", "positive", "lamb", "export", "doctor"};

    private String[] currentWords;
    private final int amountOfWords;
    private int correctWords;
    private int rawCharsPerMin;
    private int charsPerMin;
    private int charsDivider = 5; //The international standard

    public WordGenerator(int amountOfWords) {
        this.amountOfWords = amountOfWords;
        this.currentWords = new String[amountOfWords];

        resetAllFields();
    }

    //Refill the array with new words
    public String[] generateNewWords() {
        resetAllFields();

        Random generator = new Random();
        int randomIndex;
        int possibleWordsLength = possibleWords.length;

        for (int i=0; i<amountOfWords; i++) {
            randomIndex = generator.nextInt(possibleWordsLength);
            currentWords[i] = possibleWords[randomIndex];
        }

        return this.currentWords;
    }

    //Reset all calculated fields before generating new words
    private void resetAllFields() {
        rawCharsPerMin = 0;
        charsPerMin = 0;
        correctWords = 0;
    }

    //Check the words given by the user against the words generated
    public void checkResults(String givenWords, double elapsedTime) {
        //Split words into an array, check against the generated words
        String[] givenArr = givenWords.split(" ");
        int minLength = Math.min(givenArr.length, currentWords.length);

        for (int i=0; i<minLength; i++) {
            String givenWord = givenArr[i];
            String currentWord = currentWords[i];

            if (givenWord.equalsIgnoreCase(currentWord)) {
                charsPerMin += givenWord.length();
                correctWords++;
            }
            rawCharsPerMin += givenWord.length();
        }
        printResults(elapsedTime);
    }

    //Print the results after all the calculations are finished
    private void printResults(double elapsedTime) {
        double timeMultiplier = 60.0 / elapsedTime;

        System.out.println("---------------------------------------------");
        System.out.println("Your stats are as follows:");
        System.out.println("CPM: " + String.format("%.2f", rawCharsPerMin * timeMultiplier) + "\nWPM: " + String.format("%.2f", (charsPerMin / 5) * timeMultiplier));
        System.out.println("You got " + correctWords + " words correct out of " + amountOfWords);
        System.out.println("You gave your answer in " + String.format("%.2f", elapsedTime) + " seconds");
        System.out.println("---------------------------------------------");
    }

}
