package sample;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
    VectorsJUnit5Test.class,
    UtilsJUnit5Test.class
})
public class JUnit5TestSuite {
}