package be.intecbrussel.guessingGameGUI_original;

public interface Guessable {  // Definieert een interface voor een raadspelcomponent
    String getPrompt();  // Geeft de opdracht of vraag weer die aan de speler wordt getoond

    String guess(String input);  // Verwerkt de gok van de gebruiker en retourneert feedback

    boolean isGuessed();  // Geeft aan of het juiste antwoord al geraden is
}

