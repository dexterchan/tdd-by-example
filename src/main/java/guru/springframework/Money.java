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
    public Money reduce(String to){
        return this;
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

    public Money times(int v){

        return new Money(v*this.value,this.currency);
    }

    public Expression plus(Money addend){
        return new Sum(this,addend);
    }
}

