package be.intecbrussel.guessingGameGUI_original;

public abstract class AbstractGuessingGame<T> implements Guessable {
    protected T secret;
    protected boolean guessed;

    public AbstractGuessingGame() {
        reset();
    }

    @Override
    public boolean isGuessed() {
        return guessed;
    }

    @Override
    public void reset() {
        this.secret = getNewSecret();
        this.guessed = false;
    }

    protected abstract T getNewSecret();
}
