package school.hello;

import hello.Counter;
import hello.Greeter;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;
public class GreeterTest {

    @Mock
    private Counter count = new Counter();
    @InjectMocks
    private Greeter greeter = new Greeter();
    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }
    @Test
    public void greets_only_unique_letter_name() {
        when(count.checkLength("Erki")).thenReturn(1);
        String result = greeter.sayHello("Erki");
        assertEquals("Erki, su nimi on lühike!", result);
    }

    @Test
    public void greets_normal_name() {
        when(count.checkLength("Erki")).thenReturn(4);
        String result = greeter.sayHello("Erki");
        assertEquals("Tere, Erki ! Su nimi on 4 tähte pikk", result);
    }

    @Test
    public void greets_almost_too_long_name() {
        when(count.checkLength("x")).thenReturn(14);
        String result = greeter.sayHello("x");
        assertEquals("Tere, x ! Su nimi on 14 tähte pikk", result);
    } }


