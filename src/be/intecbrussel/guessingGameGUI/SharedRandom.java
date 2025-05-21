package be.intecbrussel.guessingGameGUI;

import java.util.Random;

/**
 * Provides a single shared Random instance for the whole project.
 */
public final class SharedRandom { // Een hulpfunctieklasse die niet geërfd kan worden
    public static final Random RANDOM = new Random(); // Een gedeeld Random-object dat door het hele project gebruikt kan worden
    private SharedRandom() {} // Privé constructor voorkomt dat iemand een instantie van deze klasse maakt
}
