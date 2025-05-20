package be.intecbrussel.guessingGameConsole;

import java.util.Random;

// Dier-gokuitdaging
class AnimalGuess implements Guessable {
    private static final String[] ANIMALS = {"hond", "kat", "olifant", "leeuw", "tijger"}; // Mogelijke dieren om uit te kiezen
    private final String secret; // Het geheime dier
    private boolean guessed; // Geeft aan of het dier al geraden is

    /**
     * Constructor: kiest willekeurig een dier en zet de status op niet geraden.
     */
    public AnimalGuess() {
        this.secret = ANIMALS[new Random().nextInt(ANIMALS.length)];
        this.guessed = false;
    }

    @Override
    public boolean isGuessed() {
        return guessed;
    }

    @Override
    public void prompt() {
        System.out.print("Raad het dier: ");
    }

    @Override
    public void guess(String input) {
        if (input.equals(secret)) {
            System.out.println("Dat klopt! Het dier is een " + secret + ".");
            guessed = true;
        } else {
            System.out.println("Helaas, dat is niet het juiste dier.");
        }
    }
}
