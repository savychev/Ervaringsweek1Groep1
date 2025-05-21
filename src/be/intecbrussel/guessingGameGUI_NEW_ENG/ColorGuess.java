package be.intecbrussel.guessingGameGUI_NEW_ENG;

import java.util.List;

public class ColorGuess extends AbstractGuessingGame {
    private static final List<String> COLORS = List.of("red", "blue", "green", "yellow", "orange", "purple");
    private String secretColor;

    public ColorGuess() {
        resetSecret();
    }

    @Override
    public String getPrompt() {
        return "Guess the color (" + String.join(", ", COLORS) + "):";
    }

    @Override
    public String guess(String input) {
        if (guessed) return "Already guessed!";
        String guess = input.trim().toLowerCase();
        if (!COLORS.contains(guess)) {
            return "Enter a valid color!";
        }
        int cmp = guess.compareTo(secretColor);
        if (cmp == 0) {
            guessed = true;
            return "Correct! The color was " + secretColor + ".";
        }
        return (cmp < 0)
                ? "The color comes alphabetically after."
                : "The color comes alphabetically before.";
    }

    @Override
    protected void resetSecret() {
        secretColor = COLORS.get(SharedRandom.RANDOM.nextInt(COLORS.size()));
    }
}
