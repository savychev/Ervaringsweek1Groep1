package be.intecbrussel.guessingGameGUI;

public interface Guessable {
    String getPrompt();
    String guess(String input);
    boolean isGuessed();
    void reset();
}
