package be.intecbrussel.guessingGameGUI_NEW_RUS;

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

    // Каждый подкласс реализует свою генерацию "секрета"
    protected abstract void resetSecret();
}
