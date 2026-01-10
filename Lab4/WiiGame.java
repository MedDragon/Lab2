public class WiiGame extends VideoGame {
    private static final int NUM_DAYS_BASE_PRICE = 4;
    private static final double BASE_PRICE = 3.0;

    public WiiGame(String name) {
        super(name); // Виклик суперкласу
    }

    @Override
    public double getCharge(int daysRented, boolean consoleRented) {
        double result = BASE_PRICE;
        if (daysRented > NUM_DAYS_BASE_PRICE) {
            result += (daysRented - NUM_DAYS_BASE_PRICE) * 1.50;
        }
        if (consoleRented) {
            result += daysRented * 1.99;
        }
        return result;
    }

    @Override
    public int getFrequentRenterPoints(int daysRented, boolean consoleRented) {
        return 1;
    }
}