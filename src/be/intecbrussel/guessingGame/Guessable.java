package be.intecbrussel.guessingGame;

// Interface voor alle gokuitdagingen
public interface Guessable {
    /**
     * Controleert of de uitdaging al is behaald.
     * @return true als de gebruiker correct heeft geraden, anders false.
     */
    boolean isGuessed();

    /**
     * Toont een prompt voor de gebruiker om een gok te doen.
     */
    void prompt();

    /**
     * Verwerkt de gokinvoer van de gebruiker en geeft feedback.
     * @param input de gok van de gebruiker als String
     */
    void guess(String input);
}
