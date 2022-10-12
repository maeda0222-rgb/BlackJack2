
public class Player extends Gamer{
    
    public Player(String name) {
        super(name);
    }

    @Override
    void action() {
        while(Common.question("もう一度引きますか？「はい」or「いいえ」")){
            final var nextCard =CardStock.nextCard();
            System.out.println(name + "はもう一枚引きました" + nextCard.view);
            handCards.add(nextCard);
            System.out.println(name + "のトータルは" + getSumNumber());
            if(isBust()) {
                return;
            }
        }
        
    }
}
