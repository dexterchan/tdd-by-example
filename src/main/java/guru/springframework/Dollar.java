package guru.springframework;

public class Dollar extends Money{
    public Dollar(int v){

        this.value=v;
    }
    public Dollar times(int v){

        return new Dollar(value*v);
    }


}
