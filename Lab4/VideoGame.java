public abstract class VideoGame {
    private String _gameName;
    public VideoGame(String name) { _gameName = name; }
    public String get_gameName() { return _gameName; }
    public abstract double getCharge(int daysRented, boolean consoleRented);
    public abstract int getFrequentRenterPoints(int daysRented, boolean consoleRented);
    public String toString() { return _gameName; }
}