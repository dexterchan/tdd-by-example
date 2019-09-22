package guru.springframework;

public  class Money {
    protected int value;
    protected String currency;
    public Money(int v, String ccy) {
        this.value=v;
        this.currency=ccy;
    }



    public static Money dollar(int v){
        return new Dollar(v,"USD");
    }
    public static Money franc(int v){
        return new Franc((v),"CHF");
    }

    @Override
    public boolean equals(Object obj) {
        return ((Money)obj).value==this.value && (this.currency.equals( ((Money) obj).currency));
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
}

