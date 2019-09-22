package guru.springframework;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class MoneyTest {
    @Test
    void testMultiplication() {
        Money five = Money.dollar(5);
        assertEquals(Money.dollar(5*2), five.times(2));
        assertEquals(Money.dollar(5*3), five.times(3));
        Money fivef = Money.franc(5);
        assertEquals(Money.franc(5*2),fivef.times(2));
        assertEquals(Money.franc(5*3), fivef.times(3));
    }

    @Test
    void testEqual(){
        assertEquals(Money.dollar(5), Money.dollar(5));

        assertNotEquals(Money.dollar(5), Money.dollar(15));

        assertNotEquals(Money.dollar(5), Money.franc(5));
        assertEquals(Money.franc(5), Money.franc(5));

        assertNotEquals(Money.franc(5), Money.franc(15));
    }





    @Test
    void testCurrency(){
        assertEquals("USD",Money.dollar(5).currency());
        assertEquals("CHF",Money.franc(5).currency());
    }


}
