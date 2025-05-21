package be.intecbrussel.guessingGameGUI_NEW_RUS;

import java.util.List;

public class ColorGuess extends AbstractGuessingGame {
    private static final List<String> COLORS = List.of("red", "blue", "green", "yellow", "orange", "purple");
    private String secretColor;

    public ColorGuess() {
        resetSecret();
    }

    @Override
    public String getPrompt() {
        return "Угадай цвет (" + String.join(", ", COLORS) + "):";
    }

    @Override
    public String guess(String input) {
        if (guessed) return "Уже угадано!";
        String guess = input.trim().toLowerCase();
        if (!COLORS.contains(guess)) {
            return "Введите корректный цвет!";
        }
        int cmp = guess.compareTo(secretColor);
        if (cmp == 0) {
            guessed = true;
            return "Верно! Цвет был " + secretColor + ".";
        }
        return (cmp < 0)
                ? "Загаданный цвет позже по алфавиту."
                : "Загаданный цвет раньше по алфавиту.";
    }

    @Override
    protected void resetSecret() {
        secretColor = COLORS.get(SharedRandom.RANDOM.nextInt(COLORS.size()));
    }
}
