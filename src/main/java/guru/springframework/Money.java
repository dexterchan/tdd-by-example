package guru.springframework;

public class Money {
    protected int value;

    @Override
    public boolean equals(Object obj) {
        return ((Money)obj).value==this.value && (this.getClass().equals(obj.getClass()));
    }
}
