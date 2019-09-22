package guru.springframework;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class MoneyTest {
    @Test
    void testMultiplication() {
        Dollar five = new Dollar(5);
        Dollar d2 = five.times(2);
        assertEquals(5*2,d2.value);
        Dollar d3=five.times(3);
        assertEquals(5*3, d3.value);
    }

    @Test
    void testEqual(){
        assertEquals(new Dollar(5), new Dollar(5));

        assertNotEquals(new Dollar(5), new Dollar(15));
    }



}
