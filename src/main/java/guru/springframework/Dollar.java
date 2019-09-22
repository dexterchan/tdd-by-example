package guru.springframework;

public class Dollar {
    int value;

    public Dollar(int v){
        this.value=v;
    }
    public Dollar times(int v){

        return new Dollar(value*v);
    }

    @Override
    public boolean equals(Object obj) {
        return ((Dollar)obj).value==this.value;
    }
}
