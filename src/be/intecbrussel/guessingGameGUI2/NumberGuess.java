package be.intecbrussel.guessingGameGUI2;

public class NumberGuess extends AbstractGuessingGame {

    private int secret;
    private static final int MIN = 1;
    private static final int MAX = 100;

    public NumberGuess() {
        reset();
    }

    @Override
    public String getPrompt() {
        return "Guess the number ("+MIN+"‑"+MAX+"):";
    }

    @Override
    public String guess(String input) {
        if (guessed) {
            return "Already guessed!";
        }
        int value;
        try {
            value = Integer.parseInt(input.trim());
        } catch (NumberFormatException ex) {
            return "Please enter a valid integer.";
        }
        if (value == secret) {
            guessed = true;
            return "Correct! The number was " + secret + ".";
        }
        return (value < secret) ? "Too low." : "Too high.";
    }

    @Override
    public void reset() {
        super.reset();
        secret = SharedRandom.RANDOM.nextInt(10) + 1; // 1–10
    }


}
