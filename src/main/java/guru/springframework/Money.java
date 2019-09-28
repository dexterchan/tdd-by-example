package guru.springframework;

public  class Money implements Expression {
    protected int value;
    protected String currency;
    public Money(int v, String ccy) {
        this.value=v;
        this.currency=ccy;
    }



    public static Money dollar(int v){
        return new Money(v,"USD");
    }
    public static Money franc(int v){
        return new Money((v),"CHF");
    }

    @Override
    public boolean equals(Object obj) {
        return ((Money)obj).value==this.value && (this.currency.equals( ((Money) obj).currency));
    }


    @Override
    public Money reduce(Bank bank, String to){

        return new Money( this.value/bank.rate(this.currency,to),to);
    }
    public String currency() {
        return this.currency;
    }

    @Override
    public String toString() {
        return "Money{" +
                "value=" + value +
                ", currency='" + currency + '\'' +
                '}';
    }

    @Override
    public Expression times(int v){

        return new Money(v*this.value,this.currency);
    }

    public Expression plus(Expression addend){
        return new Sum(this,addend);
    }
}

