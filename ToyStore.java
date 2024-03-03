import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ToyStore {
    private List<Toy> toys;

    public ToyStore()
    {
        toys = new ArrayList<>();
    }

    public void addToy(Toy toy)
    {
        toys.add(toy);
    }

    public void updateFrequency(int toyId, double frequency)
    {
        for(Toy toy : toys)
        {
            if(toy.getId() == toyId)
            {
                toy.setFrequency(frequency);
                return;
            }
        }
    }

    public Toy getRandomToy()
    {
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

    public void savePrizeToy(Toy toy) 
    {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("prize_toys.txt", true))) {
            writer.write(toy.getId() + "," + toy.getName() + "\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public boolean isToyAvailable(String toyName) {
        for (Toy toy : toys) {
            if (toy.getName().equalsIgnoreCase(toyName) && toy.getQuantity() > 0) {
                return true;
            }
        }
        return false;
    }

    public boolean isAnyToyAvailableForPrize() {
        for (Toy toy : toys) {
            if (toy.getQuantity() > 0) {
                return true;
            }
        }
        return false;
    }
    

    public boolean isEmpty() 
    {
        return toys.stream().allMatch(Toy::isEmpty);
    }
}
