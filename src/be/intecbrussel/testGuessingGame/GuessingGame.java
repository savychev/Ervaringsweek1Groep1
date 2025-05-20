package be.intecbrussel.testGuessingGame;

import java.util.*;


// Hoofdspelclass
public class GuessingGame {
    private final List<Guessable> challenges = new ArrayList<>();
    private final Scanner scanner = new Scanner(System.in);

    public GuessingGame() {
        challenges.add(new ColorGuess());
        challenges.add(new NumberGuess());
        challenges.add(new AnimalGuess());
    }

    public void start() {
        System.out.println("Welkom bij de GuessingGame!");
        System.out.println("Ik heb een kleur, een getal (1-10) en een dier gekozen. Probeer ze te raden!\n");

        while (!allGuessed()) {
            for (Guessable challenge : challenges) {
                if (!challenge.isGuessed()) {
                    challenge.prompt();
                    String input = scanner.nextLine().trim().toLowerCase();
                    challenge.guess(input);
                }
            }
            System.out.println();
        }

        System.out.println("Gefeliciteerd! Je hebt alle geheimen geraden!");
        scanner.close();
    }

    private boolean allGuessed() {
        return challenges.stream().allMatch(Guessable::isGuessed);
    }
}
