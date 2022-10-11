import java.util.ArrayList;
import java.util.List;

public abstract class Gamer {
    final String name;
    final List<Card> handCards = new ArrayList<>();
    
    abstract void action();
    
    public Gamer(String name) {
        this.name = name;
    }
    
    void init() {
        handCards.add(CardStock.nextCard());
        handCards.add(CardStock.nextCard());
        System.out.println(name + "の初手は" +getSumNumber() + ":" + getCardViews());
    }
   
    final Integer getSumNumber() {
        return handCards
                .stream()
                .mapToInt(card -> card.number)
                .sum();
    }
    
    final String getCardViews() {
        return handCards
                .stream()
                .map(card -> card.view)
                .reduce("",(l,r) -> l + "," + r);
    }
    boolean isBust() {
        return getSumNumber() > 21;
    }
  
}
