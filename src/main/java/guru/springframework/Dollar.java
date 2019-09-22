package guru.springframework;

public class Dollar extends Money{

    public Dollar(int v,String ccy){
        super(v,ccy);

    }
    public Money times(int v){

        return Money.dollar(value*v);
    }

}
