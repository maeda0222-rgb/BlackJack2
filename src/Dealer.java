

public class Dealer extends Gamer{

    public Dealer(String name) {
        super(name);
    }

    //手札17以上になるまで
    @Override
    void action() {
        while(getSumNumber() < 17) {
            final var nextCard = CardStock.nextCard() ;
            System.out.println(name + "はもう一枚引きました" + nextCard.view);
            handCards.add(nextCard);
            System.out.println(name + "のトータルは" + getSumNumber());
            
        }
    }
}
