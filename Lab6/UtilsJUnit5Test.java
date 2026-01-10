package sample;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
import java.time.Duration;

class UtilsJUnit5Test {

    @BeforeAll
    static void setUpClass() {
        System.out.println("* UtilsJUnit5Test: @BeforeAll method");
    }

    @AfterAll
    static void tearDownClass() {
        System.out.println("* UtilsJUnit5Test: @AfterAll method");
    }

    @BeforeEach
    void setUp() {
        System.out.println("* UtilsJUnit5Test: @BeforeEach method");
    }

    @AfterEach
    void tearDown() {
        System.out.println("* UtilsJUnit5Test: @AfterEach method");
    }

    @Test
    void helloWorldCheck() {
        System.out.println("* UtilsJUnit5Test: test method 1 - helloWorldCheck()");
        assertEquals("Hello, world!",
                Utils.concatWords("Hello", ", ", "world", "!"),
                "* Test method 1 failed");
    }

    @Test
    void testWithTimeout() {
        System.out.println("* UtilsJUnit5Test: test method 2 - testWithTimeout()");
        assertTimeout(Duration.ofSeconds(1), () -> {
            final int factorialOf = 1 + (int) (30000 * Math.random());
            System.out.println("computing " + factorialOf + '!');
            Utils.computeFactorial(factorialOf);
        }, "* Test method 2 is failed");
    }

    @Test
    void checkExpectedException() {
        System.out.println("* UtilsJUnit5Test: test method 3 – checkExpectedException()");
        assertThrows(IllegalArgumentException.class, () -> {
            final int factorialOf = -5;
            System.out.println(factorialOf + "! = " + Utils.computeFactorial(factorialOf));
        }, "* Test method 3 is failed");
    }

    @Disabled("Do not run")
    @Test
    void temporarilyDisabledTest() throws Exception {
        System.out.println("* UtilsJUnit5Test: test method 4 – temporarilyDisabledTest()");
        assertEquals("Malmö", Utils.normalizeWord("Malmo\u0308"));
    }
}