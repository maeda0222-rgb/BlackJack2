
import java.util.Random;

public class CardStock {
    public static Card nextCard() {
        return Card.numberOf(new Random().nextInt(Card.values().length));
    }
}
