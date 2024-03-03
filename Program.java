public class Program{
    public static void main(String[] args)
    {
        ToyStore toyStore = new ToyStore();

        toyStore.addToy(new Toy(1, "Кукла", 2, 30));
        toyStore.addToy(new Toy(2, "Мяч", 3, 50));
        toyStore.addToy(new Toy(3, "Машинка", 1, 20));
        // Обновляем вес игрушки
        toyStore.updateFrequency(1, 40);
        
        while (!toyStore.isEmpty() && toyStore.isAnyToyAvailableForPrize()) {
            Toy prizeToy = toyStore.getRandomToy();
            if (prizeToy != null) {
                if (!toyStore.isToyAvailable(prizeToy.getName())) {
                    System.out.println("Игрушка '" + prizeToy.getName() + "' больше недоступна для розыгрыша.");
                    continue;
                }

                toyStore.savePrizeToy(prizeToy);
                System.out.println("Призовая игрушка: " + prizeToy.getName() + " записана в файл.");
            } else {
                System.out.println("Нет доступных призовых игрушек.");
                break;
            }
        }
    }
}