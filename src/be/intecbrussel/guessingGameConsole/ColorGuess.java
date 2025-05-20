package be.intecbrussel.guessingGameConsole;

import java.util.Random;

// Kleur-gokuitdaging
class ColorGuess implements Guessable {
    private static final String[] COLORS = {"rood", "blauw", "groen", "geel", "oranje", "paars"};
    private final String secret;
    private boolean guessed;

    public ColorGuess() {
        this.secret = COLORS[new Random().nextInt(COLORS.length)];
        this.guessed = false;
    }

    @Override
    public boolean isGuessed() {
        return guessed;
    }

    @Override
    public void prompt() {
        System.out.print("Raad de kleur: ");
    }

    @Override
    public void guess(String input) {
        if (input.equals(secret)) {
            System.out.println("Correct! De kleur is " + secret + ".");
            guessed = true;
        } else if (input.compareTo(secret) < 0) {
            System.out.println("Hint: de geheime kleur komt later in het alfabet.");
        } else {
            System.out.println("Hint: de geheime kleur komt eerder in het alfabet.");
        }
    }
}
