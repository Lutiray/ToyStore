import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * The ToyStore class represents a toy store with functionality to manage toys.
 */
public class ToyStore {
    private List<Toy> toys;

    /**
     * Constructor for the ToyStore class.
     */
    public ToyStore() {
        toys = new ArrayList<>();
    }

    /**
     * Method to add a new toy to the store.
     * @param toy The toy to be added
     */
    public void addToy(Toy toy) {
        toys.add(toy);
    }

    /**
     * Method to update the frequency of a toy.
     * @param toyId The ID of the toy to be updated
     * @param frequency The new frequency for the toy
     */
    public void updateFrequency(int toyId, double frequency) {
        for (Toy toy : toys) {
            if (toy.getId() == toyId) {
                toy.setFrequency(frequency);
                return;
            }
        }
    }

    /**
     * Method to randomly select a toy based on frequency.
     * @return The selected toy
     */
    public Toy getRandomToy() {
        double totalFrequency = toys.stream().mapToDouble(Toy::getFrequency).sum();
        double randomNumber = new Random().nextDouble() * totalFrequency;

        double cumulativeFrequency = 0;
        for (Toy toy : toys) {
            cumulativeFrequency += toy.getFrequency();
            if (randomNumber <= cumulativeFrequency) {
                toy.decreaseQuantity();
                return toy;
            }
        }

        return null;
    }

    /**
     * Method to save a prize toy to a file.
     * @param toy The prize toy to be saved
     */
    public void savePrizeToy(Toy toy) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("prize_toys.txt", true))) {
            writer.write(toy.getId() + "," + toy.getName() + "\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Method to check if a specific toy is available in the store.
     * @param toyName The name of the toy to check availability for
     * @return True if the toy is available, false otherwise
     */
    public boolean isToyAvailable(String toyName) {
        for (Toy toy : toys) {
            if (toy.getName().equalsIgnoreCase(toyName) && toy.getQuantity() > 0) {
                return true;
            }
        }
        return false;
    }

    /**
     * Method to check if any toy is available for a prize.
     * @return True if any toy is available, false otherwise
     */
    public boolean isAnyToyAvailableForPrize() {
        for (Toy toy : toys) {
            if (toy.getQuantity() > 0) {
                return true;
            }
        }
        return false;
    }

    /**
     * Method to check if the toy store is empty (no toys available).
     * @return True if the toy store is empty, false otherwise
     */
    public boolean isEmpty() {
        return toys.stream().allMatch(Toy::isEmpty);
    }
}

