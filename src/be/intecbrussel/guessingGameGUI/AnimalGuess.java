package be.intecbrussel.guessingGameGUI;

import java.util.List;

public class AnimalGuess extends AbstractGuessingGame<String> {
    private static final List<String> ANIMALS = List.of(
        "cat", "dog", "lion", "tiger", "elephant", "wolf"
    );

    @Override
    protected String getNewSecret() {
        return ANIMALS.get(SharedRandom.RANDOM.nextInt(ANIMALS.size()));
    }

    @Override
    public String getPrompt() {
        return "Guess the animal:";
    }

    @Override
    public String guess(String input) {
        input = input.toLowerCase();
        if (guessed) return "Already guessed!";
        int cmp = input.compareTo(secret);
        if (cmp == 0) {
            guessed = true;
            return "Correct! The animal was " + secret + ".";
        }
        return (cmp < 0)
            ? "The animal comes alphabetically after " + input + "."
            : "The animal comes alphabetically before " + input + ".";
    }
}
