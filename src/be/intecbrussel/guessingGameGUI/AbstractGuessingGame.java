package be.intecbrussel.guessingGameGUI;

public abstract class AbstractGuessingGame implements Guessable {
    protected boolean guessed = false; // Houdt bij of de speler de juiste kleur al heeft geraden

    @Override
    public boolean isGuessed() {
        return guessed;
    }

    public void reset() {
        guessed = false;
    }

    // Hier kun je gedeelde methodes plaatsen die voor alle spellen gelden
}