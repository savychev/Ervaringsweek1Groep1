package be.intecbrussel.guessingGameGUI_NEW_ENG;

public abstract class AbstractGuessingGame implements Guessable {
    protected boolean guessed = false;

    @Override
    public boolean isGuessed() {
        return guessed;
    }

    @Override
    public void reset() {
        guessed = false;
        resetSecret();
    }

    // Each subclass implements its own secret generation
    protected abstract void resetSecret();
}
