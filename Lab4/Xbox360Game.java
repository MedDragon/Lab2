public class Xbox360Game extends VideoGame {
    private static final int NUM_DAYS_BASE_PRICE = 3;
    private static final double BASE_PRICE = 3.5;
    private static final double EXTRA_PRICE = 1.25; // Значення можна уточнити за логікою

    public Xbox360Game(String name) {
        super(name); // Передаємо назву в батьківський клас VideoGame
    }

    @Override
    public double getCharge(int daysRented, boolean consoleRented) {
        double result = BASE_PRICE;
        if (daysRented > NUM_DAYS_BASE_PRICE) {
            result += (daysRented - NUM_DAYS_BASE_PRICE) * EXTRA_PRICE;
        }
        if (consoleRented) {
            result += daysRented * 2.99; // Додаємо вартість оренди консолі
        }
        return result;
    }

    @Override
    public int getFrequentRenterPoints(int daysRented, boolean consoleRented) {
        return (daysRented > 1) ? 2 : 1; // Логіка балів
    }
}