/**
 * The Toy class represents a toy in the toy store.
 */
class Toy {
    private int id; // Toy ID
    private String name; // Toy name
    private int quantity; // Available quantity of the toy
    private double frequency; // Frequency in % out of 100 for toy giveaway

    /**
     * Constructor for the Toy class.
     * @param id The ID of the toy
     * @param name The name of the toy
     * @param quantity The available quantity of the toy
     * @param frequency The frequency in % out of 100 for toy giveaway
     */
    public Toy(int id, String name, int quantity, double frequency) {
        this.id = id;
        this.name = name;
        this.quantity = quantity;
        this.frequency = frequency;
    }

    /**
     * Method to get the ID of the toy.
     * @return The ID of the toy
     */
    public int getId() {
        return id;
    }

    /**
     * Method to get the name of the toy.
     * @return The name of the toy
     */
    public String getName() {
        return name;
    }

    /**
     * Method to get the available quantity of the toy.
     * @return The available quantity of the toy
     */
    public int getQuantity() {
        return quantity;
    }

    /**
     * Method to get the frequency in % out of 100 for toy giveaway.
     * @return The frequency in % out of 100 for toy giveaway
     */
    public double getFrequency() {
        return frequency;
    }

    /**
     * Method to set the frequency in % out of 100 for toy giveaway.
     * @param frequency The frequency in % out of 100 for toy giveaway
     */
    public void setFrequency(double frequency) {
        this.frequency = frequency;
    }

    /**
     * Method to decrease the quantity of the toy.
     */
    public void decreaseQuantity() {
        quantity--;
    }

    /**
     * Method to check if the toy is empty (quantity is 0).
     * @return True if the toy is empty, false otherwise
     */
    public boolean isEmpty() {
        return quantity == 0;
    }
}

