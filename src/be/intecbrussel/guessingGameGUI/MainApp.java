package be.intecbrussel.guessingGameGUI;
import javax.swing.*;

public class MainApp {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(GuessingGameGUI::new); // Start de GUI
    }
}
