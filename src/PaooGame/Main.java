package PaooGame;
public class Main {

    public static void main(String[] args) {
        //Game paooGame = new Game("Golden Nuts", 1280, 640);
        Game paooGame = Game.getInstance("Golden Nuts", 1280, 640);
        paooGame.StartGame();
    }
}
