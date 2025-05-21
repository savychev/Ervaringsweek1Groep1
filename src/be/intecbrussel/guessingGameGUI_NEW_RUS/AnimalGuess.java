package be.intecbrussel.guessingGameGUI_NEW_RUS;

import java.util.List;

public class AnimalGuess extends AbstractGuessingGame {
    private static final List<String> ANIMALS = List.of("cat", "dog", "mouse", "elephant", "lion", "tiger");
    private String secretAnimal;

    public AnimalGuess() {
        resetSecret();
    }

    @Override
    public String getPrompt() {
        return "Угадай животное (" + String.join(", ", ANIMALS) + "):";
    }

    @Override
    public String guess(String input) {
        if (guessed) return "Уже угадано!";
        String guess = input.trim().toLowerCase();
        if (!ANIMALS.contains(guess)) {
            return "Введите корректное животное!";
        }
        int cmp = guess.compareTo(secretAnimal);
        if (cmp == 0) {
            guessed = true;
            return "Верно! Животное было " + secretAnimal + ".";
        }
        return (cmp < 0)
                ? "Загаданное животное позже по алфавиту."
                : "Загаданное животное раньше по алфавиту.";
    }

    @Override
    protected void resetSecret() {
        secretAnimal = ANIMALS.get(SharedRandom.RANDOM.nextInt(ANIMALS.size()));
    }
}
