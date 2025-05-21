package be.intecbrussel.guessingGameGUI;

import java.util.List;

public class ColorGuess extends AbstractGuessingGame {

    private static final List<String> COLORS = List.of(
            "red", "blue", "green", "yellow", "orange", "purple"
    );

    private String secret;  // De geheime kleur die geraden moet worden
    private boolean guessed;      // Houdt bij of de speler de juiste kleur al heeft geraden

    public ColorGuess() { // Constructor — kiest willekeurig een kleur uit de lijst
        reset();
    }

    @Override
    public String getPrompt() {
        return "Guess the color:";
    }

    @Override
    public String guess(String input) { // Verwerkt de gok van de speler
        input = input.toLowerCase();

        if (guessed) {
            return "Already guessed!";
        }

        int cmp = input.compareTo(secret); // Vergelijkt alfabetisch de invoer met het geheim
        if (cmp == 0) { // Als het exact overeenkomt
            guessed = true;
            return "Correct! The color was " + secret + ".";
        }
        return (cmp < 0) // Geef hint of het woord eerder of later komt in het alfabet
                ? "The color comes alphabetically after " + input + "."
                : "The color comes alphabetically before " + input + ".";
    }

    @Override
    public void reset() {
        super.reset();
        secret = COLORS.get(SharedRandom.RANDOM.nextInt(COLORS.size()));
    }
}
