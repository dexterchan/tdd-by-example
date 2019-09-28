package guru.springframework;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class MoneyTest {
    @Test
    void testMultiplication() {
        Money five = Money.dollar(5);
        assertEquals(Money.dollar(5 * 2), five.times(2));
        assertEquals(Money.dollar(5 * 3), five.times(3));
        Money fivef = Money.franc(5);
        assertEquals(Money.franc(5 * 2), fivef.times(2));
        assertEquals(Money.franc(5 * 3), fivef.times(3));
    }

    @Test
    void testEqual() {
        assertEquals(Money.dollar(5), Money.dollar(5));
        assertNotEquals(Money.dollar(5), Money.dollar(15));

        assertNotEquals(Money.dollar(5), Money.franc(5));
        assertEquals(Money.franc(5), Money.franc(5));

        assertNotEquals(Money.franc(5), Money.franc(15));
    }


    @Test
    void testCurrency() {
        assertEquals("USD", Money.dollar(5).currency());
        assertEquals("CHF", Money.franc(5).currency());
    }

    @Test
    void testAddition(){
        Money five = Money.dollar(5);
        Expression sum = five.plus(five);
        Bank bank = new Bank();
        Expression reduced = bank.reduce(sum,"USD");
        assertEquals(Money.dollar(10),reduced);

        bank.addRate("CHF","USD",2);
        sum = five.plus( Money.franc(2));
        reduced = sum.reduce(bank, "USD");
        assertEquals (Money.dollar(5+1),reduced);

    }
    @Test
    public void testSumPlusMoney(){
        Expression fiveBucks = Money.dollar(5);
        Expression tenFrancs = Money.franc(10);
        Bank bank = new Bank();
        bank.addRate("CHF","USD",2);
        Expression sum = new Sum(fiveBucks, tenFrancs).plus(fiveBucks);
        Money result = bank.reduce(sum, "USD");
        assertEquals(Money.dollar(15),result);
    }

    @Test
    void testPlusReturnSum(){
        Money five = Money.dollar(5);
        Expression result = five.plus(five);
        Sum sum = (Sum) result;
        assertEquals(five, sum.arguend);
        assertEquals(five, sum.addmend);
    }

    @Test
    void testReduceSum(){
        Expression sum = new Sum(Money.dollar(3),Money.dollar(4));
        Bank bank = new Bank();
        bank.addRate("CHF","USD",2);
        Expression result = bank.reduce(sum, "USD");
        assertEquals(Money.dollar(7),result);

        sum = new Sum(Money.dollar(3), Money.franc(4));
        result = bank.reduce(sum,"USD");
        assertEquals(Money.dollar(3+2),result);
    }
    @Test
    void testReduceMoney(){
        Bank bank = new Bank();

    }

    @Test
    void testReduceMoneyDifferentCurrency(){
        Bank bank = new Bank();
        bank.addRate("CHF","USD",2);
        Money result = bank.reduce(Money.franc(2),"USD");
        assertEquals(Money.dollar(1), result);
    }

    @Test
    void testIdentityRate(){
        assertEquals(1, new Bank().rate("USD", "USD"));
        assertEquals(1, new Bank().rate("CHF", "CHF"));
    }

    @Test
    public void testSumTimes(){
        Expression fiveBucks = Money.dollar(5);
        Expression tenFrancs = Money.franc(10);

        Bank bank = new Bank();
        bank.addRate("CHF","USD",2);
        Expression sum = new Sum(fiveBucks,tenFrancs).times(2);
        Money result = bank.reduce(sum, "USD");
        assertEquals(Money.dollar(20),result);

    }
}
