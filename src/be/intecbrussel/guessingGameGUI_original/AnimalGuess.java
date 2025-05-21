package be.intecbrussel.guessingGameGUI_original;

import java.util.List;

public class AnimalGuess extends AbstractGuessingGame {

    private static final List<String> ANIMALS = List.of(
            "dog", "cat", "elephant", "lion", "tiger"
    );

    private String secret;

    public AnimalGuess() {
        reset();
    }

    @Override
    public String getPrompt() {
        return "Guess the animal:";
    }

    @Override
    public String guess(String input) {
        input = input.toLowerCase();
        if (guessed) {
            return "Already guessed!";
        }
        if (input.equals(secret)) {
            guessed = true;
            return "Correct! The animal was " + secret + ".";
        }
        return "Incorrect, try again.";
    }


    @Override
    public void reset() {
        super.reset();
        secret = ANIMALS.get(SharedRandom.RANDOM.nextInt(ANIMALS.size()));
    }
}
