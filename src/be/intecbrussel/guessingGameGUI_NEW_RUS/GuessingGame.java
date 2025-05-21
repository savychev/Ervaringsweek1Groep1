package be.intecbrussel.guessingGameGUI_NEW_RUS;

public class GuessingGame {
    private Guessable currentGame;
    private GameType currentGameType;

    public enum GameType {
        NUMBER, COLOR, ANIMAL
    }

    public GuessingGame() {
        setGame(GameType.NUMBER);
    }

    public void setGame(GameType type) {
        currentGameType = type;
        switch (type) {
            case NUMBER -> currentGame = new NumberGuess();
            case COLOR -> currentGame = new ColorGuess();
            case ANIMAL -> currentGame = new AnimalGuess();
        }
    }

    public Guessable getCurrentGame() {
        return currentGame;
    }

    public GameType getCurrentGameType() {
        return currentGameType;
    }
}
