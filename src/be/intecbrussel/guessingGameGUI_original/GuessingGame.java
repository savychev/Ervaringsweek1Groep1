package be.intecbrussel.guessingGameGUI_original;

import java.util.List;

// Definieert de spelklasse die de uitdagingen beheert
public class GuessingGame {

    // Lijst met (drie) uitdagingen
    private final List<Guessable> challenges = List.of(
            new ColorGuess(),
            new NumberGuess(),
            new AnimalGuess()
    );
    private int currentIndex = 0; // Houdt bij bij welke uitdaging de speler momenteel zit

    // Geeft de opdracht van de huidige uitdaging terug
    public String getCurrentPrompt() {
        return challenges.get(currentIndex).getPrompt();
    }

    // Verwerkt de invoer van de speler en retourneert feedback
    public String processInput(String input) {
        input = input.trim().toLowerCase();  // Normaliseert de invoer (geen hoofdletters of spaties)
        Guessable current = challenges.get(currentIndex);  // Haalt de huidige uitdaging op
        String feedback = current.guess(input);  // Roept de guess()-methode aan en bewaart het resultaat

        if (current.isGuessed()) {  // Controleert of de uitdaging correct is geraden
            currentIndex++;  // Gaat naar de volgende uitdaging

            if (isFinished()) {  // Als dit de laatste was...
                feedback += "\nCongratulations! You solved all challenges!";  // Voeg felicitatie toe
            }
        }

        return feedback;  // Retourneer de feedback aan de gebruiker
    }

    // Controleert of alle uitdagingen zijn voltooid
    public boolean isFinished() {
        return currentIndex >= challenges.size(); // Geeft true terug als alle mini-games zijn afgerond
    }
}
