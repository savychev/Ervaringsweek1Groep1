package be.intecbrussel.guessingGameGUI_original;

public interface Guessable {
    String getPrompt();
    String guess(String input);
    boolean isGuessed();
    void reset();
}
