public abstract class Movie {
    private String _title;

    public Movie(String title) { _title = title; }

    public String getTitle() { return _title; } // Інкапсуляція поля

    public abstract double getCharge(int daysRented);
    public abstract int getFrequentRenterPoints(int daysRented);
}