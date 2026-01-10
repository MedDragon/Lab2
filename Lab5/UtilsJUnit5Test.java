package sample;

import org.junit.*;
import static org.junit.Assert.*;

public class UtilsJUnit5Test {

    @BeforeClass
    public static void setUpClass() { System.out.println("--- Starting Utils Test Class ---"); }

    @AfterClass
    public static void tearDownClass() { System.out.println("--- Finished Utils Test Class ---"); }

    @Before
    public void setUp() { System.out.println("Preparing test..."); }

    @Test
    public void helloWorldCheck() {
        System.out.println("helloWorldCheck");
        assertEquals("Hello,world!", Utils.concatWords("Hello", ",", "world", "!"));
    }

    @Test(timeout = 1000)
    public void testWithTimeout() {
        System.out.println("testWithTimeout");
        Utils.computeFactorial(10);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testExpectedException() {
        System.out.println("testExpectedException");
        Utils.computeFactorial(-5);
    }

    @Ignore
    @Test
    public void temporaryDisabledTest() {
        System.out.println("This test is ignored");
    }
}