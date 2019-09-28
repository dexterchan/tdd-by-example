package guru.springframework;

public class Sum implements Expression{
    Expression arguend;
    Expression addmend;

    public Sum(Expression arguend, Expression addmend) {
        this.arguend = arguend;
        this.addmend = addmend;
    }

    @Override
    public Money reduce(Bank bank,String toCcy){
        int amount = arguend.reduce(bank,toCcy).value + addmend.reduce(bank,toCcy).value;
        return new Money(amount,toCcy);
    }

    @Override
    public Expression plus (Expression addend){
        return new Sum(this,addend);
    }

    @Override
    public Expression times(int multiplier) {
        return new Sum(this.arguend.times(multiplier), this.addmend.times(multiplier));
    }
}
