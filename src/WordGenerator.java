public class WordGenerator {

    //Only supplying a few words as this isn't a key practice concept; I'd probably read from a file that lists each word on a line
    private final String[] possibleWords = {"prove", "ankle", "sector", "mistreat", "creation", "right", "positive", "lamb", "export", "doctor"};

    private String[] currentWords;
    private final int amountOfWords;

    //TODO: Make all the calculated fields to show at the end

    public WordGenerator(int amountOfWords) {
        this.amountOfWords = amountOfWords;
        this.currentWords = new String[amountOfWords];
    }

    //Refill the array with new words
    public String[] generateNewWords() {
        resetAllFields();

        return this.currentWords;
    }

    //Reset all calculated fields before generating new words
    private void resetAllFields() {

    }

    //Check the words given by the user against the words generated
    public void checkResults(String givenWords) {
        //Split words into an array, check against the generated words

        printResults();
    }

    //Print the results after all the calculations are finished
    private void printResults() {

    }

    private class Word {

    }
}
