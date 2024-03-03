/**
 * The Program class contains the main method to demonstrate toy store functionality.
 */
public class Program {
    public static void main(String[] args) {
        // Create a new ToyStore object
        ToyStore toyStore = new ToyStore();

        // Add toys to the toy store
        toyStore.addToy(new Toy(1, "Doll", 2, 30));
        toyStore.addToy(new Toy(2, "Ball", 3, 50));
        toyStore.addToy(new Toy(3, "Car", 1, 20));

        // Update the frequency of a toy
        toyStore.updateFrequency(1, 40);

        // Perform the toy giveaway until the toy store is empty or no toys are available for prizes
        while (!toyStore.isEmpty() && toyStore.isAnyToyAvailableForPrize()) {
            // Get a random prize toy from the toy store
            Toy prizeToy = toyStore.getRandomToy();
            if (prizeToy != null) {
                // Check if the selected prize toy is available for the giveaway
                if (!toyStore.isToyAvailable(prizeToy.getName())) {
                    // If the prize toy is not available, skip to the next iteration of the loop
                    System.out.println("Toy '" + prizeToy.getName() + "' is no longer available for the giveaway.");
                    continue;
                }

                // Save the prize toy to a file
                toyStore.savePrizeToy(prizeToy);
                // Print a message indicating that the prize toy has been saved to the file
                System.out.println("Prize toy: " + prizeToy.getName() + " has been saved to the file.");
            } else {
                // If there are no available prize toys, print a message indicating so and exit the loop
                System.out.println("No available prize toys.");
                break;
            }
        }
    }
}
