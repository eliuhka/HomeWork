package school.hello;

import hello.Counter;
import org.junit.Test;
import static org.junit.Assert.*;

public class CounterTest {

    @Test
    public void checkLength() {
        Counter count = new Counter();
        String firstName = "Erki";
        int expectedResult = 4;

        assertEquals(expectedResult, count.checkLength(firstName));
    }
}
