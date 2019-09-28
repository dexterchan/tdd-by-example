package guru.springframework;

public class Sum implements Expression{
    Money arguend;
    Money addmend;

    public Sum(Money arguend, Money addmend) {
        this.arguend = arguend;
        this.addmend = addmend;
    }

    public Money reduce(Bank bank,String toCcy){
        int amount = arguend.reduce(bank,toCcy).value + addmend.reduce(bank,toCcy).value;
        return new Money(amount,toCcy);
    }

}
