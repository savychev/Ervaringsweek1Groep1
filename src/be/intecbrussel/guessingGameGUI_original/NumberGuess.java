package be.intecbrussel.guessingGameGUI_original;

public class NumberGuess extends AbstractGuessingGame<Integer> {
    private static final int MAX_NUMBER = 100;

    @Override
    protected Integer getNewSecret() {
        return SharedRandom.RANDOM.nextInt(MAX_NUMBER) + 1;
    }

    @Override
    public String getPrompt() {
        return "Guess the number (1-" + MAX_NUMBER + "):";
    }

    @Override
    public String guess(String input) {
        if (guessed) return "Already guessed!";
        int guessNumber;
        try {
            guessNumber = Integer.parseInt(input.trim());
        } catch (NumberFormatException e) {
            return "Not a number!";
        }
        if (guessNumber == secret) {
            guessed = true;
            return "Correct! The number was " + secret + ".";
        } else if (guessNumber < secret) {
            return "The number is higher!";
        } else {
            return "The number is lower!";
        }
    }
}
