package be.intecbrussel.testGuessingGame;

import java.util.Random;

// Getal-gokuitdaging
class NumberGuess implements Guessable {
    private final int secret;
    private boolean guessed;

    public NumberGuess() {
        this.secret = new Random().nextInt(10) + 1;
        this.guessed = false;
    }

    @Override
    public boolean isGuessed() {
        return guessed;
    }

    @Override
    public void prompt() {
        System.out.print("Raad het getal (1-10): ");
    }

    @Override
    public void guess(String input) {
        try {
            int guess = Integer.parseInt(input);
            if (guess == secret) {
                System.out.println("Goed geraden! Het getal is " + secret + ".");
                guessed = true;
            } else if (guess < secret) {
                System.out.println("Te laag.");
            } else {
                System.out.println("Te hoog.");
            }
        } catch (NumberFormatException e) {
            System.out.println("Voer alsjeblieft een geldig getal in.");
        }
    }
}

