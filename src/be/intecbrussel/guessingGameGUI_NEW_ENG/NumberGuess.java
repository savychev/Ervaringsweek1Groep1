package be.intecbrussel.guessingGameGUI_NEW_ENG;

public class NumberGuess extends AbstractGuessingGame {
    private int secretNumber;

    public NumberGuess() {
        resetSecret();
    }

    @Override
    public String getPrompt() {
        return "Guess a number from 1 to 100:";
    }

    @Override
    public String guess(String input) {
        if (guessed) return "Already guessed!";
        int userGuess;
        try {
            userGuess = Integer.parseInt(input.trim());
        } catch (NumberFormatException e) {
            return "Enter a valid number!";
        }
        if (userGuess == secretNumber) {
            guessed = true;
            return "Correct! The number was " + secretNumber;
        } else if (userGuess < secretNumber) {
            return "My number is higher!";
        } else {
            return "My number is lower!";
        }
    }

    @Override
    protected void resetSecret() {
        secretNumber = SharedRandom.RANDOM.nextInt(100) + 1;
    }
}
