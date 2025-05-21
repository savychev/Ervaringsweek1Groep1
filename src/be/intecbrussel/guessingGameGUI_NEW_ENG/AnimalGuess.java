package be.intecbrussel.guessingGameGUI_NEW_ENG;

import java.util.List;

public class AnimalGuess extends AbstractGuessingGame {
    private static final List<String> ANIMALS = List.of("cat", "dog", "mouse", "elephant", "lion", "tiger");
    private String secretAnimal;

    public AnimalGuess() {
        resetSecret();
    }

    @Override
    public String getPrompt() {
        return "Guess the animal (" + String.join(", ", ANIMALS) + "):";
    }

    @Override
    public String guess(String input) {
        if (guessed) return "Already guessed!";
        String guess = input.trim().toLowerCase();
        if (!ANIMALS.contains(guess)) {
            return "Enter a valid animal!";
        }
        int cmp = guess.compareTo(secretAnimal);
        if (cmp == 0) {
            guessed = true;
            return "Correct! The animal was " + secretAnimal + ".";
        }
        return (cmp < 0)
                ? "The animal comes alphabetically after."
                : "The animal comes alphabetically before.";
    }

    @Override
    protected void resetSecret() {
        secretAnimal = ANIMALS.get(SharedRandom.RANDOM.nextInt(ANIMALS.size()));
    }
}
