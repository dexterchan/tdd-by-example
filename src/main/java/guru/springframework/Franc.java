package guru.springframework;

public class Franc extends Money {
    public Franc(int v){

        this.value=v;
    }
    public Franc times(int v){

        return new Franc(value*v);
    }

}
