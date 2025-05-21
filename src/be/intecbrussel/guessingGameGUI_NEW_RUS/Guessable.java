package be.intecbrussel.guessingGameGUI_NEW_RUS;

public interface Guessable {
    String getPrompt();
    String guess(String input);
    boolean isGuessed();
    void reset();
}
