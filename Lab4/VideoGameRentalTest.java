import org.junit.*;
import junit.framework.TestCase;

public class VideoGameRentalTest extends TestCase {
    Ps3Game littleBigPlanet;

    @Before
    public void setUp() {
        littleBigPlanet = new Ps3Game("Little Big Planet");
    }

    @Test
    public void testStatementPs3GameOnly() {
        Customer johnDoe = new Customer("John Doe");
        // 1 день оренди, без консолі
        johnDoe.addVideoGameRental(new VideoGameRental(littleBigPlanet, 1, false));
        String result = johnDoe.statement();

        // Виводимо результат в консоль для самоперевірки (опціонально)
        System.out.println(result);

        assertTrue("Назва гри відсутня", result.contains("Little Big Planet"));
        assertTrue("Сума має бути 4.0", result.contains("4.0"));
        assertTrue("Має бути 2 бали", result.contains("2 frequent renter points"));
    }
}