package be.intecbrussel.guessingGameGUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

/**
 * Simple Swing GUI for the guessing game.
 */
public class GuessingGameGUI {

    private final GuessingGame game = new GuessingGame();
    private final JTextArea outputArea = new JTextArea();
    private final JTextField inputField = new JTextField();
    private final JLabel promptLabel = new JLabel();

    public GuessingGameGUI() {
        JFrame frame = new JFrame("Guessing Game"); // Maakt een nieuw venster met de titel "Guessing Game"
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Sluit de hele applicatie wanneer het venster wordt gesloten (bijvoorbeeld op [X])
        frame.setSize(420, 320); // Stelt de afmetingen van het venster in
        frame.setLayout(new BorderLayout(10, 10)); // Gebruikt BorderLayout met tussenruimte tussen componenten

        promptLabel.setFont(promptLabel.getFont().deriveFont(Font.BOLD, 16f)); // Stelt een vet lettertype in met grootte 16, gebaseerd op het huidige lettertype van promptLabel
        promptLabel.setBorder(BorderFactory.createEmptyBorder(10, 10, 0, 10)); // Voegt lege marge (padding) toe rond het label
        frame.add(promptLabel, BorderLayout.NORTH); // Voegt promptLabel toe aan de bovenkant van het venster (NORTH) in de BorderLayout

        outputArea.setEditable(false); // maakt het tekstveld alleen-lezen, zodat de gebruiker er niets in kan typen
        outputArea.setLineWrap(true); // zorgt ervoor dat lange regels automatisch worden afgebroken naar een nieuwe regel
        outputArea.setWrapStyleWord(true); // breekt regels alleen af op woordgrenzen, zodat woorden niet middenin worden afgesneden
        frame.add(new JScrollPane(outputArea), BorderLayout.CENTER); // voegt de tekstzone toe aan het midden van het venster (layout), met een scrollbalk eromheen


        JPanel bottomPanel = new JPanel(new BorderLayout(5, 5)); //  Maakt een nieuw paneel met BorderLayout en ruimte tussen componenten
        bottomPanel.setBorder(BorderFactory.createEmptyBorder(0, 10, 10, 10)); // Voegt lege marge toe
        JButton submitButton = new JButton("Submit"); // Maakt een knop met het label


        bottomPanel.add(inputField, BorderLayout.CENTER); // voegt het tekstveld (inputField) toe in het midden van de bottomPanel (bij BorderLayout.CENTER)
        bottomPanel.add(submitButton, BorderLayout.EAST); // voegt de knop (submitButton) toe aan de rechterkant van de bottomPanel (bij BorderLayout.EAST)
        frame.add(bottomPanel, BorderLayout.SOUTH); // voegt de volledige bottomPanel toe aan de onderkant van het hoofdvenster (frame), dus onderaan in BorderLayout.SOUTH


        // Update initial prompt
        promptLabel.setText(game.getCurrentPrompt());

        ActionListener sendAction = e -> {
            String text = inputField.getText().trim();
            if (text.isEmpty()) return;
            outputArea.append("> " + text + "\n");
            String feedback = game.processInput(text);
            outputArea.append(feedback + "\n\n");
            inputField.setText("");

            if (game.isFinished()) {
                promptLabel.setText("Game finished!");
                inputField.setEnabled(false);
            } else {
                promptLabel.setText(game.getCurrentPrompt());
            }
        };

        submitButton.addActionListener(sendAction);
        inputField.addActionListener(sendAction);

        frame.setLocationRelativeTo(null); // center on screen
        frame.setVisible(true);
    }
}
