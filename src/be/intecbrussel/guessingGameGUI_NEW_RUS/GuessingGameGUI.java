package be.intecbrussel.guessingGameGUI_NEW_RUS;

import javax.swing.*;
import java.awt.*;

public class GuessingGameGUI {

    private final GuessingGame game = new GuessingGame();
    private final JTextArea outputArea = new JTextArea();
    private final JTextField inputField = new JTextField();
    private final JLabel promptLabel = new JLabel();

    public GuessingGameGUI() {
        JFrame frame = new JFrame("Guessing Game");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(420, 350);
        frame.setLayout(new BorderLayout());

        // Верхняя панель выбора типа игры
        JPanel topPanel = new JPanel();
        JButton numberButton = new JButton("Число");
        JButton colorButton = new JButton("Цвет");
        JButton animalButton = new JButton("Животное");
        topPanel.add(numberButton);
        topPanel.add(colorButton);
        topPanel.add(animalButton);

        frame.add(topPanel, BorderLayout.NORTH);

        // Центр: вывод сообщений
        outputArea.setEditable(false);
        outputArea.setLineWrap(true);
        outputArea.setWrapStyleWord(true);
        frame.add(new JScrollPane(outputArea), BorderLayout.CENTER);

        // Нижняя панель: ввод и кнопки
        JPanel bottomPanel = new JPanel(new BorderLayout(5, 5));
        bottomPanel.setBorder(BorderFactory.createEmptyBorder(0, 10, 10, 10));
        JButton submitButton = new JButton("Ответить");
        JButton resetButton = new JButton("Сброс");

        bottomPanel.add(promptLabel, BorderLayout.NORTH);
        bottomPanel.add(inputField, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(submitButton);
        buttonPanel.add(resetButton);

        bottomPanel.add(buttonPanel, BorderLayout.EAST);

        frame.add(bottomPanel, BorderLayout.SOUTH);

        // Инициализация UI
        updatePrompt();

        // Слушатели
        submitButton.addActionListener(e -> processInput());
        inputField.addActionListener(e -> processInput());

        resetButton.addActionListener(e -> {
            game.getCurrentGame().reset();
            outputArea.setText("");
            updatePrompt();
        });

        numberButton.addActionListener(e -> {
            game.setGame(GuessingGame.GameType.NUMBER);
            outputArea.setText("");
            updatePrompt();
        });

        colorButton.addActionListener(e -> {
            game.setGame(GuessingGame.GameType.COLOR);
            outputArea.setText("");
            updatePrompt();
        });

        animalButton.addActionListener(e -> {
            game.setGame(GuessingGame.GameType.ANIMAL);
            outputArea.setText("");
            updatePrompt();
        });

        frame.setVisible(true);
    }

    private void processInput() {
        String input = inputField.getText().trim();
        if (input.isEmpty()) return;
        String feedback = game.getCurrentGame().guess(input);
        outputArea.append("> " + input + "\n" + feedback + "\n\n");
        inputField.setText("");
        updatePrompt();
    }

    private void updatePrompt() {
        promptLabel.setText(game.getCurrentGame().getPrompt());
    }
}
