class Toy {
    /*id игрушки,
    текстовое название,
    количество
    частота выпадения игрушки (вес в % от 100)*/
    private int id;
    private String name;
    private int quantity;
    private double frequency;

    public Toy(int id, String name, int quantity, double frequency)
    {
        this.id = id;
        this.name = name;
        this.quantity = quantity;
        this.frequency = frequency;
    }

    public int getId()
    {
        return id;
    }

    public String getName()
    {
        return name;
    }

    public int getQuantity()
    {
        return quantity;
    }

    public double getFrequency()
    {
        return frequency;
    }

    public void setFrequency(double frequency)
    {
        this.frequency = frequency;
    }

    public void decreaseQuantity()
    {
        quantity--;
    }

    public boolean isEmpty() {
        return quantity == 0;
    }
}
