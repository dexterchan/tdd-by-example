package guru.springframework;

import java.util.HashMap;
import java.util.Optional;

public class Bank {

    private HashMap<Pair, Integer> rateMap = new HashMap<>();

    public Money reduce ( Expression source, String toCurrency){

        return source.reduce(this,toCurrency);
    }
    public int rate (String from, String to){
        if(from.equals(to))
            return 1;
        else
            return Optional.of(this.rateMap.get(new Pair(from,to))).get();
    }


    public void addRate(String from, String to, int rate) {
        rateMap.put(new Pair(from, to),rate);
    }
}
