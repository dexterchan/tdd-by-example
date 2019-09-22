package guru.springframework;

public abstract class Money {
    protected int value;
    protected String currency;
    public Money(int v, String ccy) {
        this.value=v;
        this.currency=ccy;
    }

    public abstract Money times(int v);

    public static Money dollar(int v){
        return new Dollar(v,"USD");
    }
    public static Money franc(int v){
        return new Franc((v),"CHF");
    }

    @Override
    public boolean equals(Object obj) {
        return ((Money)obj).value==this.value && (this.getClass().equals(obj.getClass()));
    }


    public String currency() {
        return this.currency;
    }
}
