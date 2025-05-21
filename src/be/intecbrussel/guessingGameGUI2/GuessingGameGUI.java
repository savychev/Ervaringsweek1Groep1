package be.intecbrussel.guessingGameGUI2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

/**
 * Simple Swing GUI for the guessing game.
 */
public class GuessingGameGUI {

    private final GuessingGame game = new GuessingGame(); // Het spelobject dat de spelregels en voortgang beheert
    private final JTextArea outputArea = new JTextArea(); // Tekstvak waarin feedback en meldingen worden weergegeven
    private final JTextField inputField = new JTextField(); // Invoerveld waar de gebruiker zijn gok typt
    private final JLabel promptLabel = new JLabel(); // Label dat een opdracht of vraag toont aan de speler


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
        promptLabel.setText(game.getCurrentPrompt()); // Vult het label bovenaan met de huidige opdracht uit het spel

        // Definieert wat er gebeurt wanneer de gebruiker op Enter drukt of op de knop klikt
        ActionListener sendAction = e -> {
            String text = inputField.getText().trim();  // Haalt de invoer van de gebruiker op en verwijdert witruimte aan begin/einde
            if (text.isEmpty()) return;  // Als het invoerveld leeg is, doe dan niets
            outputArea.append("> " + text + "\n");  // Toont wat de gebruiker heeft ingevoerd in het uitvoerveld (zoals in een console)

            String feedback = game.processInput(text);  // Verwerkt de invoer via het spelobject en haalt feedback op
            outputArea.append(feedback + "\n\n");  // Voegt de feedback van het spel toe aan het uitvoerveld, met extra witruimte

            inputField.setText("");  // Leegt het invoerveld voor de volgende invoer

            if (game.isFinished()) { // Controleert of het spel afgelopen is
                promptLabel.setText("Game finished!");  // Verandert het label naar een eindboodschap
                inputField.setEnabled(false);  // Deactiveert het invoerveld zodat de gebruiker niets meer kan invoeren
            } else {
                promptLabel.setText(game.getCurrentPrompt());  // Vraagt de volgende opdracht op uit het spel en toont deze
            }
        };


        submitButton.addActionListener(sendAction);  // Koppelt de actie aan de knop: wanneer je klikt, wordt sendAction uitgevoerd
        inputField.addActionListener(sendAction);    // Koppelt dezelfde actie aan Enter in het invoerveld

        frame.setLocationRelativeTo(null);           // Centreert het venster in het midden van het scherm
        frame.setVisible(true);                      // Maakt het venster zichtbaar voor de gebruiker

    }
}
