package guru.springframework;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class MoneyTest {
    @Test
    void testMultiplicationDollar() {
        Dollar five = new Dollar(5);
        Dollar d2 = five.times(2);
        assertEquals(new Dollar(5*2),d2);
        Dollar d3=five.times(3);
        assertEquals(new Dollar(5*3), d3);
    }

    @Test
    void testEqualDollar(){
        assertEquals(new Dollar(5), new Dollar(5));

        assertNotEquals(new Dollar(5), new Dollar(15));

        assertNotEquals(new Dollar(5), new Franc(5));
    }


    @Test
    void testMultiplicationFranc() {
        Franc five = new Franc(5);
        Franc d2 = five.times(2);
        assertEquals(new Franc(5*2),d2);
        Franc d3=five.times(3);
        assertEquals(new Franc(5*3), d3);
    }

    @Test
    void testEqualFranc(){
        assertEquals(new Franc(5), new Franc(5));

        assertNotEquals(new Franc(5), new Franc(15));
    }


}
