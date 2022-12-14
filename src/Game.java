import java.util.Optional;

public class Game {

    public static void main(String[] args) {
        // TODO 自動生成されたメソッド・スタブ
        
        while(true) {
            //ディーラー生成
            final var dealer = new Dealer("ディーラー");
            //プレイヤー生成
            final var player = new Player("プレイヤー");
            //ディーラーの初期カード二枚
            dealer.init();
            //ディーラートータル
            dealer.action();
            //プレイヤーの初期カード二枚
            player.init();
            //プレイヤートータル
            player.action();
            //勝敗判定
            getWinner(dealer,player).ifPresentOrElse(
                    winner -> System.out.println(winner.name + "の勝ち"),
                    () -> System.out.println("ドロー"));
            if(Common.question("もう一度しますか？「はい」or「いいえ」")) {
                System.out.println("----------------");
                continue;
             }
             break;
        }
        System.out.println("終了しました");

    }
    
    public static Optional<Gamer> getWinner(Dealer dealer, Player player){
        //プレイヤーオーバー
        if(player.isBust()) {
            System.out.println("あなたがバーストしました");
            return Optional.of(dealer);
        }
        //ディーラーオーバー
        if(dealer.isBust()) {
            System.out.println("ディーラーがバーストしました");
            return Optional.of(player);
        }
        //ディーラーの勝ち
        if(dealer.getSumNumber() > player.getSumNumber()) {
            return Optional.of(dealer);
        }
        //プレイヤーの勝ち
        if(dealer.getSumNumber() < player.getSumNumber()) {
            return Optional.of(player);
        }
        //ドロー
        return Optional.empty();
    }

}
