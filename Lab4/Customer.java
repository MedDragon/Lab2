import java.util.*;

class Customer {
    public String _name;
    private Vector<MovieRental> _movieRentals = new Vector<>();
    private Vector<VideoGameRental> _videoGameRental = new Vector<>();

    public Customer(String name) { _name = name; }
    public void addMovieRental(MovieRental arg) { _movieRentals.addElement(arg); }
    public void addVideoGameRental(VideoGameRental arg) { _videoGameRental.addElement(arg); }

    public String statement() {
        double totalAmount = 0;
        int frequentRenterPoints = 0;
        String result = "Rental Record for " + _name + "\n"; // Тут має бути перенос

        for (MovieRental each : _movieRentals) {
            frequentRenterPoints += each.getFrequentRenterPoints();
            // Формат: табуляція + Назва + табуляція + Ціна + перенос
            result += "\t" + each.getMovie().getTitle() + "\t" + each.getCharge() + "\n";
            totalAmount += each.getCharge();
        }

        for (VideoGameRental each : _videoGameRental) {
            frequentRenterPoints += each.getFrequentRenterPoints();
            // Формат: табуляція + Назва + табуляція + Ціна + перенос
            result += "\t" + each.getVideoGame().get_gameName() + "\t" + each.getCharge() + "\n";
            totalAmount += each.getCharge();
        }

        result += "Amount owed is " + totalAmount + "\n";
        result += "You earned " + frequentRenterPoints + " frequent renter points";
        return result;
    }
}