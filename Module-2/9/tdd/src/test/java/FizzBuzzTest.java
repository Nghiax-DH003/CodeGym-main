import org.example.FizzBuzz;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FizzBuzzTest {
    @Test
    public void FizzTest() {
        String expected = "Fizz";
        String actual = FizzBuzz.translate(3);
        assertEquals(expected, actual);
    }

    @Test
    public void FizzTestBy5() {
        String expected = "Buzz";
        String actual = FizzBuzz.translate(5);
        assertEquals(expected, actual);
    }
}
