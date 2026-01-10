package sample;

import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;

@Suite
@SelectClasses({
        VectorsJUnit5Test.class,
        UtilsJUnit5Test.class
})
public class AllTestsSuite {
}

