import org.junit.*;
import junit.framework.TestCase;

public class MovieRentalTest extends TestCase {
    Movie theManWhoKnewTooMuch, mulan, slumdogMillionaire;

    @Before
    public void setUp() {
        theManWhoKnewTooMuch = new RegularMovie("The Man Who Knew Too Much");
        mulan = new ChildrensMovie("Mulan");
        slumdogMillionaire = new NewReleaseMovie("Slumdog Millionaire");
    }

    @Test
    public void testStatementRegularMovieOnly() {
        Customer johnDoe = new Customer("John Doe");
        johnDoe.addMovieRental(new MovieRental(theManWhoKnewTooMuch, 3));
        assertEquals(3.5, new MovieRental(theManWhoKnewTooMuch, 3).getCharge());
    }
}