package guru.springframework;

public class Sum implements Expression{
    Money arguend;
    Money addmend;

    public Sum(Money arguend, Money addmend) {
        this.arguend = arguend;
        this.addmend = addmend;
    }

    public Money reduce(String toCcy){
        int amount = arguend.value+addmend.value;
        return new Money(amount,toCcy);
    }

}
