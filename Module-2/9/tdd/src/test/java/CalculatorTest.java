import org.example.Calculator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculatorTest {
    Calculator calculator = new Calculator();
    @Test
    public void addOne(){
        int expected = 10;
        int actual = calculator.add(5, 5);
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Lấp 20 - 5 = 15")
    public void addTwo(){
        int expected = 5;
        int actual = calculator.sub(20, 5);
        assertEquals(expected, actual);
    }
}
