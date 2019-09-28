package guru.springframework;

public interface Expression {
    Money reduce(Bank bank, String to);

    Expression times(int v);

    Expression plus(Expression addend);
}
