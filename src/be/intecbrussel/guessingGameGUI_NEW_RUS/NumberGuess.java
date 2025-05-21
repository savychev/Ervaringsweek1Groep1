package be.intecbrussel.guessingGameGUI_NEW_RUS;

public class NumberGuess extends AbstractGuessingGame {
    private int secretNumber;

    public NumberGuess() {
        resetSecret();
    }

    @Override
    public String getPrompt() {
        return "Угадай число от 1 до 100:";
    }

    @Override
    public String guess(String input) {
        if (guessed) return "Уже угадано!";
        int userGuess;
        try {
            userGuess = Integer.parseInt(input.trim());
        } catch (NumberFormatException e) {
            return "Введите корректное число!";
        }
        if (userGuess == secretNumber) {
            guessed = true;
            return "Верно! Число было " + secretNumber;
        } else if (userGuess < secretNumber) {
            return "Моё число больше!";
        } else {
            return "Моё число меньше!";
        }
    }

    @Override
    protected void resetSecret() {
        secretNumber = SharedRandom.RANDOM.nextInt(100) + 1;
    }
}
