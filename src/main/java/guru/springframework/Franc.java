package guru.springframework;

public class Franc extends Money {


    public Franc(int v,String ccy){
        super(v,ccy);
    }
    public Money times(int v){

        return Money.franc(value*v);
    }


}
